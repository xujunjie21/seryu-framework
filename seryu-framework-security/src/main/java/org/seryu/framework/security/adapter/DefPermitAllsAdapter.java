package org.seryu.framework.security.adapter;

import java.util.ArrayList;
import java.util.List;
import org.seryu.framework.security.dto.PermitAllsDto;
import org.springframework.http.HttpMethod;

/**
 * @program: seryu-framework-security
 * @description: 默认静态资源
 * @author: xujunjie
 * @create: 2020-04-08 17:37
 */
public class DefPermitAllsAdapter implements PermitAllsAdapter {
  @Override
  public List<PermitAllsDto> get() {
    List<PermitAllsDto> list = new ArrayList<>();
    // 静态资源等等
    list.add(
        new PermitAllsDto(
            HttpMethod.GET,
            "/*.html",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js",
            "/**/*.ico",
            "/webSocket/**"));

    // 图形验证码 登录
    list.add(new PermitAllsDto("/admin/captcha/check", "/admin/user/login"));
    // swagger 文档
    list.add(
        new PermitAllsDto(
            "/swagger-custom.html", "/swagger-resources/**", "/webjars/**", "/*/api-docs"));
    // 文件
    list.add(new PermitAllsDto("/avatar/**", "/file/**"));
    // 阿里 druid
    list.add(new PermitAllsDto("/druid/**"));
    // 对外api接口
    list.add(new PermitAllsDto("/api/**", "/applatform/**"));
    return list;
  }
}
