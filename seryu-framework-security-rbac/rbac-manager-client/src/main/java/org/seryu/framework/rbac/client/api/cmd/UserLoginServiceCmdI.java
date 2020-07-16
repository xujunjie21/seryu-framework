package org.seryu.framework.rbac.client.api.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.CheckTokenBo;
import org.seryu.framework.rbac.client.bo.LogoutBo;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户登录接口
 * @author: xujunjie
 * @create: 2020-04-22 12:24
 */
public interface UserLoginServiceCmdI {

  /**
   * @description: 用户登出
   * @throws InterfacesException
   */
  void logout(LogoutBo logoutBo) throws InterfacesException;

  /**
   * @description: 校验token是否有效
   * @param token 登录token
   * @return 验证token
   * @throws InterfacesException
   */
  CheckTokenBo checkToken(String token) throws InterfacesException;
}
