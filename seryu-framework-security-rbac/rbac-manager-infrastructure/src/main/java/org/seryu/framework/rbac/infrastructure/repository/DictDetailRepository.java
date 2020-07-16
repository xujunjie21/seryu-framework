package org.seryu.framework.rbac.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.rbac.domain.dto.DictDetailDto;
import org.seryu.framework.rbac.domain.dto.DictDetailQryDto;
import org.seryu.framework.rbac.domain.gateway.DictDetailGateway;
import org.seryu.framework.rbac.infrastructure.repository.Do.DictDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.DictDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-05-09
 */
@Service
public class DictDetailRepository
    extends BaseGatewayImpl<DictDetailMapper, DictDetailDo, DictDetailDto>
    implements DictDetailGateway {

  @Override
  public PageData<DictDetailDto> page(DictDetailQryDto qry, Page page) {
    LambdaQueryWrapper<DictDetailDo> wrapper = new LambdaQueryWrapper();
    wrapper.like(
        !StringUtils.isEmpty(qry.getDictName()), DictDetailDo::getDictName, qry.getDictName());
    wrapper.like(
        !StringUtils.isEmpty(qry.getDictType()), DictDetailDo::getDictType, qry.getDictType());
    wrapper.between(
        !StringUtils.isEmpty(qry.getStartTime()) || !StringUtils.isEmpty(qry.getEndTime()),
        DictDetailDo::getCreateDate,
        qry.getStartTime(),
        qry.getEndTime());
    return selectPage(page, wrapper, DictDetailDo.class);
  }

  @Override
  public DictDetailDto getByDictType(String dictType) {
    LambdaQueryWrapper<DictDetailDo> wrapper = new LambdaQueryWrapper();
    wrapper.eq(DictDetailDo::getDictType, dictType);
    return getDtoConverter().coverDto(getBaseMapper().selectOne(wrapper));
  }
}
