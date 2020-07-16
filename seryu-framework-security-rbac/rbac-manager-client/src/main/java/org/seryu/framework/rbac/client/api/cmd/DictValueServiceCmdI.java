package org.seryu.framework.rbac.client.api.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.DictValueDetailBo;

/**
 * @program: seryu-framework-security-rbac
 * @description: 字典内容信息
 * @author: xujunjie
 * @create: 2020-04-23 18:16
 */
public interface DictValueServiceCmdI extends BaseCmdI {
  /**
   * @description: 创建字典
   * @param info 字典内容信息
   * @return 字典内容
   * @throws InterfacesException
   */
  DictValueDetailBo create(DictValueDetailBo info) throws InterfacesException;

  /**
   * @description: 更新字典信息
   * @param info 字典内容信息
   * @return 字典内容信息
   * @throws InterfacesException
   */
  DictValueDetailBo updateById(DictValueDetailBo info) throws InterfacesException;

  /**
   * @description: 删除字典信息
   * @param id 字典内容Id
   * @throws InterfacesException
   */
  void deleteById(Long id) throws InterfacesException;
}
