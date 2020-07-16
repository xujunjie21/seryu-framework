package org.seryu.framework.rbac.infrastructure.repository;

import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.rbac.domain.dto.MenuDetailDto;
import org.seryu.framework.rbac.infrastructure.repository.Do.MenuDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.MenuDetailMapper;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-04-30
 */
@Service
public class MenuDetailRepository
    extends BaseGatewayImpl<MenuDetailMapper, MenuDetailDo, MenuDetailDto> {

}
