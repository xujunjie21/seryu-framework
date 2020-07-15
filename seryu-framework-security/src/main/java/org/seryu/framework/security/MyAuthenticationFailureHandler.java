package org.seryu.framework.security;

import com.alibaba.fastjson.JSON;
import org.seryu.framework.web.builder.ResultBuilder;
import org.seryu.framework.web.enums.ResultCodeEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: seryu-framework-security
 * @description:
 * @author: xujunjie
 * @create: 2020-05-06 17:38
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
      throws IOException, ServletException {
    response.setCharacterEncoding("utf-8");
    response.setContentType("application/json; charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.write(JSON.toJSONString(ResultBuilder.error(ResultCodeEnum.AUTH_FAIL, "鉴权失败")));
  }
}
