package org.seryu.framework.data.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: seryu-framework-data
 * @description: 通用信息
 * @author: xujunjie
 * @create: 2020-04-23 13:23
 */
@Data
@ToString
public class BaseBo implements Serializable {
  @ApiModelProperty(value = "备注", name = "remark", dataType = "String", example = "真香")
  private String remark;

  @ApiModelProperty(value = "创建者Id", name = "create_user_id", dataType = "String", example = "")
  private String createUserId;

  @ApiModelProperty(
      value = "创建时间",
      name = "create_date",
      dataType = "String",
      example = "2019-10-23T14:07:28+08:00")
  private Date createDate;

  @ApiModelProperty(value = "更新者Id", name = "update_user_id", dataType = "String", example = "")
  private String updateUserId;

  @ApiModelProperty(
      value = "更新时间",
      name = "update_date",
      dataType = "String",
      example = "2019-10-23T14:07:28+08:00")
  private Date updateDate;
}
