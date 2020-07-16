package org.seryu.framework.rbac.client.api.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.PostDetailBo;

/**
 * @program: seryu-framework-security-rbac
 * @description:
 * @author: xujunjie
 * @create: 2020-04-23 18:16
 */
public interface PostServiceCmdI extends BaseCmdI {
  /**
   * @description: 创建部门
   * @param postDetailBo 部门信息
   * @return 部门信息
   * @throws InterfacesException
   */
  PostDetailBo create(PostDetailBo postDetailBo) throws InterfacesException;

  /**
   * @description: 更新部门信息
   * @param postDetailBo 部门信息
   * @return 部门信息
   * @throws InterfacesException
   */
  PostDetailBo updateById(PostDetailBo postDetailBo) throws InterfacesException;

  /**
   * @description: 删除部门信息
   * @param id 部门Id
   * @throws InterfacesException
   */
  void deleteById(String id) throws InterfacesException;
}
