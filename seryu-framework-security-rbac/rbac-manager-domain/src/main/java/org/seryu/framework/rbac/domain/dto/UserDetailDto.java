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
public class UserDetailDto extends BaseDto {

  private static final long serialVersionUID = 1L;

  private String id;

  /** 用户昵称 */
  private String nickname;

  /** 用户名称 */
  private String userName;

  /** 用户类型 */
  private Integer userType;

  /** 邮箱 */
  private String email;

  /** 座机号 */
  private String phone;

  /** 手机号 */
  private String phoneNumber;

  /** 性别: 1、男 2、女 0、未知 */
  private Integer sex;

  /** 头像 */
  private String avatar;

  /** 密码 */
  private String password;

  /** 密码盐 */
  private String salt;

  /** 用户状态 1、激活 2、禁用 */
  private Integer status;

  /** 部门Id */
  private Integer deptId;

  /** 最近一次登录IP */
  private String loginIp;

  /** 最近一次登录时间 */
  private String loginDate;

  /** 岗位Ids（逗号分割） */
  private String userPost;

  /** 角色Ids（逗号分割） */
  private String userRole;
}
