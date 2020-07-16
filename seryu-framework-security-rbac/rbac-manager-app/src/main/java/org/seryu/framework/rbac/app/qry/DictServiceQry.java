package org.seryu.framework.rbac.app.qry;

import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.qry.DictServiceQryI;
import org.seryu.framework.rbac.client.bo.DictDetailBo;
import org.seryu.framework.rbac.client.query.DictDetailQry;
import org.seryu.framework.rbac.domain.dto.DictDetailDto;
import org.seryu.framework.rbac.domain.dto.DictDetailQryDto;
import org.seryu.framework.rbac.domain.gateway.DictDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 字典查询
 * @author: xujunjie
 * @create: 2020-05-09 14:11
 */
@Service
public class DictServiceQry implements DictServiceQryI {
  @Autowired private DictDetailGateway dictDetailGateway;
  private ConverterUtil<DictDetailBo, DictDetailDto> converterUtil = new ConverterUtil<>();

  @Override
  public PageData<DictDetailBo> page(DictDetailQry qry) {
    PageData<DictDetailDto> results =
        dictDetailGateway.page(converterUtil.conver(qry, DictDetailQryDto.class), qry);
    return converterUtil.converPage(results, DictDetailBo.class);
  }

  @Override
  public DictDetailBo infoById(Long id) {
    return converterUtil.conver(dictDetailGateway.getById(id), DictDetailBo.class);
  }
}
