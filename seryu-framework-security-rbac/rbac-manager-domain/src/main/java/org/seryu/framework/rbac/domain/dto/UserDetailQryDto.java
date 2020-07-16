package org.seryu.framework.rbac.domain.dto;

import lombok.Data;
import lombok.ToString;
import org.seryu.framework.data.page.Page;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户信息查询条件
 * @author: xujunjie
 * @create: 2020-04-23 11:31
 */
@Data
@ToString
public class UserDetailQryDto extends Page {
  private String userName;

  private String phone;

  private String phoneNumber;

  private Long deptId;

  private String startTime;

  private String endTime;
}
