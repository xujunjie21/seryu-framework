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
public class DictValueDetailDto extends BaseDto {

  private static final long serialVersionUID = 1L;

  private Long id;

  /** 字典Id */
  private Integer dictId;

  /** 字典值排序 */
  private Integer dictSort;

  /** 字典值名称 */
  private String dictLabel;

  /** 字段标识 */
  private String dictType;

  /** 字段值类型 1、数字 2、字符 */
  private Integer dictValueType;

  /** 字段值 1、数字 2、字符 */
  private Integer dictNumber;

  /** 字段值 */
  private String dictValue;

  /** 是否默认选中 1、选中 2、未选中 */
  private Integer isDefault;

  /** 样式类 */
  private String cssClass;

  /** 状态： 1、激活 2、禁用 */
  private String status;
}
