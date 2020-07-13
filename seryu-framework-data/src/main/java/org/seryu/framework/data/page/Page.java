package org.seryu.framework.data.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * @program: seryu-framework-data
 * @description: 分页信息
 * @author: xujunjie
 * @create: 2020-04-23 10:07
 */
@Data
@ToString
@ApiModel(value = "page", description = "分页数据")
public class Page implements Serializable {
  @ApiModelProperty(value = "当前页", name = "pageNo", dataType = "Integer", example = "1")
  private Long pageNo = 1L;

  @ApiModelProperty(value = "每页显示数", name = "pageSize", dataType = "Integer", example = "10")
  private Long pageSize = 10L;

  @ApiModelProperty(value = "总页数", name = "totalPage", dataType = "Integer", example = "1")
  private Long totalPage;

  @ApiModelProperty(value = "总条数", name = "totalCount", dataType = "Integer", example = "20")
  private Long totalCount;

  @ApiModelProperty(value = "是否首页", name = "isFirstPage", dataType = "Boolean", example = "true")
  private boolean isFirstPage;

  @ApiModelProperty(value = "是否末页", name = "isLastPage", dataType = "Boolean", example = "true")
  private boolean isLastPage;

  @ApiModelProperty(value = "排序字段", name = "orderColumnName", dataType = "String")
  private String orderColumnName;

  @ApiModelProperty(
      value = "排序类型: \n asc 升序 \n desc 降序",
      name = "order_type",
      dataType = "String")
  private String orderType;
}
