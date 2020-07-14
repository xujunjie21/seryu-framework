package org.seryu.framework.web.enums;

import lombok.Getter;
import org.seryu.framework.web.result.ResultCodeI;

/**
 * @program: seryu-framework
 * @description: 结果码枚举
 * @author: xujunjie
 * @create: 2020-04-22 10:19
 */
@Getter
public enum ResultCodeEnum implements ResultCodeI {
  SUCCESS("0", "请求成功"),
  AUTH_FAIL("B-000001", "鉴权失败"),
  TOKEN_EXPIRED("B-000002", "token过期"),
  FILE_UPLOAD_ERROR("B-000003", "文件上传异常"),
  ILLEGAL_OPT("B-000002", "非法操作"),
  UMKOWN_ERROR("B-999999", "未知异常");

  private String code;
  private String msg;

  ResultCodeEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
