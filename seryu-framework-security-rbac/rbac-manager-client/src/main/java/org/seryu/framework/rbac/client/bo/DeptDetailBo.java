package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 部门信息
 * @author: xujunjie
 * @create: 2020-04-23 09:41
 */
@Data
@ToString
@ApiModel(value = "部门信息", description = "部门信息")
public class DeptDetailBo extends BaseBo implements Serializable {
  @ApiModelProperty(value = "部门Id", name = "id", dataType = "Integer", example = "1")
  private Long id;

  @ApiModelProperty(value = "部门父Id", name = "parentId", dataType = "Integer", example = "0")
  private Integer parentId;

  @ApiModelProperty(value = "", name = "ancestors", dataType = "String", example = "")
  private String ancestors;

  @ApiModelProperty(value = "部门名称", name = "deptName", dataType = "Integer", example = "公司")
  private String deptName;

  @ApiModelProperty(value = "排序编号", name = "orderNum", dataType = "Integer", example = "1")
  private Integer orderNum;

  @ApiModelProperty(value = "负责人", name = "leader", dataType = "String", example = "")
  private String leader;

  @ApiModelProperty(value = "手机号", name = "phone", dataType = "String", example = "")
  private String phone;

  @ApiModelProperty(value = "邮箱", name = "email", dataType = "String", example = "")
  private String email;

  @ApiModelProperty(
      value = "状态：\n 1、激活 \n 2、禁用",
      name = "status",
      dataType = "String",
      example = "")
  private String status;

  @ApiModelProperty(value = "子部门列表", name = "childrenList", dataType = "MenuBo")
  private List<DeptDetailBo> childrenList;
}
