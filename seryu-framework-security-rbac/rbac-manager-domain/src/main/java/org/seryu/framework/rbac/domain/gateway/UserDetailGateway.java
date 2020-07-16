package org.seryu.framework.rbac.domain.gateway;

import org.seryu.framework.data.gateway.BaseGatewayI;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.domain.dto.UserDetailDto;
import org.seryu.framework.rbac.domain.dto.UserDetailQryDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务类
 * @author xujunjie
 * @since 2020-04-30
 */
public interface UserDetailGateway extends BaseGatewayI<UserDetailDto> {
  /**
   * @description: 根据条件分页查询
   * @param qry 用户查询信息
   * @param page 分页信息
   * @return 用户信息列表
   */
  PageData<UserDetailDto> page(UserDetailQryDto qry, Page page);

  /**
   * @description: 根据用户名称查询用户信息
   * @param userName 用户名称
   * @return 用户信息
   */
  UserDetailDto infoByUser(String userName);

  /**
   * @description: 修改密码
   * @param userId 用户Id
   * @param oldPwd 原始密码
   * @param newPwd 新密码
   */
  void updatePwd(String userId, String oldPwd, String newPwd);

  /**
   * @description: 修改密码
   * @param userId 用户Id
   * @param newPwd 新密码
   */
  void updatePwdAdmin(String userId, String newPwd);
}
