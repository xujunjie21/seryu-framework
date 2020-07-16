package org.seryu.framework.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.data.util.StringUtil;
import org.seryu.framework.rbac.client.api.cmd.DictValueServiceCmdI;
import org.seryu.framework.rbac.client.api.qry.DictValueServiceQryI;
import org.seryu.framework.rbac.client.bo.DictValueDetailBo;
import org.seryu.framework.rbac.client.query.DictValueDetailQry;
import org.seryu.framework.web.BaseController;
import org.seryu.framework.web.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seryu-framework-security-rbac
 * @description: 数据字典内容相关
 * @author: xujunjie
 * @create: 2020-04-23 16:26
 */
@Api(tags = "数据字典内容", value = "/admin/dictData", description = "数据字典内容")
@RestController
@RequestMapping("/admin/dict/data")
public class DictValueController extends BaseController {
  private static final String TAG_NAME = "字典内容";

  @Autowired private DictValueServiceQryI dictValueServiceQryI;

  @Autowired private DictValueServiceCmdI dictValueServiceCmdI;

  @ApiOperation(
      value = "数据字典内容",
      notes = "数据字典接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = DictValueDetailBo.class)
  @RequestMapping(value = "/index", method = RequestMethod.POST)
  public BaseResult page(@RequestBody DictValueDetailQry qry) {
    PageData<DictValueDetailBo> page = dictValueServiceQryI.page(qry);
    // 解决前端dict_value字典为null无法解析
    if (null != page && null != page.getList() && page.getList().size() > 0) {
      page.getList()
          .forEach(
              info -> {
                if (StringUtil.isEmpty(info.getDictValue())) info.setDictValue("");
              });
    }
    return success(page);
  }

  @ApiOperation(
      value = "创建字典",
      notes = "创建字典",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/create", method = RequestMethod.PUT)
  public BaseResult create(@RequestBody DictValueDetailBo info) {
    dictValueServiceCmdI.create(info);
    return success();
  }

  @ApiOperation(
      value = "查询字典内容信息",
      notes = "查询字典内容信息",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/info", method = RequestMethod.POST)
  public BaseResult info(@RequestBody DictValueDetailBo info) {
    return success(dictValueServiceQryI.infoById(info.getId()));
  }

  @ApiOperation(
      value = "更新字典内容",
      notes = "更新字典内容",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public BaseResult update(@RequestBody DictValueDetailBo info) {
    dictValueServiceCmdI.updateById(info);
    return success();
  }

  @ApiOperation(
      value = "删除字典内容",
      notes = "删除字典内容",
      httpMethod = "DELETE",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public BaseResult delete(@RequestBody DictValueDetailBo info) {
    dictValueServiceCmdI.deleteById(info.getId());
    return success();
  }
}
