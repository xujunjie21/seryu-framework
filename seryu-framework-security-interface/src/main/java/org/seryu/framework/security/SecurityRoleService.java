package org.seryu.framework.security;

import org.seryu.framework.data.biz.BaseQryI;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.security.bo.SecurityRoleDetail;
import org.seryu.framework.security.bo.SecurityRoleDetailQry;

/**
 * @program: seryu-framework-security
 * @description: 角色服务
 * @author: xujunjie
 * @create: 2020-04-23 11:53
 */
public interface SecurityRoleService extends BaseQryI {
  /**
   * @description: 获取角色列表
   * @param qry 角色信息查询
   * @return 角色信息
   */
  PageData<SecurityRoleDetail> page(SecurityRoleDetailQry qry);

  /**
   * @description: 根据角色Id查询角色信息
   * @param id 角色Id
   * @return 角色信息
   * @throws InterfacesException
   */
  SecurityRoleDetail infoById(Long id) throws InterfacesException;
}
