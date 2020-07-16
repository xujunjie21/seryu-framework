package org.seryu.framework.rbac.domain.dto;

import lombok.Data;
import org.seryu.framework.data.dto.BaseDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 菜单权限
 * @author: xujunjie
 * @create: 2020-05-07 09:46
 */
@Data
public class MenuPermissionDto extends BaseDto {

  private static final long serialVersionUID = 1L;

  private Long id;

  /** 菜单Id */
  private Long mId;

  /** 接口Id */
  private Long pId;
}
