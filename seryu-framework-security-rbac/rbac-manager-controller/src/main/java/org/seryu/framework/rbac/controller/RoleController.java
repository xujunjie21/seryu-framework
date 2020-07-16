package org.seryu.framework.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.seryu.framework.rbac.client.api.cmd.RoleServiceCmdI;
import org.seryu.framework.rbac.client.api.qry.RoleServiceQryI;
import org.seryu.framework.rbac.client.bo.PostDetailBo;
import org.seryu.framework.rbac.client.bo.RoleDetailBo;
import org.seryu.framework.rbac.client.bo.RoleDetailQry;
import org.seryu.framework.web.BaseController;
import org.seryu.framework.web.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seryu-framework-security-rbac
 * @description: 角色相关
 * @author: xujunjie
 * @create: 2020-04-23 09:56
 */
@Api(tags = "角色", value = "/admin/role", description = "角色")
@RestController
@RequestMapping("/admin/role")
public class RoleController extends BaseController {
  private static final String TAG_NAME = "角色";

  @Autowired private RoleServiceQryI roleServiceQryI;

  @Autowired private RoleServiceCmdI roleServiceCmdI;

  /**
   * 角色查询
   *
   * @param qry
   * @return
   */
  @ApiOperation(
      value = "角色查询",
      notes = "角色查询接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = PostDetailBo.class)
  @RequestMapping(value = "/index", method = RequestMethod.POST)
  public BaseResult page(@RequestBody RoleDetailQry qry) {
    return success(roleServiceQryI.page(qry));
  }

  @ApiOperation(
      value = "创建角色",
      notes = "创建角色",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/create", method = RequestMethod.PUT)
  public BaseResult create(@RequestBody RoleDetailBo info) {
    roleServiceCmdI.create(info);
    return success();
  }

  @ApiOperation(
      value = "查询角色信息",
      notes = "查询角色信息",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/info", method = RequestMethod.POST)
  public BaseResult info(@RequestBody RoleDetailBo info) {
    return success(roleServiceQryI.infoById(info.getId()));
  }

  @ApiOperation(
      value = "更新角色",
      notes = "更新角色",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public BaseResult update(@RequestBody RoleDetailBo info) {
    roleServiceCmdI.updateById(info);
    return success();
  }

  @ApiOperation(
      value = "删除角色",
      notes = "删除角色",
      httpMethod = "DELETE",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public BaseResult delete(@RequestBody RoleDetailBo roleDetailBo) {
    roleServiceCmdI.deleteById(roleDetailBo);
    return success();
  }
}
