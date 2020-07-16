package org.seryu.framework.rbac.domain.gateway;

import org.seryu.framework.data.gateway.BaseGatewayI;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.domain.dto.PostDetailDto;
import org.seryu.framework.rbac.domain.dto.PostDetailQryDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务类
 * @author xujunjie
 * @since 2020-04-30
 */
public interface PostDetailGateway extends BaseGatewayI<PostDetailDto> {
  PageData<PostDetailDto> page(PostDetailQryDto qry, Page page);
}
