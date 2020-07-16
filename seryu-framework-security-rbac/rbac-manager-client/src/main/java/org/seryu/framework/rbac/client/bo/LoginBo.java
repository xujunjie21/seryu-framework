package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户登录对象
 * @author: xujunjie
 * @create: 2020-04-22 11:59
 */
@Data
@ToString
@ApiModel(value = "用户登录对象")
public class LoginBo implements Serializable {
  /** 用户名称 */
  @ApiModelProperty(value = "用户名称", name = "userName", dataType = "String", example = "test")
  private String userName;

  /** 用户密码 */
  @ApiModelProperty(value = "用户密码", name = "password", dataType = "String", example = "test")
  private String password;
}
