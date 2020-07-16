package org.seryu.framework.rbac.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.seryu.framework.data.dto.BaseDto;

import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 领域模型
 * @author xujunjie
 * @since 2020-04-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RoleDetailDto extends BaseDto {

  private static final long serialVersionUID = 1L;

  private Long id;

  /** 角色名称 */
  private String roleName;

  private String roleKey;

  private List<MenuDetailDto> roleMenu;
}
