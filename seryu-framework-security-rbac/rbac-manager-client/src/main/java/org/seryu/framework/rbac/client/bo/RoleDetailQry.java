package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.seryu.framework.data.page.Page;

/**
 * @program: seryu-framework-security
 * @description: 角色查询条件
 * @author: xujunjie
 * @create: 2020-04-23 13:27
 */
@Data
@ToString
@ApiModel(value = "角色查询条件")
public class RoleDetailQry extends Page {
  @ApiModelProperty(value = "角色名称", name = "roleName", dataType = "String", example = "游客")
  private String roleName;
  @ApiModelProperty(value = "角色Key", name = "roleKey", dataType = "String", example = "guest")
  private String roleKey;
  @ApiModelProperty(
      value = "状态 1、激活 2、禁用 ",
      name = "roleName",
      dataType = "String",
      example = "java开发")
  private Integer status;
  @ApiModelProperty(
      value = "开始时间: YYYY-MM-dd ",
      name = "startTime",
      dataType = "String",
      example = "2020-04-23")
  private String startTime;
  @ApiModelProperty(
      value = "结束时间: YYYY-MM-dd ",
      name = "startTime",
      dataType = "String",
      example = "2020-04-23")
  private String endTime;
}
