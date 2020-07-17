package org.seryu.framework.core.web.message.converters.support;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.core.web.message.converters.SeryuMessageConverter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.support.WebApplicationObjectSupport;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program:seryu-framework-core
 * @description: 解析bean注解
 * @author: xujunjie
 * @create: 2020-07-09 16:06
 */
@Slf4j
@Component
public class MessageSpringProcessor extends WebApplicationObjectSupport
    implements BeanPostProcessor {
  @Autowired private SeryuHttpMessageConverter seryuHttpMessageConverter;

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
    if (methods != null) {
      for (Method method : methods) {
        SeryuMessageConverter seryuMessageConverter =
            AnnotationUtils.findAnnotation(method, SeryuMessageConverter.class);
        if (null != seryuMessageConverter) {
          Object httpMessageConverter =
              getApplicationContext().getBean(seryuMessageConverter.name());
          if (httpMessageConverter instanceof HttpMessageConverter) {
            log.info(
                "【开始】 初始化http消息转换器 name: {} , uris : {}",
                seryuMessageConverter.name(),
                seryuMessageConverter.uri());
            MessageConverterParm messageConverterParm =
                new MessageConverterParm(
                    (HttpMessageConverter) httpMessageConverter, seryuMessageConverter.uri());
            seryuHttpMessageConverter.createRule(Arrays.asList(messageConverterParm));
            log.info(
                "【完成】 初始化http消息转换器 name: {} , uris : {}",
                seryuMessageConverter.name(),
                seryuMessageConverter.uri());
          }
        }
      }
    }
    return bean;
  }
}
