package org.seryu.framework.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.rbac.client.bo.LoginDetailBo;
import org.seryu.framework.web.BaseController;
import org.seryu.framework.web.enums.ResultCodeEnum;
import org.seryu.framework.web.result.BaseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: seryu-framework-security-rbac
 * @description: 文件上传
 * @author: xujunjie
 * @create: 2020-04-23 11:44
 */
@Slf4j
@Api(tags = "文件上传", value = "/admin/upload", description = "文件上传")
@RestController
@RequestMapping("/admin/upload")
public class UploadController extends BaseController {
  private final String TAG_NAME = "文件上传";

  @ApiOperation(
      value = "上传图片",
      notes = "上传图片",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = LoginDetailBo.class)
  @RequestMapping(value = "/oss", method = RequestMethod.POST)
  public BaseResult uploadHDFS(MultipartFile file) {
    try {
      String path = ""; // TODO
      return success(path);
    } catch (Exception e) {
      log.error("上传文件异常 ", e);
      return error(ResultCodeEnum.FILE_UPLOAD_ERROR, "文件上传异常:" + e.getMessage());
    }
  }
}
