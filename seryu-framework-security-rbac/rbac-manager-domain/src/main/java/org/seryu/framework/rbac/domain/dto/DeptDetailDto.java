package org.seryu.framework.rbac.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.seryu.framework.data.dto.BaseDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 领域模型
 * @author xujunjie
 * @since 2020-04-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class DeptDetailDto extends BaseDto {

  private static final long serialVersionUID = 1L;

  private Long id;

  /** 部门父Id */
  private Integer parentId;

  private String ancestors;

  /** 部门名称 */
  private String deptName;

  /** 排序编号 */
  private Integer orderNum;

  /** 负责人 */
  private String leader;

  /** 手机号 */
  private String phone;

  /** 邮箱 */
  private String email;

  /** 状态： 1、激活 2、禁用 */
  private String status;
}
