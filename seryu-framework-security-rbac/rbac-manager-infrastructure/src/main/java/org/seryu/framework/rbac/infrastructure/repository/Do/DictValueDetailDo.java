package org.seryu.framework.rbac.infrastructure.repository.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.seryu.framework.db.mybatisPlugs.code.BaseDo;

/**
 * @author xujunjie
 * @since 2020-05-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_dict_value_detail")
public class DictValueDetailDo extends BaseDo {

  private static final long serialVersionUID = 1L;

  @TableId(value = "ID", type = IdType.AUTO)
  private Long id;

  /** 字典Id */
  @TableField("DICT_ID")
  private Integer dictId;

  /** 字典值排序 */
  @TableField("DICT_SORT")
  private Integer dictSort;

  /** 字典值名称 */
  @TableField("DICT_LABEL")
  private String dictLabel;

  /** 字段标识 */
  @TableField("DICT_TYPE")
  private String dictType;

  /** 字段值类型 1、数字 2、字符 */
  @TableField("DICT_VALUE_TYPE")
  private Integer dictValueType;

  /** 字段值 1、数字 2、字符 */
  @TableField("DICT_NUMBER")
  private Integer dictNumber;

  /** 字段值 */
  @TableField("DICT_VALUE")
  private String dictValue;

  /** 是否默认选中 1、选中 2、未选中 */
  @TableField("IS_DEFAULT")
  private Integer isDefault;

  /** 样式类 */
  @TableField("CSS_CLASS")
  private String cssClass;

  /** 状态： 1、激活 2、禁用 */
  @TableField("STATUS")
  private String status;
}
