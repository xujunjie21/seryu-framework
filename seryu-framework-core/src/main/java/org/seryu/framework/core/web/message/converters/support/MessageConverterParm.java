package org.seryu.framework.core.web.message.converters.support;

import lombok.Data;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.Arrays;
import java.util.List;

/**
 * @program: seryu-framework-core
 * @description: 转换器参数
 * @author: xujunjie
 * @create: 2020-07-09 13:30
 */
@Data
public class MessageConverterParm {
  /** 消息转换器 */
  private HttpMessageConverter httpMessageConverter;

  /** 匹配规则包名 */
  private List<String> packages;

  public MessageConverterParm() {}

  public MessageConverterParm(HttpMessageConverter httpMessageConverter, String... packages) {
    this.httpMessageConverter = httpMessageConverter;
    this.packages = Arrays.asList(packages);
  }

  public MessageConverterParm(HttpMessageConverter httpMessageConverter, List<String> packages) {
    this.httpMessageConverter = httpMessageConverter;
    this.packages = packages;
  }
}
