package org.seryu.framework.rbac.infrastructure.repository;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.seryu.framework.data.enums.StatusEnum;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.db.mybatisPlugs.extPoint.CmdExtPointI;
import org.seryu.framework.rbac.domain.dto.UserDetailDto;
import org.seryu.framework.rbac.domain.dto.UserDetailQryDto;
import org.seryu.framework.rbac.domain.gateway.DeptDetailGateway;
import org.seryu.framework.rbac.infrastructure.repository.Do.UserDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.UserDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-04-30
 */
public class UserDetailRepository
    extends BaseGatewayImpl<UserDetailMapper, UserDetailDo, UserDetailDto>
    implements CmdExtPointI<UserDetailDo> {
  @Autowired private DeptDetailGateway deptDetailGateway;

  public PageData<UserDetailDto> page(UserDetailQryDto qry, Page page) {
    LambdaQueryWrapper<UserDetailDo> wrapper = new LambdaQueryWrapper();
    wrapper.like(
        !StringUtils.isEmpty(qry.getUserName()), UserDetailDo::getUserName, qry.getUserName());
    wrapper.like(!StringUtils.isEmpty(qry.getPhone()), UserDetailDo::getPhone, qry.getPhone());
    wrapper.in(
        !StringUtils.isEmpty(qry.getDeptId()),
        UserDetailDo::getDeptId,
        deptDetailGateway.getChildrenIds(qry.getDeptId()));
    wrapper.between(
        !StringUtils.isEmpty(qry.getStartTime()) || !StringUtils.isEmpty(qry.getEndTime()),
        UserDetailDo::getCreateDate,
        qry.getStartTime(),
        qry.getEndTime());
    return selectPage(page, wrapper, UserDetailDo.class);
  }

  /**
   * @param userName
   * @return
   */
  public UserDetailDto infoByUser(String userName) {
    LambdaQueryWrapper<UserDetailDo> wrapper = new LambdaQueryWrapper();
    wrapper.eq(!StringUtils.isEmpty(userName), UserDetailDo::getUserName, userName);
    wrapper.eq(UserDetailDo::getStatus, StatusEnum.ENABLE.getCode());
    return getDtoConverter().coverDto(getBaseMapper().selectOne(wrapper));
  }

  /**
   * 密码加盐处理
   *
   * @param entity
   * @return
   */
  @Override
  public UserDetailDo savePoint(UserDetailDo entity) {
    return entity.setPassword(pwd(entity.getPassword(), entity.getSalt()));
  }

  /**
   * 密码加盐处理
   *
   * @param entity
   * @return
   */
  @Override
  public UserDetailDo updatePoint(UserDetailDo entity) {
    return entity.setPassword(pwd(entity.getPassword(), entity.getSalt()));
  }

  /**
   * 获取加密后的密码
   *
   * @param pwd
   * @return
   */
  public String pwd(String pwd, String salt) {
    return MD5.create().digestHex(pwd + (null == salt ? "" : salt));
  }
}
