package org.seryu.framework.rbac.domain.gateway;

import org.seryu.framework.data.gateway.BaseGatewayI;
import org.seryu.framework.rbac.domain.dto.DeptDetailDto;

import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务类
 * @author xujunjie
 * @since 2020-04-30
 */
public interface DeptDetailGateway extends BaseGatewayI<DeptDetailDto> {

  /**
   * @description: 递归查询列表
   * @param parentId 父节点Id
   * @return 部门信息
   */
  List<Long> getChildrenIds(Long parentId);
}
