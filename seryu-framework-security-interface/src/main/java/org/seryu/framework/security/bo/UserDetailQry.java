package org.seryu.framework.security.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.seryu.framework.data.page.Page;

/**
 * @program: seryu-framework-security
 * @description: 用户信息查询条件
 * @author: xujunjie
 * @create: 2020-04-23 11:31
 */
@Data
@ToString
@ApiModel(value = "用户查询条件")
public class UserDetailQry extends Page {
  @ApiModelProperty(value = "用户名称", name = "userName", dataType = "String", example = "张三")
  private String userName;
  @ApiModelProperty(value = "座机号", name = "phone", dataType = "String")
  private String phone;
  @ApiModelProperty(value = "手机号", name = "phoneNumber", dataType = "String")
  private String phoneNumber;
  @ApiModelProperty(value = "部门Id", name = "deptId", dataType = "Integer", example = "3")
  private Long deptId;
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
