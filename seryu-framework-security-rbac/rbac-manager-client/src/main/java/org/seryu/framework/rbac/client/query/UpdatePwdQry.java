package org.seryu.framework.rbac.client.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: seryu-framework-security-rbac
 * @description: 修改密码
 * @author: xujunjie
 * @create: 2020-05-21 16:20
 */
@Data
@ToString
public class UpdatePwdQry implements Serializable {
  @ApiModelProperty(value = "原密码", name = "oldPwd", dataType = "String", example = "123456")
  private String oldPwd;

  @ApiModelProperty(value = "新密码", name = "newPwd", dataType = "String", example = "1234567")
  private String newPwd;
}
