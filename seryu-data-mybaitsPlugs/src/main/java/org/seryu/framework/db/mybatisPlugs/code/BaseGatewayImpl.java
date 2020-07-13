package org.seryu.framework.db.mybatisPlugs.code;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.*;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;
import org.seryu.framework.data.dto.BaseDto;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.StringUtil;
import org.seryu.framework.db.mybatisPlugs.enums.OrderByEnum;
import org.seryu.framework.db.mybatisPlugs.extPoint.CmdExtPointI;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: seryu-framework
 * @description: 持久层对应领域服务接口实现
 * @author: xujunjie
 * @create: 2020-04-27 09:48
 */
@Slf4j
@Getter
public abstract class BaseGatewayImpl<M extends BaseMapper<T>, T, D extends BaseDto>
    implements BaseGatewayI<D>, CmdExtPointI<T> {
  @Autowired protected M baseMapper;

  @Autowired private SqlSession sqlSession;

  @Override
  public M getBaseMapper() {
    return baseMapper;
  }

  protected Class<?> entityClass = currentModelClass();

  @Autowired protected DtoConverter<T, D> dtoConverter;

  protected Class<T> currentModelClass() {
    return (Class<T>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
  }

  /**
   * @description: 批量操作 SqlSession
   * */
  protected SqlSession sqlSessionBatch() {
    return SqlHelper.sqlSessionBatch(currentModelClass());
  }

  /**
   * @description: 获取 SqlStatement
   * @param sqlMethod ignore
   * @return ignore
   */
  protected String sqlStatement(SqlMethod sqlMethod) {
    return SqlHelper.table(entityClass).getSqlStatement(sqlMethod.getMethod());
  }

  @org.springframework.transaction.annotation.Transactional(rollbackFor = {Exception.class})
  public boolean saveBatch(Collection<D> dtoList, int batchSize) {
    String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
    try (SqlSession batchSqlSession = sqlSessionBatch()) {
      int i = 0;
      for (D dto : dtoList) {
        T entity = getDtoConverter().coverDo(dto);
        batchSqlSession.insert(sqlStatement, entity);
        if (i >= 1 && i % batchSize == 0) {
          batchSqlSession.flushStatements();
        }
        i++;
      }
      batchSqlSession.flushStatements();
    }
    return true;
  }

  @org.springframework.transaction.annotation.Transactional(rollbackFor = {Exception.class})
  public boolean saveOrUpdate(D dto) {
    if (null != dto) {
      Class<?> cls = getDtoConverter().coverDo(dto).getClass();
      TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
      Assert.notNull(tableInfo, "错误:无法执行。因为找不到实体的TableInfo缓存！");
      String keyProperty = tableInfo.getKeyProperty();
      Assert.notEmpty(keyProperty, "错误: 无法执行。因为在实体中找不到id列!");
      Object idVal = ReflectionKit.getMethodValue(cls, dto, tableInfo.getKeyProperty());
      return StringUtils.checkValNull(idVal) || Objects.isNull(getById((Serializable) idVal))
          ? save(dto)
          : updateById(dto);
    }
    return false;
  }

  @org.springframework.transaction.annotation.Transactional(rollbackFor = {Exception.class})
  public boolean saveOrUpdateBatch(Collection<D> dtoList, int batchSize) {
    Assert.notEmpty(dtoList, "错误: dtoList 不能为空");
    Class<?> cls = currentModelClass();
    TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
    Assert.notNull(tableInfo, "错误: 无法执行。因为找不到实体的TableInfo缓存!");
    String keyProperty = tableInfo.getKeyProperty();
    Assert.notEmpty(keyProperty, "错误: 无法执行。因为在实体中找不到id为的列!");
    try (SqlSession batchSqlSession = sqlSessionBatch()) {
      int i = 0;
      for (D dto : dtoList) {
        T entity = getDtoConverter().coverDo(dto);
        Object idVal = ReflectionKit.getMethodValue(cls, entity, keyProperty);
        if (StringUtils.checkValNull(idVal) || Objects.isNull(getById((Serializable) idVal))) {
          entity = savePoint(entity);
          batchSqlSession.insert(sqlStatement(SqlMethod.INSERT_ONE), entity);
        } else {
          entity = updatePoint(entity);
          MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap<>();
          param.put(Constants.ENTITY, entity);
          batchSqlSession.update(sqlStatement(SqlMethod.UPDATE_BY_ID), param);
        }
        if (i >= 1 && i % batchSize == 0) {
          batchSqlSession.flushStatements();
        }
        i++;
      }
      batchSqlSession.flushStatements();
    }
    return true;
  }

  @org.springframework.transaction.annotation.Transactional(rollbackFor = {Exception.class})
  public boolean updateBatchById(Collection<D> dtoList, int batchSize) {
    Assert.notEmpty(dtoList, "错误: dtoList 不能为空");
    String sqlStatement = sqlStatement(SqlMethod.UPDATE_BY_ID);
    try (SqlSession batchSqlSession = sqlSessionBatch()) {
      int i = 0;
      for (D dto : dtoList) {
        T entity = getDtoConverter().coverDo(dto);
        MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap<>();
        param.put(Constants.ENTITY, entity);
        batchSqlSession.update(sqlStatement, param);
        if (i >= 1 && i % batchSize == 0) {
          batchSqlSession.flushStatements();
        }
        i++;
      }
      batchSqlSession.flushStatements();
    }
    return true;
  }

  public boolean save(D dto) {
    T t = getDtoConverter().coverDo(dto);
    boolean b = SqlHelper.retBool(getBaseMapper().insert(savePoint(t)));

    boolean isIdField = true;
    try {
      dto.getClass().getDeclaredField("id");
    } catch (NoSuchFieldException e) {
      isIdField = false;
    }
    if (b && isIdField) BeanUtil.setFieldValue(dto, "id", BeanUtil.getFieldValue(t, "id"));
    return b;
  }

  @org.springframework.transaction.annotation.Transactional(rollbackFor = {Exception.class})
  public boolean saveBatch(Collection<D> entityList) {
    return saveBatch(entityList, DEFAULT_BATCH_SIZE);
  }

  @org.springframework.transaction.annotation.Transactional(rollbackFor = {Exception.class})
  public boolean saveOrUpdateBatch(Collection<D> entityList) {
    return saveOrUpdateBatch(entityList, DEFAULT_BATCH_SIZE);
  }

  public boolean removeById(Serializable id) {
    return SqlHelper.retBool(getBaseMapper().deleteById(id));
  }

  public boolean removeByMap(Map<String, Object> columnMap) {
    Assert.notEmpty(columnMap, "错误：删除Id不能为空");
    return SqlHelper.retBool(getBaseMapper().deleteByMap(columnMap));
  }

  public boolean removeByIds(Collection<? extends Serializable> idList) {
    if (CollectionUtils.isEmpty(idList)) {
      return false;
    }
    return SqlHelper.retBool(getBaseMapper().deleteBatchIds(idList));
  }

  public boolean updateById(D entity) {
    return SqlHelper.retBool(getBaseMapper().updateById(getDtoConverter().coverDo(entity)));
  }

  @org.springframework.transaction.annotation.Transactional(rollbackFor = {Exception.class})
  public boolean updateBatchById(Collection<D> dtoList) {
    return updateBatchById(dtoList, DEFAULT_BATCH_SIZE);
  }

  public D getById(Serializable id) {
    return getDtoConverter().coverDto(getBaseMapper().selectById(id));
  }

  public List<D> listByIds(Collection<? extends Serializable> idList) {
    return getDtoConverter().coverDtoList(getBaseMapper().selectBatchIds(idList));
  }

  public List<D> listByMap(Map<String, Object> columnMap) {
    return getDtoConverter().coverDtoList(getBaseMapper().selectByMap(columnMap));
  }

  public int count() {
    return getBaseMapper().selectCount(Wrappers.emptyWrapper());
  }

  public List<D> list() {
    return getDtoConverter().coverDtoList(getBaseMapper().selectList(Wrappers.emptyWrapper()));
  }

  public PageData<D> selectPage(
      Page page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper, Class<T> entityClass) {
    com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> pageMybatis =
        new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(
            page.getPageNo(), page.getPageSize());
    orderBy(page, pageMybatis, entityClass);
    IPage<T> result = getBaseMapper().selectPage(pageMybatis, queryWrapper);
    return getPageData(result, page);
  }

  protected PageData<D> getPageData(IPage<T> result, Page page) {
    PageData<D> pageData = new PageData<D>();
    page.setTotalPage(result.getPages());
    page.setTotalCount(result.getTotal());
    page.setPageNo(result.getCurrent());
    page.setPageSize(result.getSize());
    pageData.setPage(page);
    pageData.setList(getDtoConverter().coverDtoList(result.getRecords()));
    return pageData;
  }

  protected void orderBy(
      Page page,
      com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> bPage,
      Class<T> entityClass) {

    String[] columns = {"update_date"};

    if (!StringUtil.isEmpty(page.getOrderColumnName())) {
      columns = page.getOrderColumnName().split(",");

      // 校验属性名或者TABLE——FILED中是否存在，如果不存在，自动清除
    }

    boolean isAsc = StringUtil.isEq(page.getOrderType(), OrderByEnum.ASC.getKey());
    if (StringUtil.isEmpty(page.getOrderType()) || !isAsc) {
      bPage.setOrders(OrderItem.descs(columns));
    } else {
      bPage.setOrders(OrderItem.ascs(columns));
    }
  }
}
