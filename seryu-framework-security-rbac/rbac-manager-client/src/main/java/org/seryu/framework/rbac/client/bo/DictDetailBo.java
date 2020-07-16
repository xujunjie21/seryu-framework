package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @program: seryu-framework-security-rbac
 * @description: 数据字典类型信息
 * @author: xujunjie
 * @create: 2020-04-23 15:37
 */
@Data
@ToString
@ApiModel(value = "数据字典类型信息", description = "数据字典类型信息")
public class DictDetailBo extends BaseBo {
  @ApiModelProperty(value = "字典值Id", name = "id", dataType = "Integer", example = "1")
  private Long id;

  @ApiModelProperty(value = "字典名称", name = "dict_name", dataType = "String", example = "性别")
  private String dictName;

  @ApiModelProperty(value = "字典标识", name = "dict_type", dataType = "String", example = "esx")
  private String dictType;

  @ApiModelProperty(
      value = "字段值类型 \n 1、数字 \n 2、字符",
      name = "dict_value_type",
      dataType = "Integer",
      example = "1")
  private Integer dictValueType;

  @ApiModelProperty(
      value = "状态：\n 1、激活 \n 2、禁用",
      name = "status",
      dataType = "String",
      example = "")
  private String status;
}
