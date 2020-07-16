package org.seryu.framework.rbac.infrastructure.repository.Do;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("t_user_detail")
public class UserDetailDo extends BaseDo {

  private static final long serialVersionUID = 1L;

  @TableField("ID")
  private String id;

  /** 用户昵称 */
  @TableField("NICKNAME")
  private String nickname;

  /** 用户名称 */
  @TableField("USER_NAME")
  private String userName;

  /** 用户类型 */
  @TableField("USER_TYPE")
  private Integer userType;

  /** 邮箱 */
  @TableField("EMAIL")
  private String email;

  /** 座机号 */
  @TableField("PHONE")
  private String phone;

  /** 手机号 */
  @TableField("PHONE_NUMBER")
  private String phoneNumber;

  /** 性别: 1、男 2、女 0、未知 */
  @TableField("SEX")
  private Integer sex;

  /** 头像 */
  @TableField("AVATAR")
  private String avatar;

  /** 密码 */
  @TableField("PASSWORD")
  private String password;

  /** 密码盐 */
  @TableField("SALT")
  private String salt;

  /** 用户状态 1、激活 2、禁用 */
  @TableField("STATUS")
  private Integer status;

  /** 部门Id */
  @TableField("DEPT_ID")
  private Integer deptId;

  /** 最近一次登录IP */
  @TableField("LOGIN_IP")
  private String loginIp;

  /** 最近一次登录时间 */
  @TableField("LOGIN_DATE")
  private String loginDate;

  /** 岗位Ids（逗号分割） */
  @TableField("USER_POST")
  private String userPost;

  /** 角色Ids（逗号分割） */
  @TableField("USER_ROLE")
  private String userRole;
}
