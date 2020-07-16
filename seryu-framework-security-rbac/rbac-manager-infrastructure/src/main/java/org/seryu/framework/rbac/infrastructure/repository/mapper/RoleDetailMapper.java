package org.seryu.framework.rbac.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.seryu.framework.db.mybatisPlugs.code.BaseMapper;
import org.seryu.framework.rbac.infrastructure.repository.Do.RoleDetailDo;

import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: Mapper 接口
 * @author xujunjie
 * @since 2020-04-30
 */
public interface RoleDetailMapper extends BaseMapper<RoleDetailDo> {
  /**
   * @description: 根据资源许可Id查询角色列表
   * @param pid
   * @return
   */
  List<RoleDetailDo> getRoleListByPid(@Param("pid") Long pid);
}
