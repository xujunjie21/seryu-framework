package org.seryu.framework.rbac.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.seryu.framework.db.mybatisPlugs.code.BaseMapper;
import org.seryu.framework.rbac.infrastructure.repository.Do.MenuDetailDo;

import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: Mapper 接口
 * @author xujunjie
 * @since 2020-04-30
 */
public interface MenuDetailMapper extends BaseMapper<MenuDetailDo> {
  List<MenuDetailDo> getListByRoles(@Param("rids") List<Long> rids);
}
