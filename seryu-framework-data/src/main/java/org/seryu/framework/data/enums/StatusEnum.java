package org.seryu.framework.data.enums;

/**
 * @program: seryu-framework-data
 * @description: 状态枚举
 * @author: xujunjie
 * @create: 2020-05-06 16:08
 */
public enum StatusEnum {
  ENABLE(1, "启用"),
  DISABLE(2, "禁用");
  private int code;

  private String msg;

  StatusEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
