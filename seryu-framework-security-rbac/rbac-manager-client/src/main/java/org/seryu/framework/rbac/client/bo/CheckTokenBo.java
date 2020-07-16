package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: seryu-framework-security-rbac
 * @description: 校验
 * @author: xujunjie
 * @create: 2020-04-22 17:23
 */
@Data
@ToString
public class CheckTokenBo implements Serializable {
  @ApiModelProperty(value = "用户Id", name = "user_id", dataType = "string", example = "81")
  private String userId;

  @ApiModelProperty(value = "用户名称", name = "user_name", dataType = "string", example = "admin")
  private String userName;
}
