package org.seryu.framework.data.exception;

/**
 * @program: seryu-framework-data
 * @description: 接口异常
 * @author: xujunjie
 * @create: 2020-05-06 18:34
 */
public class InterfacesException extends RuntimeException {
  private InterfacesCode code;

  public InterfacesException(InterfacesCode code, String message) {
    super(message);
    this.code = code;
  }

  public InterfacesException(InterfacesCode code) {
    super(code.getMessage());
    this.code = code;
  }

  public InterfacesCode getCode() {
    return code;
  }
}
