package org.seryu.framework.rbac.domain.dto;

import lombok.Data;
import org.seryu.framework.data.dto.BaseQryDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户查询
 * @author: xujunjie
 * @create: 2020-05-06 10:40
 */
@Data
public class RoleDetailQryDto extends BaseQryDto {
  private String roleName;

  private String roleKey;

  private Integer status;

  private String startTime;

  private String endTime;
}
