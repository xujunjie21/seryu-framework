package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户登出
 * @author: xujunjie
 * @create: 2020-04-22 15:42
 */
@Data
@ToString
public class LogoutBo implements Serializable {
  @ApiModelProperty(
      value = "用户token",
      name = "token",
      dataType = "String",
      example =
          "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODc3MTU1NjYsImlhdCI6MTU4NzQ1NjM2NiwiaWQiOjgxLCJ1c2VyX25hbWUiOiJhZG1pbiIsInZlcmlmaWNhdGlvbiI6IjIxMjMyZjI5N2E1N2E1YTc0Mzg5NGEwZTRhODAxZmMzIn0.IZG62skNw4o6xvzs0XB6gGUR1lCQ6vXloHxhyxqVx-k")
  private String token;

  public LogoutBo() {}

  public LogoutBo(String token) {
    this.token = token;
  }
}
