package org.seryu.framework.rbac.config;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.qry.PermissionServiceQryI;
import org.seryu.framework.rbac.client.bo.PermissionDetailBo;
import org.seryu.framework.security.SecurityPermissionService;
import org.seryu.framework.security.bo.SecurityPermissionDetail;
import org.seryu.framework.security.bo.SecurityRoleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: seryu-framework
 * @description:
 * @author: xujunjie
 * @create: 2020-07-16 18:48
 */
@Service
public class SecurityPermissionServiceImpl implements SecurityPermissionService {
  @Autowired private PermissionServiceQryI permissionServiceQryI;

  private ConverterUtil<SecurityPermissionDetail, PermissionDetailBo> converterUtil =
      new ConverterUtil<>();

  @Override
  public List<SecurityPermissionDetail> findAll() throws InterfacesException {
    List<PermissionDetailBo> all = permissionServiceQryI.findAll();
    if (!CollectionUtils.isEmpty(all)) {
      return all.stream().map(info -> copy(info)).collect(Collectors.toList());
    }
    return null;
  }

  @Override
  public SecurityPermissionDetail infoById(Long id) throws InterfacesException {
    return copy(permissionServiceQryI.infoById(id));
  }

  private SecurityPermissionDetail copy(PermissionDetailBo permissionDetailBo) {
    SecurityPermissionDetail conver =
        converterUtil.conver(permissionDetailBo, SecurityPermissionDetail.class);
    List<SecurityRoleDetail> list = new ArrayList<>();
    permissionDetailBo
        .getRoles()
        .forEach(info -> list.add(converterUtil.conver(info, SecurityRoleDetail.class)));
    conver.setRoles(list);
    return conver;
  }
}
