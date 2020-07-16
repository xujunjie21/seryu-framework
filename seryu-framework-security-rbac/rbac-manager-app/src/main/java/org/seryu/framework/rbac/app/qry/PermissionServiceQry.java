package org.seryu.framework.rbac.app.qry;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.qry.PermissionServiceQryI;
import org.seryu.framework.rbac.client.bo.PermissionDetailBo;
import org.seryu.framework.rbac.client.bo.RoleDetailBo;
import org.seryu.framework.rbac.domain.dto.PermissionDetailDto;
import org.seryu.framework.rbac.domain.gateway.PermissionDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @program: seryu-framework-security-rbac
 * @description:
 * @author: xujunjie
 * @create: 2020-05-07 11:23
 */
@Slf4j
@Service
public class PermissionServiceQry implements PermissionServiceQryI {
  private ConverterUtil<PermissionDetailDto, PermissionDetailBo> converterUtil =
      new ConverterUtil();

  @Autowired private PermissionDetailGateway permissionDetailGateway;

  @Override
  public List<PermissionDetailBo> findAll() throws InterfacesException {
    log.info("查询所有资源");
    List<PermissionDetailBo> permissionDetailBos =
        converterUtil.converList(permissionDetailGateway.list(), PermissionDetailBo.class);
    permissionDetailBos.forEach(
        info -> {
          List<RoleDetailBo> roleDetailBos =
              converterUtil.converList(info.getRoles(), RoleDetailBo.class);
          info.getRoles().clear();
          info.getRoles().addAll(roleDetailBos);
        });
    return permissionDetailBos;
  }

  @Override
  public PermissionDetailBo infoById(Long id) throws InterfacesException {
    return converterUtil.conver(permissionDetailGateway.getById(id), PermissionDetailBo.class);
  }
}
