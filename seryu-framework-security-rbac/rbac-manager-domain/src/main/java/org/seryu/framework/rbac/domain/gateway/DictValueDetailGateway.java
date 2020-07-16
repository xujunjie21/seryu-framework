package org.seryu.framework.rbac.domain.gateway;

import org.seryu.framework.data.gateway.BaseGatewayI;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.domain.dto.DictValueDetailDto;
import org.seryu.framework.rbac.domain.dto.DictValueDetailQryDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务类
 * @author xujunjie
 * @since 2020-05-09
 */
public interface DictValueDetailGateway extends BaseGatewayI<DictValueDetailDto> {
  PageData<DictValueDetailDto> page(DictValueDetailQryDto qry, Page page);
}
