package org.seryu.framework.rbac.app.cmd;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.cmd.MenuServiceCmdI;
import org.seryu.framework.rbac.client.bo.MenuBo;
import org.seryu.framework.rbac.domain.dto.MenuDetailDto;
import org.seryu.framework.rbac.domain.gateway.MenuDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 菜单操作服务
 * @author: xujunjie
 * @create: 2020-04-23 18:18
 */
@Slf4j
@Service
public class MenuServiceCmd implements MenuServiceCmdI {
  @Autowired private MenuDetailGateway menuDetailGateway;

  private ConverterUtil<MenuBo, MenuDetailDto> converterUtil = new ConverterUtil<>();

  @Override
  public MenuBo create(MenuBo menuBo) throws InterfacesException {
    MenuDetailDto conver = converterUtil.conver(menuBo, MenuDetailDto.class);
    menuDetailGateway.save(conver);
    menuBo.setId(conver.getId());
    return menuBo;
  }

  @Override
  public MenuBo updateById(MenuBo menuBo) throws InterfacesException {
    MenuDetailDto conver = converterUtil.conver(menuBo, MenuDetailDto.class);
    menuDetailGateway.updateById(conver);
    return menuBo;
  }

  @Override
  public void deleteById(MenuBo info) throws InterfacesException {
    menuDetailGateway.removeById(info.getId());
  }
}
