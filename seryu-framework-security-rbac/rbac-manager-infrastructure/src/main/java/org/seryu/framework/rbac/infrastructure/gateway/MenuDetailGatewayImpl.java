package org.seryu.framework.rbac.infrastructure.gateway;

import org.seryu.framework.rbac.domain.dto.MenuDetailDto;
import org.seryu.framework.rbac.domain.gateway.MenuDetailGateway;
import org.seryu.framework.rbac.infrastructure.repository.MenuDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description:
 * @author: xujunjie
 * @create: 2020-05-07 14:37
 */
@Service
public class MenuDetailGatewayImpl extends MenuDetailRepository implements MenuDetailGateway {
  @Override
  public List<MenuDetailDto> getListByRoles(List<Long> rids) {
    return getDtoConverter().coverDtoList(getBaseMapper().getListByRoles(rids));
  }
}
