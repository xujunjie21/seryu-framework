package org.seryu.framework.rbac.app.qry;

import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.qry.DictValueServiceQryI;
import org.seryu.framework.rbac.client.bo.DictValueDetailBo;
import org.seryu.framework.rbac.client.query.DictValueDetailQry;
import org.seryu.framework.rbac.domain.dto.DictValueDetailDto;
import org.seryu.framework.rbac.domain.dto.DictValueDetailQryDto;
import org.seryu.framework.rbac.domain.gateway.DictValueDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 查询字典信息列表
 * @author: xujunjie
 * @create: 2020-04-23 16:41
 */
@Service
public class DictValueServiceQry implements DictValueServiceQryI {
  @Autowired private DictValueDetailGateway dictValueDetailGateway;
  private ConverterUtil<DictValueDetailBo, DictValueDetailDto> converterUtil =
      new ConverterUtil<>();

  @Override
  public PageData<DictValueDetailBo> page(DictValueDetailQry qry) {
    PageData<DictValueDetailDto> results =
        dictValueDetailGateway.page(converterUtil.conver(qry, DictValueDetailQryDto.class), qry);
    return converterUtil.converPage(results, DictValueDetailBo.class);
  }

  @Override
  public DictValueDetailBo infoById(Long id) {
    return converterUtil.conver(dictValueDetailGateway.getById(id), DictValueDetailBo.class);
  }
}
