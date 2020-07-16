package org.seryu.framework.rbac.client.api.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.RoleDetailBo;

/**
 * @program: seryu-framework-security-rbac
 * @description: 角色
 * @author: xujunjie
 * @create: 2020-04-23 18:16
 */
public interface RoleServiceCmdI extends BaseCmdI {
  /**
   * @description: 创建角色
   * @param roleDetailBo 角色信息
   * @return 角色信息
   * @throws InterfacesException
   */
  RoleDetailBo create(RoleDetailBo roleDetailBo) throws InterfacesException;

  /**
   * @description: 更新角色信息
   * @param roleDetailBo 角色信息
   * @return 角色信息
   * @throws InterfacesException
   */
  RoleDetailBo updateById(RoleDetailBo roleDetailBo) throws InterfacesException;

  /**
   * @description: 删除角色信息
   * @param roleDetailBo 角色信息
   * @throws InterfacesException
   */
  void deleteById(RoleDetailBo roleDetailBo) throws InterfacesException;
}
