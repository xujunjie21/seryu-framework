package org.seryu.framework.rbac.client.api.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.DeptDetailBo;

/**
 * @program: seryu-framework-security-rbac
 * @description: 部门信息
 * @author: xujunjie
 * @create: 2020-04-23 18:16
 */
public interface DeptServiceCmdI extends BaseCmdI {
  /**
   * 创建部门
   *
   * @param menuDto
   * @return
   * @throws InterfacesException
   */
  DeptDetailBo create(DeptDetailBo menuDto) throws InterfacesException;

  /**
   * 更新部门信息
   *
   * @param menuDto
   * @return
   * @throws InterfacesException
   */
  DeptDetailBo updateById(DeptDetailBo menuDto) throws InterfacesException;

  /**
   * 删除部门信息
   *
   * @param id
   * @throws InterfacesException
   */
  void deleteById(String id) throws InterfacesException;
}
