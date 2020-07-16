package org.seryu.framework.rbac.client.api.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.PermissionDetailBo;

/**
 * @program: seryu-framework-security-rbac
 * @description:
 * @author: xujunjie
 * @create: 2020-04-23 18:16
 */
public interface PermissionServiceCmdI extends BaseCmdI {
  /**
   * @description: 创建资源许可
   * @param bo 资源信息
   * @return 资源信息
   * @throws InterfacesException
   */
  PermissionDetailBo create(PermissionDetailBo bo) throws InterfacesException;

  /**
   * @description: 更新菜单信息
   * @param bo 资源信息
   * @return 资源信息
   * @throws InterfacesException
   */
  PermissionDetailBo updateById(PermissionDetailBo bo) throws InterfacesException;

  /**
   * @description: 删除菜单信息
   * @param info 资源信息
   * @throws InterfacesException
   */
  void deleteById(PermissionDetailBo info) throws InterfacesException;
}
