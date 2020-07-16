package org.seryu.framework.rbac.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.rbac.domain.dto.RoleDetailDto;
import org.seryu.framework.rbac.domain.dto.RoleDetailQryDto;
import org.seryu.framework.rbac.infrastructure.repository.Do.RoleDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.RoleDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-04-30
 */
@Service
public class RoleDetailRepository
    extends BaseGatewayImpl<RoleDetailMapper, RoleDetailDo, RoleDetailDto> {
  public PageData<RoleDetailDto> page(RoleDetailQryDto qry, Page page) {
    LambdaQueryWrapper<RoleDetailDo> wrapper = new LambdaQueryWrapper();
    wrapper.like(
        !StringUtils.isEmpty(qry.getRoleName()), RoleDetailDo::getRoleName, qry.getRoleName());
    wrapper.between(
        !StringUtils.isEmpty(qry.getStartTime()) || !StringUtils.isEmpty(qry.getEndTime()),
        RoleDetailDo::getCreateDate,
        qry.getStartTime(),
        qry.getEndTime());

    return selectPage(page, wrapper, RoleDetailDo.class);
  }
}
