package org.seryu.framework.rbac.infrastructure.repository;

import org.seryu.framework.data.gateway.BaseGatewayI;
import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.rbac.domain.dto.MenuPermissionDto;
import org.seryu.framework.rbac.infrastructure.repository.Do.MenuPermissionDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.MenuPermissionMapper;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-05-07
 */
@Service
public class MenuPermissionRepository
    extends BaseGatewayImpl<MenuPermissionMapper, MenuPermissionDo, MenuPermissionDto>
    implements BaseGatewayI<MenuPermissionDto> {

}
