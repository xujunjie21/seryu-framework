package org.seryu.framework.rbac.domain.gateway;

import org.seryu.framework.data.gateway.BaseGatewayI;
import org.seryu.framework.rbac.domain.dto.MenuDetailDto;

import java.util.List;

/**
 * @description: 服务类
 * @author xujunjie
 * @since 2020-04-30
 */
public interface MenuDetailGateway extends BaseGatewayI<MenuDetailDto> {
  /**
   * @description: 根据角色Id列表查询
   * @param rids 角色Id列表
   * @return 菜单信息
   */
  public List<MenuDetailDto> getListByRoles(List<Long> rids);
}
