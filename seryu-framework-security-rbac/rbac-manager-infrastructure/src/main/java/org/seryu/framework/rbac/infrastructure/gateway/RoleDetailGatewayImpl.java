package org.seryu.framework.rbac.infrastructure.gateway;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.seryu.framework.rbac.domain.dto.MenuDetailDto;
import org.seryu.framework.rbac.domain.dto.RoleDetailDto;
import org.seryu.framework.rbac.domain.dto.RoleMenuDto;
import org.seryu.framework.rbac.domain.gateway.RoleDetailGateway;
import org.seryu.framework.rbac.infrastructure.repository.Do.MenuDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.Do.RoleMenuDo;
import org.seryu.framework.rbac.infrastructure.repository.MenuDetailRepository;
import org.seryu.framework.rbac.infrastructure.repository.RoleDetailRepository;
import org.seryu.framework.rbac.infrastructure.repository.RoleMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: seryu-framework-security-rbac
 * @description: 角色操作
 * @author: xujunjie
 * @create: 2020-05-07 09:36
 */
@Service
public class RoleDetailGatewayImpl extends RoleDetailRepository implements RoleDetailGateway {
  @Autowired private RoleMenuRepository roleMenuRepository;

  @Autowired private MenuDetailRepository menuDetailRepository;

  @Override
  @Transactional
  public boolean save(RoleDetailDto dto) {
    boolean save = super.save(dto);
    if (!CollectionUtils.isEmpty(dto.getRoleMenu()) && dto.getRoleMenu().size() > 0) {
      List<RoleMenuDto> collect =
          dto.getRoleMenu().stream()
              .map(
                  info -> {
                    RoleMenuDto roleMenuDto = new RoleMenuDto();
                    roleMenuDto.setMId(info.getId());
                    roleMenuDto.setRId(dto.getId());
                    return roleMenuDto;
                  })
              .collect(Collectors.toList());
      roleMenuRepository.saveBatch(collect);
    }
    return save;
  }

  @Override
  public boolean updateById(RoleDetailDto entity) {
    List<Long> oldMids = getMenuIdsByRoleId(entity.getId());
    List<Long> newMids = null;
    if (!CollectionUtil.isEmpty(entity.getRoleMenu()) && entity.getRoleMenu().size() > 0) {
      newMids =
          entity.getRoleMenu().stream().map(info -> info.getId()).collect(Collectors.toList());
    }

    // 交集
    Collection<Long> intersection = CollectionUtil.intersection(oldMids, newMids);

    // 新增菜单
    Collection<Long> newMenu = CollectionUtil.disjunction(intersection, newMids);

    // 删除菜单
    Collection<Long> oldMenu = CollectionUtil.disjunction(intersection, oldMids);

    if (!CollectionUtil.isEmpty(oldMenu) && oldMenu.size() > 0) {
      LambdaQueryWrapper<RoleMenuDo> wrapper = new LambdaQueryWrapper();
      wrapper.in(RoleMenuDo::getMId, oldMenu).eq(RoleMenuDo::getRId, entity.getId());
      roleMenuRepository.getBaseMapper().delete(wrapper);
    }

    if (!CollectionUtil.isEmpty(newMenu) && newMenu.size() > 0) {
      roleMenuRepository.saveBatch(
          newMenu.stream()
              .map(
                  id -> {
                    RoleMenuDto roleMenuDto = new RoleMenuDto();
                    roleMenuDto.setMId(id);
                    roleMenuDto.setRId(entity.getId());
                    return roleMenuDto;
                  })
              .collect(Collectors.toList()));
    }

    return super.updateById(entity);
  }

  @Transactional
  @Override
  public boolean removeById(Serializable id) {
    LambdaQueryWrapper<RoleMenuDo> wapper = new LambdaQueryWrapper<>();
    wapper.eq(RoleMenuDo::getRId, id);
    roleMenuRepository.getBaseMapper().delete(wapper);
    return super.removeById(id);
  }

  @Override
  public RoleDetailDto getById(Serializable id) {
    RoleDetailDto roleDetailDto = super.getById(id);
    List<Long> roleMenuDos = getMenuIdsByRoleId(roleDetailDto.getId());
    if (!CollectionUtil.isEmpty(roleMenuDos)) {
      List<MenuDetailDo> menuDetailDos =
          menuDetailRepository.getBaseMapper().selectBatchIds(roleMenuDos);
      List<MenuDetailDto> menuDetailDtos =
          menuDetailRepository.getDtoConverter().coverDtoList(menuDetailDos);
      roleDetailDto.setRoleMenu(menuDetailDtos);
    }
    return roleDetailDto;
  }

  /**
   * 获取角色下菜单Id
   *
   * @param roleId
   * @return
   */
  public List<Long> getMenuIdsByRoleId(Long roleId) {
    List<RoleMenuDo> roleMenuDos = getMenuByRoleId(roleId);
    if (!CollectionUtil.isEmpty(roleMenuDos) && roleMenuDos.size() > 0) {
      return roleMenuDos.stream().map(info -> info.getMId()).collect(Collectors.toList());
    }
    return null;
  }

  public List<RoleMenuDo> getMenuByRoleId(Long roleId) {
    LambdaQueryWrapper<RoleMenuDo> wapper = new LambdaQueryWrapper<>();
    wapper.eq(RoleMenuDo::getRId, roleId);
    List<RoleMenuDo> roleMenuDos = roleMenuRepository.getBaseMapper().selectList(wapper);
    return roleMenuDos;
  }

  @Override
  public List<RoleDetailDto> getRoleListByPid(Long pid) {
    return getDtoConverter().coverDtoList(getBaseMapper().getRoleListByPid(pid));
  }
}
