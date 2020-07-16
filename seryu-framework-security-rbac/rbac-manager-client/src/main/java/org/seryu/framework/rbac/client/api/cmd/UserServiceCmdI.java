package org.seryu.framework.rbac.client.api.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.UserDetailBo;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户操作服务
 * @author: xujunjie
 * @create: 2020-04-23 11:03
 */
public interface UserServiceCmdI extends BaseCmdI {
  /**
   * @description: 创建用户信息
   * @param userDetailBo 用户信息
   * @return 用户信息
   * @throws InterfacesException
   */
  UserDetailBo create(UserDetailBo userDetailBo) throws InterfacesException;

  /**
   * @description: 更新用户信息
   * @param userDetailDto
   * @return
   * @throws InterfacesException
   */
  UserDetailBo updateById(UserDetailBo userDetailDto) throws InterfacesException;

  /**
   * @description: 删除用户信息
   * @param id 用户Id
   * @throws InterfacesException
   */
  void deleteById(String id) throws InterfacesException;

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
