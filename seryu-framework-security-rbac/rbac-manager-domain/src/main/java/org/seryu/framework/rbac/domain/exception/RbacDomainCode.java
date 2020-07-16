package org.seryu.framework.rbac.domain.exception;

/** 接口响应码 */
public enum RbacDomainCode {
  SUCCESS(200, "请求成功"),
  UPDATE_PWD_FAIL(10000, "修改密码异常");

  private int code;
  private String message;

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  RbacDomainCode(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
