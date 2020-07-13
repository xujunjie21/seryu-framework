package org.seryu.framework.data.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * @program: seryu-framework-data
 * @description: 分页查询
 * @author: xujunjie
 * @create: 2020-04-23 10:05
 */
@Data
@ToString
@ApiModel(value = "pageResult", description = "分页结果")
public class PageData<T> implements Serializable {
  @ApiModelProperty(value = "分页信息", name = "page", dataType = "Page")
  private Page page;

  @ApiModelProperty(value = "结果列表", name = "list", dataType = "List")
  private List<T> list;
}
