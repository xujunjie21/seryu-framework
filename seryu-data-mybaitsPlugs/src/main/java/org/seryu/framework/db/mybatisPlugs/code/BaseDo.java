package org.seryu.framework.db.mybatisPlugs.code;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @program: seryu-framework
 * @description: 基础实体
 * @author: xujunjie
 * @create: 2020-04-26 16:42
 */
@Data
public class BaseDo implements Serializable {
  @TableField(value = "CREATE_USER_ID", fill = FieldFill.INSERT) // 新增执行
  private String createUserId;

  @TableField(value = "CREATE_DATE", fill = FieldFill.INSERT)
  private Date createDate;

  @TableField(value = "UPDATE_USER_ID", fill = FieldFill.INSERT_UPDATE) // 新增和更新执行
  private String updateUserId;

  @TableField(value = "UPDATE_DATE", fill = FieldFill.INSERT_UPDATE)
  private Date updateDate;

  @TableField(value = "REMARK")
  private String remark;
}
