package org.seryu.framework.rbac.app.cmd;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.data.util.StringUtil;
import org.seryu.framework.rbac.client.api.cmd.RoleServiceCmdI;
import org.seryu.framework.rbac.client.bo.RoleDetailBo;
import org.seryu.framework.rbac.domain.dto.MenuDetailDto;
import org.seryu.framework.rbac.domain.dto.RoleDetailDto;
import org.seryu.framework.rbac.domain.gateway.RoleDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: seryu-framework-security-rbac
 * @description: 菜单操作服务
 * @author: xujunjie
 * @create: 2020-04-23 18:18
 */
@Slf4j
@Service
public class RoleServiceCmd implements RoleServiceCmdI {
  @Autowired private RoleDetailGateway roleDetailGateway;

  private ConverterUtil<RoleDetailBo, RoleDetailDto> converterUtil = new ConverterUtil<>();

  @Override
  public RoleDetailBo create(RoleDetailBo roleDetailBo) throws InterfacesException {
    RoleDetailDto roleDetailDto = setMenuByMids(roleDetailBo);
    roleDetailGateway.save(roleDetailDto);
    roleDetailBo.setId(roleDetailDto.getId());
    return roleDetailBo;
  }

  @Override
  public RoleDetailBo updateById(RoleDetailBo roleDetailBo) throws InterfacesException {
    RoleDetailDto roleDetailDto = setMenuByMids(roleDetailBo);
    roleDetailGateway.updateById(roleDetailDto);
    return roleDetailBo;
  }

  /**
   * 设置菜单
   *
   * @param roleDetailBo
   * @return
   */
  private RoleDetailDto setMenuByMids(RoleDetailBo roleDetailBo) {
    RoleDetailDto roleDetailDto = converterUtil.conver(roleDetailBo, RoleDetailDto.class);
    if (!StringUtil.isEmpty(roleDetailBo.getRoleMenu())) {
      List<MenuDetailDto> collect =
          Arrays.asList(roleDetailBo.getRoleMenu().split(",")).stream()
              .map(
                  info -> {
                    MenuDetailDto menuDetailDto = new MenuDetailDto();
                    menuDetailDto.setId(Long.valueOf(info));
                    return menuDetailDto;
                  })
              .collect(Collectors.toList());
      roleDetailDto.setRoleMenu(collect);
    }
    return roleDetailDto;
  }

  @Override
  public void deleteById(RoleDetailBo roleDetailBo) throws InterfacesException {
    roleDetailGateway.removeById(roleDetailBo.getId());
  }
}
