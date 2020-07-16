package org.seryu.framework.core.web.message.converters;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author : xujunjie
 * @version V1.0
 * @program:  seryu-framework-core
 * @description: 添加消息转换器
 * @date Date : 2020年07月09日 15:58
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Bean
public @interface SeryuMessageConverter {
  /**
   * 消息转换器名称
   *
   * @return
   */
  @AliasFor(annotation = Bean.class, attribute = "name")
  String name();

  /**
   * 转换地址
   *
   * @return
   */
  String[] uri() default {};
}
