package org.seryu.framework.rbac.app.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.cmd.DictServiceCmdI;
import org.seryu.framework.rbac.client.bo.DictDetailBo;
import org.seryu.framework.rbac.domain.dto.DictDetailDto;
import org.seryu.framework.rbac.domain.gateway.DictDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 字典操作服务
 * @author: xujunjie
 * @create: 2020-05-09 14:06
 */
@Service
public class DictServiceCmd implements DictServiceCmdI {
  @Autowired private DictDetailGateway dictDetailGateway;

  private ConverterUtil<DictDetailBo, DictDetailDto> converterUtil = new ConverterUtil<>();

  @Override
  public DictDetailBo create(DictDetailBo bo) throws InterfacesException {
    DictDetailDto conver = converterUtil.conver(bo, DictDetailDto.class);
    dictDetailGateway.save(conver);
    bo.setId(conver.getId());
    return bo;
  }

  @Override
  public DictDetailBo updateById(DictDetailBo bo) throws InterfacesException {
    DictDetailDto conver = converterUtil.conver(bo, DictDetailDto.class);
    dictDetailGateway.updateById(conver);
    return bo;
  }

  @Override
  public void deleteById(Long id) throws InterfacesException {
    dictDetailGateway.removeById(id);
  }
}
