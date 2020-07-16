package org.seryu.framework.rbac.infrastructure.repository;

import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.rbac.domain.dto.PermissionDetailDto;
import org.seryu.framework.rbac.infrastructure.repository.Do.PermissionDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.PermissionDetailMapper;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-05-06
 */
@Service
public class PermissionDetailRepository
    extends BaseGatewayImpl<PermissionDetailMapper, PermissionDetailDo, PermissionDetailDto> {

}
