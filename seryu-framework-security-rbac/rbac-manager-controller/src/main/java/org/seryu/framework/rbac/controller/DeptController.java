package org.seryu.framework.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.seryu.framework.rbac.client.api.cmd.DeptServiceCmdI;
import org.seryu.framework.rbac.client.api.qry.DeptServiceQryI;
import org.seryu.framework.rbac.client.bo.DeptDetailBo;
import org.seryu.framework.rbac.client.bo.MenuBo;
import org.seryu.framework.web.BaseController;
import org.seryu.framework.web.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seryu-framework-security-rbac
 * @description: 部门相关
 * @author: xujunjie
 * @create: 2020-04-23 09:56
 */
@Api(tags = "部门", value = "/admin/dept", description = "部门")
@RestController
@RequestMapping("/admin/dept")
public class DeptController extends BaseController {
  private static final String TAG_NAME = "部门";

  @Autowired private DeptServiceQryI deptServiceQryI;
  @Autowired private DeptServiceCmdI deptServiceCmdI;

  @ApiOperation(
      value = "部门全量",
      notes = "部门全量接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = MenuBo.class)
  @RequestMapping(value = "/findall", method = RequestMethod.POST)
  public BaseResult page() {
    return success(deptServiceQryI.findAll());
  }

  @ApiOperation(
      value = "创建部门",
      notes = "创建部门",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/create", method = RequestMethod.PUT)
  public BaseResult create(@RequestBody DeptDetailBo info) {
    deptServiceCmdI.create(info);
    return success();
  }

  @ApiOperation(
      value = "查询部门信息",
      notes = "查询部门信息",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = DeptDetailBo.class)
  @RequestMapping(value = "/info", method = RequestMethod.POST)
  public BaseResult<DeptDetailBo> info(@RequestBody DeptDetailBo info) {
    return success(deptServiceQryI.infoById(info.getId()));
  }

  @ApiOperation(
      value = "更新部门",
      notes = "更新菜单",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public BaseResult update(@RequestBody DeptDetailBo info) {
    deptServiceCmdI.updateById(info);
    return success();
  }

  @ApiOperation(
      value = "删除部门",
      notes = "删除部门",
      httpMethod = "DELETE",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public BaseResult delete(@RequestBody @ApiParam(name = "id", value = "部门Id") String id) {
    deptServiceCmdI.deleteById(id);
    return success();
  }
}
