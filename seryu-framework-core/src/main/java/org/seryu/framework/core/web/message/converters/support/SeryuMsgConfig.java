package org.seryu.framework.core.web.message.converters.support;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: seryu-framework-core
 * @description:
 * @author: xujunjie
 * @create: 2020-07-09 16:31
 */
@Configuration
public class SeryuMsgConfig {
  @Bean
  public SeryuHttpMessageConverter build() {
    return new SeryuHttpMessageConverter();
  }
}
