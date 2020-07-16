package org.seryu.framework.rbac.domain.gateway;

import org.seryu.framework.data.gateway.BaseGatewayI;
import org.seryu.framework.data.page.Page;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.domain.dto.RoleDetailDto;
import org.seryu.framework.rbac.domain.dto.RoleDetailQryDto;

import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务类
 * @author xujunjie
 * @since 2020-04-30
 */
public interface RoleDetailGateway extends BaseGatewayI<RoleDetailDto> {

  PageData<RoleDetailDto> page(RoleDetailQryDto qry, Page page);

  /**
   * @description: 根据资源许可Id查询角色列表
   * @param pid 资源Id
   * @return 角色信息
   */
  List<RoleDetailDto> getRoleListByPid(Long pid);
}
