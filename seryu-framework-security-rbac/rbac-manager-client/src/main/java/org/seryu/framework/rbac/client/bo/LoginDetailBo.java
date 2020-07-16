package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户登录信息
 * @author: xujunjie
 * @create: 2020-04-22 12:00
 */
@Data
@ToString
public class LoginDetailBo implements Serializable {
  @ApiModelProperty(value = "用户昵称", name = "nickname", dataType = "string", example = "管理员")
  private String nickname;

  @ApiModelProperty(value = "用户名称", name = "userName", dataType = "string", example = "admin")
  private String userName;

  @ApiModelProperty(value = "用户ID", name = "userId", dataType = "string", example = "GHYDA1023")
  private String userId;

  @ApiModelProperty(
      value = "token",
      name = "token",
      dataType = "string",
      example =
          "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODc3MTU1NjYsImlhdCI6MTU4NzQ1NjM2NiwiaWQiOjgxLCJ1c2VyX25hbWUiOiJhZG1pbiIsInZlcmlmaWNhdGlvbiI6IjIxMjMyZjI5N2E1N2E1YTc0Mzg5NGEwZTRhODAxZmMzIn0.IZG62skNw4o6xvzs0XB6gGUR1lCQ6vXloHxhyxqVx-k")
  private String token;
}
