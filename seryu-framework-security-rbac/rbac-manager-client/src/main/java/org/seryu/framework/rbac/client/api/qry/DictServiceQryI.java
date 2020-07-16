package org.seryu.framework.rbac.client.api.qry;

import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.client.bo.DictDetailBo;
import org.seryu.framework.rbac.client.query.DictDetailQry;

/**
 * @program: seryu-framework-security-rbac
 * @description: 查询数据字典服务
 * @author: xujunjie
 * @create: 2020-04-23 16:36
 */
public interface DictServiceQryI extends BaseQryI {
  /**
   * @description: 获取数据字典列表
   * @param qry 字典查询条件
   * @return 字典列表
   */
  PageData<DictDetailBo> page(DictDetailQry qry);

  /**
   * @description: 根据字典Id查询字典信息
   * @param id 字典Id
   * @return 字典信息
   * @throws org.seryu.framework.data.exception.InterfacesException
   */
  DictDetailBo infoById(Long id);
}
