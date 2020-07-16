package org.seryu.framework.rbac.client.api.qry;

import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.client.bo.DictValueDetailBo;
import org.seryu.framework.rbac.client.query.DictValueDetailQry;

/**
 * @program: seryu-framework-security-rbac
 * @description: 查询数据字典服务
 * @author: xujunjie
 * @create: 2020-04-23 16:36
 */
public interface DictValueServiceQryI extends BaseQryI {
  /**
   * @description: 获取数据字典列表
   * @param qry 字典内容
   * @return 字典内容列表
   */
  PageData<DictValueDetailBo> page(DictValueDetailQry qry);

  /**
   * @description: 根据字典Id查询字典信息
   * @param id 字典内容信息
   * @return
   */
  DictValueDetailBo infoById(Long id);
}
