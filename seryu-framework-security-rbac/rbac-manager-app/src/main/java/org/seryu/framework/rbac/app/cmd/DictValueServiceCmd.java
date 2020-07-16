package org.seryu.framework.rbac.app.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.cmd.DictValueServiceCmdI;
import org.seryu.framework.rbac.client.bo.DictValueDetailBo;
import org.seryu.framework.rbac.domain.dto.DictValueDetailDto;
import org.seryu.framework.rbac.domain.gateway.DictValueDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 字典操作服务
 * @author: xujunjie
 * @create: 2020-05-09 14:06
 */
@Service
public class DictValueServiceCmd implements DictValueServiceCmdI {
  @Autowired private DictValueDetailGateway dictValueDetailGateway;

  private ConverterUtil<DictValueDetailBo, DictValueDetailDto> converterUtil =
      new ConverterUtil<>();

  @Override
  public DictValueDetailBo create(DictValueDetailBo bo) throws InterfacesException {
    DictValueDetailDto conver = converterUtil.conver(bo, DictValueDetailDto.class);
    dictValueDetailGateway.save(conver);
    bo.setId(conver.getId());
    return bo;
  }

  @Override
  public DictValueDetailBo updateById(DictValueDetailBo bo) throws InterfacesException {
    DictValueDetailDto conver = converterUtil.conver(bo, DictValueDetailDto.class);
    dictValueDetailGateway.updateById(conver);
    return bo;
  }

  @Override
  public void deleteById(Long id) throws InterfacesException {
    dictValueDetailGateway.removeById(id);
  }
}
