package org.seryu.framework.rbac.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.seryu.framework.db.mybatisPlugs.code.BaseGatewayImpl;
import org.seryu.framework.rbac.domain.dto.DeptDetailDto;
import org.seryu.framework.rbac.domain.gateway.DeptDetailGateway;
import org.seryu.framework.rbac.infrastructure.repository.Do.DeptDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.mapper.DeptDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 服务实现类
 * @author xujunjie
 * @since 2020-04-30
 */
@Service
public class DeptDetailRepository
    extends BaseGatewayImpl<DeptDetailMapper, DeptDetailDo, DeptDetailDto>
    implements DeptDetailGateway {
  /**
   * @description: 根据父ID查询部门列表
   * @param parentId 父Id
   * @return
   */
  public List<Long> getChildrenIds(Long parentId) {
    if (null == parentId) {
      parentId = 0l;
    }

    List<Long> ids = new ArrayList<>();
    findChildren(parentId, ids);
    return ids;
  }

  /**
   * @description: 递归查询列表
   * @param parentId
   * @param ids
   * @return
   */
  private void findChildren(Long parentId, List<Long> ids) {
    LambdaQueryWrapper<DeptDetailDo> wrapper = new LambdaQueryWrapper();
    wrapper.eq(!StringUtils.isEmpty(parentId), DeptDetailDo::getParentId, parentId);
    List<DeptDetailDo> deptDetailDos = getBaseMapper().selectList(wrapper);

    if (null != deptDetailDos && deptDetailDos.size() > 0) {
      deptDetailDos.forEach(info -> findChildren(info.getId(), ids));
    }

    ids.add(parentId);
  }
}
