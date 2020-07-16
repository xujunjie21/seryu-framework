package org.seryu.framework.rbac.app.cmd;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.cmd.UserServiceCmdI;
import org.seryu.framework.rbac.client.bo.UserDetailBo;
import org.seryu.framework.rbac.domain.dto.UserDetailDto;
import org.seryu.framework.rbac.domain.gateway.UserDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户操作服务
 * @author: xujunjie
 * @create: 2020-04-23 17:20
 */
@Slf4j
@Service
public class UserServiceCmd implements UserServiceCmdI {
  private ConverterUtil<UserDetailBo, UserDetailDto> converterUtil = new ConverterUtil<>();

  @Autowired private UserDetailGateway userDetailGateway;

  @Override
  public UserDetailBo create(UserDetailBo userDetailDto) throws InterfacesException {
    UserDetailDto dto = converterUtil.conver(userDetailDto, UserDetailDto.class);

    // 使用雪花算法生成ID
    dto.setId(IdUtil.createSnowflake(0, 1).nextIdStr());
    userDetailGateway.save(dto);
    userDetailDto.setId(dto.getId());
    return userDetailDto;
  }

  @Override
  public UserDetailBo updateById(UserDetailBo userDetailDto) throws InterfacesException {
    UserDetailDto dto = converterUtil.conver(userDetailDto, UserDetailDto.class);
    userDetailGateway.updateById(dto);
    return userDetailDto;
  }

  @Override
  public void deleteById(String id) throws InterfacesException {
    userDetailGateway.removeById(id);
  }

  @Override
  public void updatePwd(String userId, String oldPwd, String newPwd) {
    userDetailGateway.updatePwd(userId, oldPwd, newPwd);
  }

  @Override
  public void updatePwdAdmin(String userId, String newPwd) {
    userDetailGateway.updatePwdAdmin(userId, newPwd);
  }
}
