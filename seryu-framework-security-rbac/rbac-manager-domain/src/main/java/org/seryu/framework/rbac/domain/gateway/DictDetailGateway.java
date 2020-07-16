package org.seryu.framework.rbac.domain.gateway;

import org.seryu.framework.data.gateway.BaseGatewayI;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.domain.dto.DictDetailDto;
import org.seryu.framework.rbac.domain.dto.DictDetailQryDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务类
 * @author xujunjie
 * @since 2020-05-09
 */
public interface DictDetailGateway extends BaseGatewayI<DictDetailDto> {
  PageData<DictDetailDto> page(DictDetailQryDto qry, Page page);

  /**
   * @description: 根据字典类型描述查询信息
   * @param dictType 字典类型
   * @return 字典信息
   */
  DictDetailDto getByDictType(String dictType);
}
