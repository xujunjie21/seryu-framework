package org.seryu.framework.rbac.app.qry;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.data.util.StringUtil;
import org.seryu.framework.rbac.client.api.qry.MenuServiceQryI;
import org.seryu.framework.rbac.client.bo.MenuBo;
import org.seryu.framework.rbac.domain.dto.MenuDetailDto;
import org.seryu.framework.rbac.domain.gateway.MenuDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 菜单业务查询接口
 * @author: xujunjie
 * @create: 2020-04-22 17:16
 */
@Service
public class MenuServiceQry implements MenuServiceQryI {
  @Autowired private MenuDetailGateway menuDetailGateway;

  private ConverterUtil<MenuDetailDto, MenuBo> converterUtil = new ConverterUtil<>();

  @Override
  public List<MenuBo> findAll(List<Long> rids) throws InterfacesException {
    List<MenuBo> menuBos =
        converterUtil.converList(menuDetailGateway.getListByRoles(rids), MenuBo.class);
    return buildByRecursive(menuBos);
  }

  @Override
  public List<MenuBo> findAll() throws InterfacesException {
    List<MenuBo> menuBos = converterUtil.converList(menuDetailGateway.list(), MenuBo.class);
    return buildByRecursive(menuBos);
  }

  @Override
  public MenuBo infoById(Long id) throws InterfacesException {
    return converterUtil.conver(menuDetailGateway.getById(id), MenuBo.class);
  }

  /**
   * 使用递归方法建树
   *
   * @param menuBos
   * @return
   */
  public static List<MenuBo> buildByRecursive(List<MenuBo> menuBos) {
    List<MenuBo> trees = new ArrayList<>();
    for (MenuBo menuBo : menuBos) {
      if (0 == menuBo.getParentId()) {
        trees.add(findChildren(menuBo, menuBos));
      }
    }
    return trees;
  }

  /**
   * 递归查找子节点
   *
   * @param menuBos
   * @return
   */
  public static MenuBo findChildren(MenuBo menuBo, List<MenuBo> menuBos) {
    for (MenuBo it : menuBos) {
      if (StringUtil.isEq(menuBo.getId() + "", it.getParentId() + "")) {
        if (menuBo.getChildrenList() == null) {
          menuBo.setChildrenList(new ArrayList<MenuBo>());
        }
        menuBo.getChildrenList().add(findChildren(it, menuBos));
      }
    }
    return menuBo;
  }
}
