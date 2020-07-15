package org.seryu.framework.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.web.builder.ResultBuilder;
import org.seryu.framework.web.enums.ResultCodeEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: seryu-framework-security
 * @description: 配置访问受限返回
 * @author: xujunjie
 * @create: 2020-04-08 14:30
 */
@Slf4j
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
  @Override
  public void handle(
      HttpServletRequest request,
      HttpServletResponse response,
      AccessDeniedException accessDeniedException)
      throws IOException {
    // 当用户在没有授权的情况下访问受保护的REST资源时，将调用此方法发送403 Forbidden响应
    response.setCharacterEncoding("utf-8");
    response.setContentType("application/json; charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.write(JSON.toJSONString(ResultBuilder.error(ResultCodeEnum.AUTH_FAIL, "鉴权失败")));
  }
}
