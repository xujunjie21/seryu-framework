package org.seryu.framework.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.seryu.framework.rbac.client.api.cmd.PostServiceCmdI;
import org.seryu.framework.rbac.client.api.qry.PostServiceQryI;
import org.seryu.framework.rbac.client.bo.DeptDetailBo;
import org.seryu.framework.rbac.client.bo.PostDetailBo;
import org.seryu.framework.rbac.client.query.PostDetailQry;
import org.seryu.framework.web.BaseController;
import org.seryu.framework.web.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seryu-framework-security-rbac
 * @description: 岗位相关
 * @author: xujunjie
 * @create: 2020-04-23 09:56
 */
@Api(tags = "岗位", value = "/admin/post", description = "岗位")
@RestController
@RequestMapping("/admin/post")
public class PostController extends BaseController {
  private static final String TAG_NAME = "岗位";

  @Autowired private PostServiceQryI postServiceQryI;

  @Autowired private PostServiceCmdI postServiceCmdI;

  @ApiOperation(
      value = "岗位查询",
      notes = "岗位查询接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = PostDetailBo.class)
  @RequestMapping(value = "/index", method = RequestMethod.POST)
  public BaseResult page(@RequestBody PostDetailQry qry) {
    return success(postServiceQryI.page(qry));
  }

  @ApiOperation(
      value = "创建岗位",
      notes = "创建岗位",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/create", method = RequestMethod.PUT)
  public BaseResult create(@RequestBody PostDetailBo info) {
    postServiceCmdI.create(info);
    return success();
  }

  @ApiOperation(
      value = "查询岗位信息",
      notes = "查询岗位信息",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = DeptDetailBo.class)
  @RequestMapping(value = "/info", method = RequestMethod.POST)
  public BaseResult<PostDetailBo> info(@RequestBody PostDetailBo info) {
    return success(postServiceQryI.infoById(info.getId()));
  }

  @ApiOperation(
      value = "更新岗位",
      notes = "更新菜单",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public BaseResult update(@RequestBody PostDetailBo info) {
    postServiceCmdI.updateById(info);
    return success();
  }

  @ApiOperation(
      value = "删除岗位",
      notes = "删除岗位",
      httpMethod = "DELETE",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public BaseResult delete(@RequestBody @ApiParam(name = "id", value = "岗位Id") String id) {
    postServiceCmdI.deleteById(id);
    return success();
  }
}
