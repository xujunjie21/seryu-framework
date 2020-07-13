package org.seryu.framework.data.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: seryu-framework-data
 * @description: 基础数据库相关领域模型
 * @author: xujunjie
 * @create: 2020-04-29 15:29
 */
@Data
public class BaseDto implements Serializable {
  private String createUserId;

  private Date createDate;

  private String updateUserId;

  private Date updateDate;

  private String remark;
}
