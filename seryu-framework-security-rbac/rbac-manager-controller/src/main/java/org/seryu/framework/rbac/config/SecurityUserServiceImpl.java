package org.seryu.framework.rbac.config;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.qry.UserServiceQryI;
import org.seryu.framework.rbac.client.bo.UserDetailBo;
import org.seryu.framework.rbac.client.bo.UserDetailQry;
import org.seryu.framework.security.SecurityUserService;
import org.seryu.framework.security.bo.SecurityUserDetail;
import org.seryu.framework.security.bo.SecurityUserDetailQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework
 * @description:
 * @author: xujunjie
 * @create: 2020-07-16 18:54
 */
@Service
public class SecurityUserServiceImpl implements SecurityUserService {

  @Autowired private UserServiceQryI userServiceQryI;

  private ConverterUtil<SecurityUserDetail, UserDetailBo> converterUtil = new ConverterUtil<>();

  @Override
  public PageData<SecurityUserDetail> page(SecurityUserDetailQry qry) throws InterfacesException {
    return converterUtil.converPage(
        userServiceQryI.page(converterUtil.conver(qry, UserDetailQry.class)),
        SecurityUserDetail.class);
  }

  @Override
  public SecurityUserDetail infoById(String id) throws InterfacesException {
    return converterUtil.conver(userServiceQryI.infoById(id), SecurityUserDetail.class);
  }

  @Override
  public SecurityUserDetail infoByUser(String userName) {
    return converterUtil.conver(userServiceQryI.infoByUser(userName), SecurityUserDetail.class);
  }
}
