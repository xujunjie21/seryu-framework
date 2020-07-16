package org.seryu.framework.rbac.domain.exception;

/** 接口异常 Created by xujunjie on 17/8/23. */
public class RbacDomainException extends RuntimeException {
  private RbacDomainCode code;

  public RbacDomainException(RbacDomainCode code, String message) {
    super(message);
    this.code = code;
  }

  public RbacDomainException(RbacDomainCode code) {
    super(code.getMessage());
    this.code = code;
  }

  public RbacDomainCode getCode() {
    return code;
  }
}
