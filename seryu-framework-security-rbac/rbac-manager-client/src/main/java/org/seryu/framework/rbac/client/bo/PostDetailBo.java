package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: seryu-framework-security-rbac
 * @description: 岗位信息
 * @author: xujunjie
 * @create: 2020-04-23 11:51
 */
@Data
@ToString
@ApiModel(value = "岗位信息", description = "岗位信息")
public class PostDetailBo extends BaseBo implements Serializable {
  @ApiModelProperty(value = "岗位Id", name = "id", dataType = "Integer", example = "8")
  private Long id;

  @ApiModelProperty(value = "岗位名称", name = "postName", dataType = "String", example = "java开发")
  private String postName;
}
