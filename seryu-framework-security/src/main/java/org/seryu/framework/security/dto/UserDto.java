package org.seryu.framework.security.dto;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @program: seryu-framework-security
 * @description: 用户信息
 * @author: xujunjie
 * @create: 2020-04-08 14:21
 */
@Data
@ToString
public class UserDto {
  /** 用户id */
  private String id;
  /** 用户账号 */
  private String username;
  /** 用户昵称 */
  private String nickName;
  /** 性别 */
  private String sex;
  /** 密码 */
  private String password;
  private String avatar;
  /** 邮箱 */
  private String email;
  /** 手机 */
  private String phone;
  /** 部门 */
  private String dept;
  /** 职位 */
  private String job;
  /** 是否启用 */
  private boolean enabled;
  /** 创建时间 */
  private Timestamp createTime;
  /** 最近一次修改密码时间 */
  private String lastPasswordResetDate;
}
