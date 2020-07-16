package org.seryu.framework.rbac.config;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.qry.RoleServiceQryI;
import org.seryu.framework.rbac.client.bo.RoleDetailBo;
import org.seryu.framework.rbac.client.bo.RoleDetailQry;
import org.seryu.framework.security.SecurityRoleService;
import org.seryu.framework.security.bo.SecurityRoleDetail;
import org.seryu.framework.security.bo.SecurityRoleDetailQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seryu-framework
 * @description:
 * @author: xujunjie
 * @create: 2020-07-16 18:51
 */
@Service
public class SecurityRoleServiceImpl implements SecurityRoleService {
  @Autowired private RoleServiceQryI roleServiceQryI;

  private ConverterUtil<SecurityRoleDetail, RoleDetailBo> converterUtil = new ConverterUtil<>();

  @Override
  public PageData<SecurityRoleDetail> page(SecurityRoleDetailQry qry) {
    return converterUtil.converPage(
        roleServiceQryI.page(
            converterUtil.conver(SecurityRoleDetailQry.class, RoleDetailQry.class)),
        SecurityRoleDetail.class);
  }

  @Override
  public SecurityRoleDetail infoById(Long id) throws InterfacesException {
    return converterUtil.conver(roleServiceQryI.infoById(id), SecurityRoleDetail.class);
  }
}
