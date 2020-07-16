package org.seryu.framework.rbac.client.api.qry;

import org.seryu.framework.data.biz.BaseQryI;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.client.bo.UserDetailBo;
import org.seryu.framework.rbac.client.bo.UserDetailQry;

/**
 * @program: seryu-framework-security
 * @description: 用户查询服务
 * @author: xujunjie
 * @create: 2020-04-23 11:03
 */
public interface UserServiceQryI extends BaseQryI {
  /**
   * @description: 根据条件查询用户列表
   * @param qry 用户查询条件
   * @return 用户列表
   */
  PageData<UserDetailBo> page(UserDetailQry qry) throws InterfacesException;

  /**
   * @description: 获取用户信息
   * @param id 用户Id
   * @return 用户信息
   * @throws InterfacesException
   */
  UserDetailBo infoById(String id) throws InterfacesException;

  /**
   * @description: 根据用户名称查询用户信息
   * @param userName 用户名称(账号)
   * @return 用户信息
   */
  UserDetailBo infoByUser(String userName);
}
