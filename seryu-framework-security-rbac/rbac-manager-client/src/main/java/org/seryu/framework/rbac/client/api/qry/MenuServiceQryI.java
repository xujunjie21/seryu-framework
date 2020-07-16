package org.seryu.framework.rbac.client.api.qry;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.MenuBo;

import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 菜单查询接口
 * @author: xujunjie
 * @create: 2020-04-22 16:23
 */
public interface MenuServiceQryI extends BaseQryI {
  /**
   * @description: 获取菜单全量列表
   * @return 菜单列表
   * @throws InterfacesException
   */
  List<MenuBo> findAll() throws InterfacesException;

  /**
   * @description: 获取菜单列表
   * @param rids 角色Id列表
   * @return 菜单信息
   * @throws InterfacesException
   */
  List<MenuBo> findAll(List<Long> rids) throws InterfacesException;

  /**
   * @description: 根据菜单Id查询菜单列表
   * @param id 菜单Id
   * @return 菜单信息
   * @throws InterfacesException
   */
  MenuBo infoById(Long id) throws InterfacesException;
}
