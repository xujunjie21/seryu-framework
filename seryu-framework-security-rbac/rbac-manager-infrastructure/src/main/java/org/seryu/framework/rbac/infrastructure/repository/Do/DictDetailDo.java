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
@TableName("t_dict_detail")
public class DictDetailDo extends BaseDo {

  private static final long serialVersionUID = 1L;

  @TableId(value = "ID", type = IdType.AUTO)
  private Long id;

  /** 字典名称 */
  @TableField("DICT_NAME")
  private String dictName;

  /** 字段值类型 1、数字 2、字符 */
  @TableField("DICT_VALUE_TYPE")
  private Integer dictValueType;

  /** 字段标识 */
  @TableField("DICT_TYPE")
  private String dictType;

  /** 状态： 1、激活 2、禁用 */
  @TableField("STATUS")
  private String status;
}
