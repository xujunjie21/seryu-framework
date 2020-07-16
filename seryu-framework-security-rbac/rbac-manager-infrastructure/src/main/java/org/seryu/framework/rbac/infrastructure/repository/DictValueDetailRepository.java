package org.seryu.framework.rbac.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.rbac.domain.dto.DictValueDetailDto;
import org.seryu.framework.rbac.domain.dto.DictValueDetailQryDto;
import org.seryu.framework.rbac.infrastructure.repository.Do.DictValueDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.DictValueDetailMapper;
import org.springframework.util.StringUtils;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-05-09
 */
public class DictValueDetailRepository
    extends BaseGatewayImpl<DictValueDetailMapper, DictValueDetailDo, DictValueDetailDto> {

  public PageData<DictValueDetailDto> page(DictValueDetailQryDto qry, Page page) {
    LambdaQueryWrapper<DictValueDetailDo> wrapper = new LambdaQueryWrapper();
    wrapper.like(
        !StringUtils.isEmpty(qry.getDictLabel()),
        DictValueDetailDo::getDictLabel,
        qry.getDictLabel());
    wrapper.like(
        !StringUtils.isEmpty(qry.getDictValue()),
        DictValueDetailDo::getDictValue,
        qry.getDictValue());
    wrapper.eq(
        !StringUtils.isEmpty(qry.getDictId()), DictValueDetailDo::getDictId, qry.getDictId());
    wrapper.eq(
        !StringUtils.isEmpty(qry.getStatus()) && !StringUtils.pathEquals("0", qry.getStatus()),
        DictValueDetailDo::getStatus,
        qry.getStatus());
    return selectPage(page, wrapper, DictValueDetailDo.class);
  }
}
