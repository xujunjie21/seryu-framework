package org.seryu.framework.rbac.infrastructure.repository;

import org.seryu.framework.data.gateway.BaseGatewayI;
import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.rbac.domain.dto.RoleMenuDto;
import org.seryu.framework.rbac.infrastructure.repository.Do.RoleMenuDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.RoleMenuMapper;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-05-07
 */
@Service
public class RoleMenuRepository extends BaseGatewayImpl<RoleMenuMapper, RoleMenuDo, RoleMenuDto>
    implements BaseGatewayI<RoleMenuDto> {

}
