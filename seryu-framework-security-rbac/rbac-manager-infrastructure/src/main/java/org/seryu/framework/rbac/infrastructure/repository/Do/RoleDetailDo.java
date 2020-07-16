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
@TableName("t_role_detail")
public class RoleDetailDo extends BaseDo {

  private static final long serialVersionUID = 1L;

  @TableId(value = "ID", type = IdType.AUTO)
  private Long id;

  /** 角色名称 */
  @TableField("ROLE_NAME")
  private String roleName;

  /** 角色名称 */
  @TableField("ROLE_KEY")
  private String roleKey;
}
