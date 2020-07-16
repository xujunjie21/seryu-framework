package org.seryu.framework.rbac.app.cmd;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.cmd.PermissionServiceCmdI;
import org.seryu.framework.rbac.client.bo.PermissionDetailBo;
import org.seryu.framework.rbac.domain.dto.PermissionDetailDto;
import org.seryu.framework.rbac.domain.gateway.PermissionDetailGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 菜单操作服务
 * @author: xujunjie
 * @create: 2020-04-23 18:18
 */
@Slf4j
@Service
public class PermissionServiceCmd implements PermissionServiceCmdI {
  @Autowired private PermissionDetailGateway permissionDetailGateway;

  private ConverterUtil<PermissionDetailBo, PermissionDetailDto> converterUtil =
      new ConverterUtil<>();

  @Override
  public PermissionDetailBo create(PermissionDetailBo bo) throws InterfacesException {
    PermissionDetailDto detailDto = converterUtil.conver(bo, PermissionDetailDto.class);
    BeanUtils.copyProperties(bo, detailDto);
    permissionDetailGateway.save(detailDto);
    bo.setId(detailDto.getId());
    return bo;
  }

  @Override
  public PermissionDetailBo updateById(PermissionDetailBo bo) throws InterfacesException {
    PermissionDetailDto detailDto = converterUtil.conver(bo, PermissionDetailDto.class);
    permissionDetailGateway.updateById(detailDto);
    return bo;
  }

  @Override
  public void deleteById(PermissionDetailBo info) throws InterfacesException {
    permissionDetailGateway.removeById(info.getId());
  }
}
