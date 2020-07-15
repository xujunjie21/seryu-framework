package org.seryu.framework.data.exception;

/**
 * @program: seryu-framework-data
 * @description: 接口响应码
 * @author: xujunjie
 * @create: 2020-05-06 18:34
 */
public enum InterfacesCode {
  SUCCESS(200, "请求成功");

  private int code;
  private String message;

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  InterfacesCode(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
