package org.seryu.framework.rbac.app.qry;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.qry.PostServiceQryI;
import org.seryu.framework.rbac.client.bo.PostDetailBo;
import org.seryu.framework.rbac.client.query.PostDetailQry;
import org.seryu.framework.rbac.domain.dto.PostDetailDto;
import org.seryu.framework.rbac.domain.dto.PostDetailQryDto;
import org.seryu.framework.rbac.domain.gateway.PostDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 岗位服务
 * @author: xujunjie
 * @create: 2020-04-23 11:58
 */
@Service
public class PostServiceQry implements PostServiceQryI {
  @Autowired private PostDetailGateway postDetailGateway;

  private ConverterUtil<PostDetailDto, PostDetailBo> converterUtil = new ConverterUtil<>();

  @Override
  public PageData<PostDetailBo> page(PostDetailQry qry) {
    PageData<PostDetailDto> results =
        postDetailGateway.page(converterUtil.conver(qry, PostDetailQryDto.class), qry);
    return converterUtil.converPage(results, PostDetailBo.class);
  }

  @Override
  public PostDetailBo infoById(Long id) throws InterfacesException {
    return converterUtil.conver(postDetailGateway.getById(id), PostDetailBo.class);
  }
}
