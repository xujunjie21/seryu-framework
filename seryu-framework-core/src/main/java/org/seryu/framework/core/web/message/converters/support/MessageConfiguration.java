package org.seryu.framework.core.web.message.converters.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @program: seryu-framework-core
 * @description: 消息转换器配置
 * @author: xujunjie
 * @create: 2020-07-09 15:51
 */
@Configuration
public class MessageConfiguration implements WebMvcConfigurer {
  @Autowired private MessageConverterFilter messageConverterFilter;

  @Autowired private SeryuHttpMessageConverter seryuHttpMessageConverter;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(messageConverterFilter);
  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(0, seryuHttpMessageConverter);
  }
}
