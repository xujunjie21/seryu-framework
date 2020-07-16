package org.seryu.framework.rbac.app.qry;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.qry.UserServiceQryI;
import org.seryu.framework.rbac.client.bo.UserDetailBo;
import org.seryu.framework.rbac.client.bo.UserDetailQry;
import org.seryu.framework.rbac.domain.dto.UserDetailDto;
import org.seryu.framework.rbac.domain.dto.UserDetailQryDto;
import org.seryu.framework.rbac.domain.gateway.UserDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户查询服务
 * @author: xujunjie
 * @create: 2020-04-23 11:13
 */
@Slf4j
@Service
public class UserServiceQry implements UserServiceQryI {
  @Autowired private UserDetailGateway userDetailGateway;

  private ConverterUtil<UserDetailDto, UserDetailBo> converterUtil = new ConverterUtil<>();

  @Override
  public PageData<UserDetailBo> page(UserDetailQry query) {
    PageData<UserDetailDto> results =
        userDetailGateway.page(converterUtil.conver(query, UserDetailQryDto.class), query);
    return converterUtil.converPage(results, UserDetailBo.class);
  }

  @Override
  public UserDetailBo infoById(String id) throws InterfacesException {
    return converterUtil.conver(userDetailGateway.getById(id), UserDetailBo.class);
  }

  @Override
  public UserDetailBo infoByUser(String userName) {
    return converterUtil.conver(userDetailGateway.infoByUser(userName), UserDetailBo.class);
  }
}
