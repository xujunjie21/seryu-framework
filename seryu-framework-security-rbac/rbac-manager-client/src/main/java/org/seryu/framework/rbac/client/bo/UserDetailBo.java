package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.seryu.framework.data.bo.BaseBo;

import java.io.Serializable;

/**
 * @program: seryu-framework-security
 * @description: 用户信息
 * @author: xujunjie
 * @create: 2020-04-23 10:03
 */
@Data
@ToString
@ApiModel(value = "用户信息", description = "用户信息")
public class UserDetailBo extends BaseBo implements Serializable {
  @ApiModelProperty(value = "用户Id", name = "id", dataType = "String", example = "FASDYEFFASD")
  private String id;
  @ApiModelProperty(value = "用户昵称", name = "nickname", dataType = "String", example = "张三")
  private String nickname;
  @ApiModelProperty(value = "用户名称", name = "userName", dataType = "String", example = "张三")
  private String userName;
  @ApiModelProperty(value = "用户类型", name = "userType", dataType = "Integer", example = "1")
  private Integer userType;
  @ApiModelProperty(value = "邮箱", name = "email", dataType = "String", example = "xxxxx@xx.com")
  private String email;
  @ApiModelProperty(value = "座机号", name = "phone", dataType = "String")
  private String phone;
  @ApiModelProperty(value = "手机号", name = "phoneNumber", dataType = "String")
  private String phoneNumber;
  @ApiModelProperty(
      value = "性别:\n 1、男 \n 2、女 \n 0、未知",
      name = "sex",
      dataType = "Integer",
      example = "1")
  private Integer sex;
  @ApiModelProperty(value = "头像", name = "avatar", dataType = "String", example = "")
  private String avatar;
  @ApiModelProperty(value = "密码", name = "password", dataType = "String", hidden = true)
  private String password;
  @ApiModelProperty(value = "密码盐", name = "salt", dataType = "String", hidden = true)
  private String salt;
  @ApiModelProperty(
      value = "用户状态 \n 1、激活 \n 2、禁用",
      name = "status",
      dataType = "Integer",
      hidden = true)
  private Integer status;
  @ApiModelProperty(value = "部门Id", name = "deptId", dataType = "Integer", example = "3")
  private Integer deptId;
  @ApiModelProperty(
      value = "最近一次登录IP",
      name = "loginIp",
      dataType = "String",
      example = "127.0.0.1")
  private String loginIp;
  @ApiModelProperty(
      value = "最近一次登录时间",
      name = "loginDate",
      dataType = "String",
      example = "2020-03-15T13:48:07+08:00")
  private String loginDate;
  @ApiModelProperty(
      value = "岗位Ids（逗号分割）",
      name = "userPost",
      dataType = "String",
      example = "1,2,3")
  private String userPost;
  @ApiModelProperty(
      value = "角色Ids（逗号分割）",
      name = "userRole",
      dataType = "String",
      example = "1,2,3")
  private String userRole;
}
