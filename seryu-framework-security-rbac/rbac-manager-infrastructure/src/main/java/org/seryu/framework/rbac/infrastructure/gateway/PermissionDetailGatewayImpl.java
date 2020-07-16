package org.seryu.framework.rbac.infrastructure.gateway;

import cn.hutool.core.collection.CollectionUtil;
import org.seryu.framework.rbac.domain.dto.PermissionDetailDto;
import org.seryu.framework.rbac.domain.gateway.PermissionDetailGateway;
import org.seryu.framework.rbac.infrastructure.repository.PermissionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 资源
 * @author: xujunjie
 * @create: 2020-05-07 11:43
 */
@Service
public class PermissionDetailGatewayImpl extends PermissionDetailRepository
    implements PermissionDetailGateway {
  @Autowired private RoleDetailGatewayImpl roleDetailGateway;

  @Override
  public List<PermissionDetailDto> list() {
    List<PermissionDetailDto> list = super.list();
    if (!CollectionUtil.isEmpty(list) && list.size() > 0) {
      list.forEach(info -> info.setRoles(roleDetailGateway.getRoleListByPid(info.getId())));
    }
    return list;
  }
}
