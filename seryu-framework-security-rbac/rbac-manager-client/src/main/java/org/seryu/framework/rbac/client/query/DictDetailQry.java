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
public class DictDetailQry extends Page {
  @ApiModelProperty(value = "字典名称", name = "dict_name", dataType = "String", example = "性别")
  private String dictName;

  @ApiModelProperty(value = "字典标识", name = "dict_type", dataType = "String", example = "esx")
  private String dictType;

  @ApiModelProperty(
      value = "开始时间: YYYY-MM-dd ",
      name = "startTime",
      dataType = "String",
      example = "2020-04-23")
  private String startTime;

  @ApiModelProperty(
      value = "结束时间: YYYY-MM-dd ",
      name = "startTime",
      dataType = "String",
      example = "2020-04-23")
  private String endTime;
}
