package org.seryu.framework.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.client.api.cmd.DictServiceCmdI;
import org.seryu.framework.rbac.client.api.qry.DictServiceQryI;
import org.seryu.framework.rbac.client.bo.DictDetailBo;
import org.seryu.framework.rbac.client.query.DictDetailQry;
import org.seryu.framework.web.BaseController;
import org.seryu.framework.web.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seryu-framework-security-rbac
 * @description: 数据字典相关
 * @author: xujunjie
 * @create: 2020-04-23 16:26
 */
@Api(tags = "数据字典", value = "admin/dict", description = "数据字典")
@RestController
@RequestMapping("/admin/dict")
public class DictController extends BaseController {
  private static final String TAG_NAME = "字典";

  @Autowired private DictServiceQryI dictServiceQryI;

  @Autowired private DictServiceCmdI dictServiceCmdI;

  @ApiOperation(
      value = "字典查询",
      notes = "字典查询接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = DictDetailBo.class)
  @RequestMapping(value = "/index", method = RequestMethod.POST)
  public BaseResult<PageData<DictDetailBo>> page(@RequestBody DictDetailQry qry) {
    return success(dictServiceQryI.page(qry));
  }

  @ApiOperation(
      value = "创建字典",
      notes = "创建字典",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/create", method = RequestMethod.PUT)
  public BaseResult create(@RequestBody DictDetailBo info) {
    dictServiceCmdI.create(info);
    return success();
  }

  @ApiOperation(
      value = "查询字典信息",
      notes = "查询字典信息",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/info", method = RequestMethod.POST)
  public BaseResult info(@RequestBody DictDetailBo info) {
    return success(dictServiceQryI.infoById(info.getId()));
  }

  @ApiOperation(
      value = "更新字典",
      notes = "更新字典",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public BaseResult update(@RequestBody DictDetailBo info) {
    dictServiceCmdI.updateById(info);
    return success();
  }

  @ApiOperation(
      value = "删除角色",
      notes = "删除角色",
      httpMethod = "DELETE",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public BaseResult delete(@RequestBody DictDetailBo info) {
    dictServiceCmdI.deleteById(info.getId());
    return success();
  }
}
