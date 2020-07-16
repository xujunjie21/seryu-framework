package org.seryu.framework.rbac.domain.dto;

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
public class DictValueDetailQryDto extends Page {
  /** 字典Id */
  private Long dictId;

  /** 字段标识 */
  private String dictType;

  /** 字典值名称 */
  private String dictLabel;

  /** 字段值 */
  private String dictValue;

  /** 状态： 1、激活 2、禁用 */
  private String status;
}
