package org.seryu.framework.rbac.infrastructure.repository.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.seryu.framework.db.mybatisPlugs.code.BaseDo;

/**
 * @author xujunjie
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_menu_permission")
public class MenuPermissionDo extends BaseDo {

  private static final long serialVersionUID = 1L;

  @TableId(value = "ID", type = IdType.AUTO)
  private Long id;

  /** 菜单Id */
  private Long mId;

  /** 接口Id */
  private Long pId;
}
