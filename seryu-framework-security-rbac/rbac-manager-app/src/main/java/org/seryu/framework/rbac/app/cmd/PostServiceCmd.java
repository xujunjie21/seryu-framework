package org.seryu.framework.rbac.app.cmd;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.cmd.PostServiceCmdI;
import org.seryu.framework.rbac.client.bo.PostDetailBo;
import org.seryu.framework.rbac.domain.dto.PostDetailDto;
import org.seryu.framework.rbac.domain.gateway.PostDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 部门操作服务
 * @author: xujunjie
 * @create: 2020-04-23 18:18
 */
@Slf4j
@Service
public class PostServiceCmd implements PostServiceCmdI {
  @Autowired private PostDetailGateway postDetailGateway;

  private ConverterUtil<PostDetailBo, PostDetailDto> converterUtil = new ConverterUtil<>();

  @Override
  public PostDetailBo create(PostDetailBo bo) throws InterfacesException {
    PostDetailDto conver = converterUtil.conver(bo, PostDetailDto.class);
    postDetailGateway.save(conver);
    bo.setId(conver.getId());
    return bo;
  }

  @Override
  public PostDetailBo updateById(PostDetailBo bo) throws InterfacesException {
    PostDetailDto conver = converterUtil.conver(bo, PostDetailDto.class);
    postDetailGateway.updateById(conver);
    return bo;
  }

  @Override
  public void deleteById(String id) throws InterfacesException {
    postDetailGateway.removeById(id);
  }
}
