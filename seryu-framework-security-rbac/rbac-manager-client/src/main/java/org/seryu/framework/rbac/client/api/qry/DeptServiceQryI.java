package org.seryu.framework.rbac.client.api.qry;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.DeptDetailBo;

import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 部门查询接口
 * @author: xujunjie
 * @create: 2020-04-23 09:53
 */
public interface DeptServiceQryI extends BaseQryI {
  /**
   * @description: 查询部门列表
   * @return 部门信息
   * @throws InterfacesException
   */
  List<DeptDetailBo> findAll() throws InterfacesException;

  /**
   * @description: 根据菜单Id查询菜单列表
   * @param id 部门Id
   * @return 部门信息
   * @throws InterfacesException
   */
  DeptDetailBo infoById(Long id);
}
