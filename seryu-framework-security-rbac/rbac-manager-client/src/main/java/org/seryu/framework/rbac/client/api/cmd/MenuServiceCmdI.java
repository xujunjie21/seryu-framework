package org.seryu.framework.rbac.client.api.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.MenuBo;

/**
 * @program: seryu-framework-security-rbac
 * @description: 菜单信息
 * @author: xujunjie
 * @create: 2020-04-23 18:16
 */
public interface MenuServiceCmdI extends BaseCmdI {
  /**
   * @description: 创建菜单
   * @param menuBo 菜单信息
   * @return 菜单信息
   * @throws InterfacesException
   */
  MenuBo create(MenuBo menuBo) throws InterfacesException;

  /**
   * @description: 更新菜单信息
   * @param menuBo 菜单信息
   * @return 菜单信息
   * @throws InterfacesException
   */
  MenuBo updateById(MenuBo menuBo) throws InterfacesException;

  /**
   * @description: 删除菜单信息
   * @param info 菜单信息
   * @throws InterfacesException
   */
  void deleteById(MenuBo info) throws InterfacesException;
}
