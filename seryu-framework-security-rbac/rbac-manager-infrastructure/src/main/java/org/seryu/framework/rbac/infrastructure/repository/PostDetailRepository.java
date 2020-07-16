package org.seryu.framework.rbac.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.rbac.domain.dto.PostDetailDto;
import org.seryu.framework.rbac.domain.dto.PostDetailQryDto;
import org.seryu.framework.rbac.domain.gateway.PostDetailGateway;
import org.seryu.framework.rbac.infrastructure.repository.Do.PostDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.PostDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-04-30
 */
@Service
public class PostDetailRepository
    extends BaseGatewayImpl<PostDetailMapper, PostDetailDo, PostDetailDto>
    implements PostDetailGateway {

  @Override
  public PageData<PostDetailDto> page(PostDetailQryDto qry, Page page) {
    LambdaQueryWrapper<PostDetailDo> wrapper = new LambdaQueryWrapper();
    wrapper.like(
        !StringUtils.isEmpty(qry.getPostName()), PostDetailDo::getPostName, qry.getPostName());
    return selectPage(page, wrapper, PostDetailDo.class);
  }
}
