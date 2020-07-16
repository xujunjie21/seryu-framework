package org.seryu.framework.rbac.infrastructure.gateway;

import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.StringUtil;
import org.seryu.framework.rbac.domain.dto.DictDetailDto;
import org.seryu.framework.rbac.domain.dto.DictValueDetailDto;
import org.seryu.framework.rbac.domain.dto.DictValueDetailQryDto;
import org.seryu.framework.rbac.domain.gateway.DictDetailGateway;
import org.seryu.framework.rbac.domain.gateway.DictValueDetailGateway;
import org.seryu.framework.rbac.infrastructure.repository.DictValueDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 字典查询
 * @author: xujunjie
 * @create: 2020-05-09 15:14
 */
@Service
public class DictValueDetailGatewayImpl extends DictValueDetailRepository
    implements DictValueDetailGateway {
  @Autowired private DictDetailGateway dictDetailGateway;

  @Override
  public PageData<DictValueDetailDto> page(DictValueDetailQryDto qry, Page page) {
    if (!StringUtil.isEmpty(qry.getDictType())) {
      DictDetailDto dictDetailDto = dictDetailGateway.getByDictType(qry.getDictType());
      if (null != dictDetailDto) {
        qry.setDictId(dictDetailDto.getId());
      } else {
        return new PageData<>();
      }
    }
    return super.page(qry, page);
  }
}
