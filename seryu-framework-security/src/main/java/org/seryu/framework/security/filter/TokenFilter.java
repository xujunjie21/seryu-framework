package org.seryu.framework.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.biz.DbUserThreadLocal;
import org.seryu.framework.data.biz.UserDbEntiy;
import org.seryu.framework.security.config.SecurityProperties;
import org.seryu.framework.security.config.SpringContextHolder;
import org.seryu.framework.security.dto.UserDto;
import org.seryu.framework.security.token.TokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: seryu-framework-security
 * @description: token过滤器
 * @author: xujunjie
 * @create: 2020-04-08 15:28
 */
@Slf4j
public class TokenFilter extends GenericFilterBean {
  private final TokenProvider tokenProvider;

  public TokenFilter(TokenProvider tokenProvider) {
    this.tokenProvider = tokenProvider;
  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    String token = resolveToken(httpServletRequest);
    String requestRri = httpServletRequest.getRequestURI();

    try {
      if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
        Authentication authentication = tokenProvider.getAuthentication(token);
        UserDto user = (UserDto) authentication.getPrincipal();
        UserDbEntiy userDbEntiy = new UserDbEntiy(user.getId(), user.getNickName());
        DbUserThreadLocal.setUser(userDbEntiy);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.debug(
            "setting Authentication to security context for '{}', uri: {}",
            authentication.getName(),
            requestRri);
      } else {
        log.debug("no valid JWT token found, uri: {}", requestRri);
      }
    } catch (ExpiredJwtException e) {
      log.error("JWT 过期或格式有问题", e);
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  private String resolveToken(HttpServletRequest request) {
    SecurityProperties properties = SpringContextHolder.getBean(SecurityProperties.class);
    String bearerToken = request.getHeader(properties.getHeader());

    if (!StringUtils.isEmpty(bearerToken) && bearerToken.length() < 10) return null;
    return bearerToken;
  }
}
