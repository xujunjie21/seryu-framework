package org.seryu.framework.core.web.message.converters.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: seryu-framework-core
 * @description: token过滤器
 * @author: xujunjie
 * @create: 202004-08 15:28
 */
@Slf4j
@Component
public class MessageConverterFilter implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    HttpMessageConverterThreadLocal.set(request.getRequestURI());
    return true;
  }
}
