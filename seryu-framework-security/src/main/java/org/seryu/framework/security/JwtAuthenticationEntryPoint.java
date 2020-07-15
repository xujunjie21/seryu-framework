package org.seryu.framework.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.web.builder.ResultBuilder;
import org.seryu.framework.web.enums.ResultCodeEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: seryu-framework-security
 * @description:
 * @author: xujunjie
 * @create: 2020-04-08 14:37
 */
@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException)
      throws IOException {
    response.setCharacterEncoding("utf-8");
    response.setContentType("application/json; charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.write(
        JSON.toJSONString(
            ResultBuilder.error(ResultCodeEnum.AUTH_FAIL, "鉴权失败JwtAuthenticationEntryPoint")));
  }
}
