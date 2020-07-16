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
 * @since 2020-05-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PermissionDetailDto extends BaseDto {

  private static final long serialVersionUID = 1L;

  private Long id;

  /** 接口名称 */
  private String name;

  /** url地址 */
  private String url;

  /** 接口Key */
  private String pKey;

  /** 拥有该资源的角色列表 */
  private List<RoleDetailDto> roles;
}
