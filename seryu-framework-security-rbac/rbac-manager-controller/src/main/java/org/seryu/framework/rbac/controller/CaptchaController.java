package org.seryu.framework.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.seryu.framework.web.BaseController;
import org.seryu.framework.web.result.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seryu-framework-security-rbac
 * @description: 图形验证
 * @author: xujunjie
 * @create: 2020-04-22 16:10
 */
@Api(tags = "图形验证", value = "/admin/" + "" + "captcha", description = "图形验证")
@RestController
@RequestMapping("/admin/captcha")
public class CaptchaController extends BaseController {
  private static final String TAG_NAME = "图形验证";

  @ApiOperation(
      value = "图形验证",
      notes = "图形验证接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/check")
  public BaseResult check() {
    return success();
  }
}
