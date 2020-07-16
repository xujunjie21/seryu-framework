package org.seryu.framework.rbac.app.cmd;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.api.cmd.UserLoginServiceCmdI;
import org.seryu.framework.rbac.client.bo.CheckTokenBo;
import org.seryu.framework.rbac.client.bo.LogoutBo;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户登录
 * @author: xujunjie
 * @create: 2020-04-22 14:41
 */
@Slf4j
@Service
public class UserLoginServiceCmd implements UserLoginServiceCmdI {
  @Override
  public void logout(LogoutBo logoutBo) throws InterfacesException {

  }

  @Override
  public CheckTokenBo checkToken(String token) throws InterfacesException {
    return null; // JSON.parseObject(JsonMock.check_token, CheckTokenBo.class);
  }
}
