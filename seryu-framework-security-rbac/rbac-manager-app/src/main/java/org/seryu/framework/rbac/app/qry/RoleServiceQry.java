package org.seryu.framework.rbac.app.qry;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.rbac.client.api.qry.RoleServiceQryI;
import org.seryu.framework.rbac.client.bo.RoleDetailBo;
import org.seryu.framework.rbac.client.bo.RoleDetailQry;
import org.seryu.framework.rbac.domain.dto.RoleDetailDto;
import org.seryu.framework.rbac.domain.dto.RoleDetailQryDto;
import org.seryu.framework.rbac.domain.gateway.RoleDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;

/**
 * @program: seryu-framework-security-rbac
 * @description: 角色服务实现
 * @author: xujunjie
 * @create: 2020-04-23 13:32
 */
@Slf4j
@Service
public class RoleServiceQry implements RoleServiceQryI {
  private ConverterUtil<RoleDetailDto, RoleDetailBo> converterUtil = new ConverterUtil();

  @Autowired private RoleDetailGateway roleDetailGateway;

  @Override
  public PageData<RoleDetailBo> page(RoleDetailQry qry) {
    PageData<RoleDetailDto> results =
        roleDetailGateway.page(converterUtil.conver(qry, RoleDetailQryDto.class), qry);
    return converterUtil.converPage(results, RoleDetailBo.class);
  }

  @Override
  public RoleDetailBo infoById(Long id) throws InterfacesException {
    RoleDetailDto roleDetailDto = roleDetailGateway.getById(id);
    RoleDetailBo bo = converterUtil.conver(roleDetailDto, RoleDetailBo.class);
    if (!CollectionUtil.isEmpty(roleDetailDto.getRoleMenu())) {
      bo.setRoleMenu(
          StringUtils.collectionToCommaDelimitedString(
              roleDetailDto.getRoleMenu().stream()
                  .map(info -> info.getId())
                  .collect(Collectors.toList())));
    }
    return bo;
  }
}
