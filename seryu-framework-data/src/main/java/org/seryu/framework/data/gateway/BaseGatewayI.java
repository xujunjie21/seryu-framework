package org.seryu.framework.data.gateway;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @program: seryu-framework
 * @description: 持久层对应领域服务接口
 * @author: xujunjie
 * @create: 2020-04-27 09:55
 */
public interface BaseGatewayI<T> {
  /** 默认批次提交数量 */
  int DEFAULT_BATCH_SIZE = 1000;

  /**
   * @description: 获取领域转换器
   * @return
   */
  DtoConverter getDtoConverter();

  /**
   * @description: 批量保存
   * @param dtoList 领域对象列表
   * @param batchSize 一次批量次数
   * @return boolean 是否成功
   */
  boolean saveBatch(Collection<T> dtoList, int batchSize);

  /**
   * @description: 持久化领域对象
   * @param dto 领域对象
   * @return boolean 是否成功
   */
  boolean saveOrUpdate(T dto);

  /**
   * @description: 批量持久化领域对象
   * @param dtoList 领域对象列表
   * @param batchSize 一次批量次数
   * @return boolean 是否成功
   */
  boolean saveOrUpdateBatch(Collection<T> dtoList, int batchSize);

  /**
   * @description: 根据Id批量更新领域对象
   * @param dtoList 领域对象列表
   * @param batchSize 一次批量次数
   * @return boolean 是否成功
   */
  boolean updateBatchById(Collection<T> dtoList, int batchSize);

  /**
   * @description: 保存领域对象
   * @param dto 领域对象
   * @return boolean 是否成功
   */
  boolean save(T dto);

  /**
   * @description: 批量持久化领域对象
   * @param entityList 领域对象列表
   * @return boolean 是否成功
   */
  boolean saveBatch(Collection<T> entityList);

  /**
   * @description: 批量持久化领域对象
   * @param entityList 领域对象列表
   * @return boolean 是否成功
   */
  boolean saveOrUpdateBatch(Collection<T> entityList);

  /**
   * @description: 根据id删除领域对象
   * @param id 对象Id
   * @return boolean 是否成功
   */
  boolean removeById(Serializable id);

  /**
   * @description: 根据条件山吃领域对象
   * @param columnMap 对象属性名称和值集合
   * @return boolean 是否成功
   */
  boolean removeByMap(Map<String, Object> columnMap);

  /**
   * @description: 根据Ids列表删除领域对象
   * @param idList id列表
   * @return boolean 是否成功
   */
  boolean removeByIds(Collection<? extends Serializable> idList);

  /**
   * @description: 根据Id更新领域对象
   * @param entity 领域对象
   * @return boolean 是否成功
   */
  boolean updateById(T entity);

  /**
   * @description: 根据Id列表批量更新领域对象
   * @param dtoList 领域Id列表
   * @return boolean 是否成功
   */
  boolean updateBatchById(Collection<T> dtoList);

  /**
   * @description: 根据领域Id查询领域对象信息
   * @param id 领域Id
   * @return 领域信息
   */
  T getById(Serializable id);

  /**
   * @description: 根据id集合查询领域信息列表
   * @param idList 领域Id列表
   * @return list 查询领域信息列表
   */
  List<T> listByIds(Collection<? extends Serializable> idList);

  /**
   * @description: 根据领域属性名称查询领域信息列表
   * @param columnMap 领域字段属性
   * @return list 领域信息列表
   */
  List<T> listByMap(Map<String, Object> columnMap);

  /**
   * @description: 查询数据总数
   * @return int 数量
   */
  int count();

  /**
   * @description: 查询全量列表
   * @return 领域信息列表
   */
  List<T> list();
}
