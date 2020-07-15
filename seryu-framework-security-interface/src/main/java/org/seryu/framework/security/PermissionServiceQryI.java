package org.seryu.framework.security;

import org.seryu.framework.data.biz.BaseQryI;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.security.bo.PermissionDetailBo;

import java.util.List;

/**
 * @program: seryu-framework-security
 * @description: 菜单查询接口
 * @author: xujunjie
 * @create: 2020-04-22 16:23
 */
public interface PermissionServiceQryI extends BaseQryI {
  /**
   * @description: 获取菜单全量列表
   * @return 资源列表
   * @throws InterfacesException
   */
  List<PermissionDetailBo> findAll() throws InterfacesException;

  /**
   * @description: 根据菜单Id查询菜单列表
   * @param id 资源Id
   * @return 资源信息
   * @throws InterfacesException
   */
  PermissionDetailBo infoById(Long id) throws InterfacesException;
}
