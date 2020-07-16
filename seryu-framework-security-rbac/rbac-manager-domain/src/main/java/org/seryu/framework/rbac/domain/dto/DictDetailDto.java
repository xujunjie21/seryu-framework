package org.seryu.framework.rbac.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.seryu.framework.data.dto.BaseDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 领域模型
 * @author xujunjie
 * @since 2020-05-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class DictDetailDto extends BaseDto {

  private static final long serialVersionUID = 1L;

  private Long id;

  /** 字典名称 */
  private String dictName;

  /** 字段值类型 1、数字 2、字符 */
  private Integer dictValueType;

  /** 字段标识 */
  private String dictType;

  /** 状态： 1、激活 2、禁用 */
  private String status;
}
