package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @program: seryu-framework-security-rbac
 * @description: 数据字典信息
 * @author: xujunjie
 * @create: 2020-04-23 15:37
 */
@Data
@ToString
@ApiModel(value = "数据字典信息", description = "数据字典信息")
public class DictValueDetailBo extends BaseBo {
  @ApiModelProperty(value = "字典值Id", name = "id", dataType = "Integer", example = "1")
  private Long id;

  @ApiModelProperty(value = "字典Id", name = "dict_id", dataType = "Integer", example = "1")
  private Integer dictId;

  @ApiModelProperty(value = "字典值排序", name = "dict_sort", dataType = "Integer", example = "1")
  private Integer dictSort;

  @ApiModelProperty(value = "字典值名称", name = "dict_label", dataType = "String", example = "禁用")
  private String dictLabel;

  @ApiModelProperty(value = "字段标识", name = "dict_type", dataType = "String", example = "status")
  private String dictType;

  @ApiModelProperty(
      value = "字段值类型 \n 1、数字 \n 2、字符",
      name = "dict_value_type",
      dataType = "Integer",
      example = "1")
  private Integer dictValueType;

  @ApiModelProperty(
      value = "字段值 \n 1、数字 \n 2、字符",
      name = "dict_number",
      dataType = "Integer",
      example = "1")
  private Integer dictNumber;

  @ApiModelProperty(value = "字段值", name = "dict_value", dataType = "String", example = "1")
  private String dictValue;

  @ApiModelProperty(
      value = "是否默认选中 \n 1、选中 \n 2、未选中",
      name = "is_default",
      dataType = "Integer",
      example = "1")
  private Integer isDefault;

  @ApiModelProperty(value = "样式类", name = "css_class", dataType = "String", example = "")
  private String cssClass;

  @ApiModelProperty(
      value = "状态：\n 1、激活 \n 2、禁用",
      name = "status",
      dataType = "String",
      example = "")
  private String status;
}
