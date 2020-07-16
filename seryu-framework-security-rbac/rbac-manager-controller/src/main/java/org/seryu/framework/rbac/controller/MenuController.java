package org.seryu.framework.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.seryu.framework.rbac.client.api.cmd.MenuServiceCmdI;
import org.seryu.framework.rbac.client.api.qry.MenuServiceQryI;
import org.seryu.framework.rbac.client.api.qry.UserServiceQryI;
import org.seryu.framework.rbac.client.bo.MenuBo;
import org.seryu.framework.rbac.client.bo.UserDetailBo;
import org.seryu.framework.security.dto.UserDto;
import org.seryu.framework.web.BaseController;
import org.seryu.framework.web.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: seryu-framework-security-rbac
 * @description: 菜单管理
 * @author: xujunjie
 * @create: 2020-04-22 16:14
 */
@Api(tags = "菜单", value = "/admin/menu", description = "菜单")
@RestController
@RequestMapping("/admin/menu")
public class MenuController extends BaseController {
  private static final String TAG_NAME = "菜单";

  @Autowired private MenuServiceQryI menuServiceQryI;

  @Autowired private MenuServiceCmdI menuServiceCmdI;

  @Autowired private UserServiceQryI userServiceQryI;

  @ApiOperation(
      value = "菜单全量",
      notes = "菜单全量接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = MenuBo.class)
  @RequestMapping(value = "/find_all_menu", method = RequestMethod.POST)
  public BaseResult<List<MenuBo>> all() {
    UserDto userDto;
    try {
      userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    } catch (Exception e) {
      throw new AccessDeniedException("用户失效，请重新登录");
    }

    UserDetailBo userDetailBo = userServiceQryI.infoById(userDto.getId());
    return success(
        menuServiceQryI.findAll(
            Arrays.asList(userDetailBo.getUserRole().split(",")).stream()
                .map(info -> Long.valueOf(info))
                .collect(Collectors.toList())));
  }

  @ApiOperation(
      value = "菜单全量",
      notes = "菜单全量接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = MenuBo.class)
  @RequestMapping(value = "/menus", method = RequestMethod.POST)
  public BaseResult<List<MenuBo>> menus() {
    return success(menuServiceQryI.findAll());
  }

  @ApiOperation(
      value = "创建菜单",
      notes = "创建菜单",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/create", method = RequestMethod.PUT)
  public BaseResult create(@RequestBody MenuBo info) {
    menuServiceCmdI.create(info);
    return success();
  }

  /**
   * 查询菜单信息
   *
   * @param info
   * @return
   */
  @ApiOperation(
      value = "查询菜单信息",
      notes = "查询菜单信息",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/info", method = RequestMethod.POST)
  public BaseResult info(@RequestBody MenuBo info) {
    return success(menuServiceQryI.infoById(info.getId()));
  }

  /**
   * 更新菜单
   *
   * @param info
   * @return
   */
  @ApiOperation(
      value = "更新菜单",
      notes = "更新菜单",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public BaseResult update(@RequestBody MenuBo info) {
    menuServiceCmdI.updateById(info);
    return success();
  }

  /**
   * 删除菜单
   *
   * @param info
   * @return
   */
  @ApiOperation(
      value = "删除菜单",
      notes = "删除菜单",
      httpMethod = "DELETE",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public BaseResult delete(@RequestBody MenuBo info) {
    menuServiceCmdI.deleteById(info);
    return success();
  }
}
