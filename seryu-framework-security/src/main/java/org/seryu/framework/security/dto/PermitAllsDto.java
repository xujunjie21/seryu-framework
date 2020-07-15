package org.seryu.framework.security.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpMethod;

/**
 * @program: seryu-framework-security
 * @description: 不进行校验的资源列表
 * @author: xujunjie
 * @create: 2020-04-08 15:47
 */
@Data
@ToString
public class PermitAllsDto implements Serializable {
  /** 请求方式 */
  private HttpMethod httpMethod;

  /** 需要过滤的uri */
  private String[] uris;

  public PermitAllsDto(HttpMethod httpMethod, String... uris) {
    this.httpMethod = httpMethod;
    this.uris = uris;
  }

  public PermitAllsDto(String... uris) {
    this.uris = uris;
  }
}
