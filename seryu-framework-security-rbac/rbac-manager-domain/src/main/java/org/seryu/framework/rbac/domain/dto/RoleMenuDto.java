package org.seryu.framework.rbac.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.seryu.framework.data.dto.BaseDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 领域模型
 * @author xujunjie
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RoleMenuDto extends BaseDto {

  private static final long serialVersionUID = 1L;

  private Long id;

  /** 角色Id */
  private Long rId;

  /** 菜单Id */
  private Long mId;
}
