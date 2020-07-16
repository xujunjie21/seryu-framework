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
public class DictDetailQryDto extends Page {
  private String dictName;

  private String dictType;

  private String startTime;

  private String endTime;
}
