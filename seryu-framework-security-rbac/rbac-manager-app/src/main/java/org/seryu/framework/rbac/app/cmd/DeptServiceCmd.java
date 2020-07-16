package org.seryu.framework.rbac.app.cmd;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.cmd.DeptServiceCmdI;
import org.seryu.framework.rbac.client.bo.DeptDetailBo;
import org.seryu.framework.rbac.domain.dto.DeptDetailDto;
import org.seryu.framework.rbac.domain.gateway.DeptDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 部门操作服务
 * @author: xujunjie
 * @create: 2020-04-23 18:18
 */
@Service
public class DeptServiceCmd implements DeptServiceCmdI {
  @Autowired private DeptDetailGateway deptDetailGateway;

  private ConverterUtil<DeptDetailBo, DeptDetailDto> converterUtil = new ConverterUtil();

  @Override
  public DeptDetailBo create(DeptDetailBo bo) throws InterfacesException {
    DeptDetailDto conver = converterUtil.conver(bo, DeptDetailDto.class);
    deptDetailGateway.save(conver);
    bo.setId(conver.getId());
    return bo;
  }

  @Override
  public DeptDetailBo updateById(DeptDetailBo bo) throws InterfacesException {
    DeptDetailDto conver = converterUtil.conver(bo, DeptDetailDto.class);
    deptDetailGateway.updateById(conver);
    return bo;
  }

  @Override
  public void deleteById(String id) throws InterfacesException {
    deptDetailGateway.removeById(id);
  }
}
