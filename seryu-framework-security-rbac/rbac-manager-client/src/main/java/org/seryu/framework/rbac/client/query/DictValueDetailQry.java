package org.seryu.framework.rbac.client.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.seryu.framework.data.page.Page;

/**
 * @program: seryu-framework-security-rbac
 * @description: 数据字段查询
 * @author: xujunjie
 * @create: 2020-04-23 16:22
 */
@Data
@ToString
public class DictValueDetailQry extends Page {
  @ApiModelProperty(value = "字典Id", name = "dict_id", dataType = "Integer", example = "1")
  private Long dictId;

  @ApiModelProperty(value = "字段标识", name = "dict_type", dataType = "String", example = "status")
  private String dictType;

  @ApiModelProperty(value = "字典值名称", name = "dict_label", dataType = "String", example = "禁用")
  private String dictLabel;

  @ApiModelProperty(value = "字段值", name = "dict_value", dataType = "String", example = "1")
  private String dictValue;

  @ApiModelProperty(
      value = "状态：\n 1、激活 \n 2、禁用",
      name = "status",
      dataType = "String",
      example = "")
  private String status;
}
