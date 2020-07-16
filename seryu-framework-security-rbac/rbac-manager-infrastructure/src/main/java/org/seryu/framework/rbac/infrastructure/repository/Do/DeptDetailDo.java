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
 * @since 2020-04-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_dept_detail")
public class DeptDetailDo extends BaseDo {

  private static final long serialVersionUID = 1L;

  @TableId(value = "ID", type = IdType.AUTO)
  private Long id;

  /** 部门父Id */
  @TableField("PARENT_ID")
  private Integer parentId;

  @TableField("ANCESTORS")
  private String ancestors;

  /** 部门名称 */
  @TableField("DEPT_NAME")
  private String deptName;

  /** 排序编号 */
  @TableField("ORDER_NUM")
  private Integer orderNum;

  /** 负责人 */
  @TableField("LEADER")
  private String leader;

  /** 手机号 */
  @TableField("PHONE")
  private String phone;

  /** 邮箱 */
  @TableField("EMAIL")
  private String email;

  /** 状态： 1、激活 2、禁用 */
  @TableField("STATUS")
  private String status;
}
