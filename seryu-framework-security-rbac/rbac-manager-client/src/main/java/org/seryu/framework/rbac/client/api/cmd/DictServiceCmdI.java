package org.seryu.framework.rbac.client.api.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.rbac.client.bo.DictDetailBo;

/**
 * @program: seryu-framework-security-rbac
 * @description:
 * @author: xujunjie
 * @create: 2020-04-23 18:16
 */
public interface DictServiceCmdI extends BaseCmdI {
  /**
   * @description: 创建字典
   * @param info 字典信息
   * @return 字典信息
   * @throws InterfacesException
   */
  DictDetailBo create(DictDetailBo info) throws InterfacesException;

  /**
   * @description: 更新字典信息
   * @param info 字典信息
   * @return 字典信息
   * @throws InterfacesException
   */
  DictDetailBo updateById(DictDetailBo info) throws InterfacesException;

  /**
   * @description: 删除字典信息
   * @param id 字典Id
   * @throws InterfacesException
   */
  void deleteById(Long id) throws InterfacesException;
}
