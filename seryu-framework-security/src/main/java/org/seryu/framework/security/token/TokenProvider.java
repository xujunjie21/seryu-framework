package org.seryu.framework.security.token;

import cn.hutool.core.bean.BeanUtil;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.security.config.SecurityProperties;
import org.seryu.framework.security.dto.JwtUserDto;
import org.seryu.framework.security.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * @program: seryu-framework-security
 * @description: token生成器
 * @author: xujunjie
 * @create: 2020-04-08 15:03
 */
@Slf4j
@Component
public class TokenProvider implements InitializingBean {
  private final SecurityProperties properties;
  private static final String AUTHORITIES_KEY = "auth";
  private static final String USER_KEY = "user_key";
  private Key key;

  public TokenProvider(SecurityProperties properties) {
    this.properties = properties;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    // 获取密钥
    byte[] keyBytes = Decoders.BASE64.decode(properties.getBase64Secret());
    this.key = Keys.hmacShaKeyFor(keyBytes);
  }

  /**
   * @description: 创建Token
   * @param authentication 用户认证信息
   * @return 返回token
   */
  public String createToken(Authentication authentication) {
    String authorities =
        authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));

    long now = (new Date()).getTime();
    Date validity = new Date(now + properties.getTokenValidityInSeconds());

    JwtUserDto jwtUserDto = (JwtUserDto) authentication.getPrincipal();
    jwtUserDto.setPassword("");
    return Jwts.builder()
        .setSubject(authentication.getName())
        .claim(USER_KEY, jwtUserDto)
        .claim(AUTHORITIES_KEY, authorities)
        .signWith(key, SignatureAlgorithm.HS512)
        .setExpiration(validity)
        .compact();
  }

  /**
   * @description: 获取toekn中内容
   * @param token token
   * @return 用户认证信息
   */
  public Authentication getAuthentication(String token) {
    Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();

    Collection<? extends GrantedAuthority> authorities =
        Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
    UserDto userDto = BeanUtil.mapToBean((Map<?, ?>) claims.get(USER_KEY), UserDto.class, true);
    JwtUserDto principal = new JwtUserDto();
    BeanUtils.copyProperties(userDto, principal);
    principal.setAuthorities(authorities);
    return new UsernamePasswordAuthenticationToken(principal, token, authorities);
  }

  /**
   * @description: 验证token是否有效
   * @param authToken token
   * @return boolean 是否验证通过
   */
  public boolean validateToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
      return true;
    } catch (SecurityException | MalformedJwtException e) {
      log.info("Invalid JWT signature.");
      log.error(String.valueOf(e));
      e.printStackTrace();
    } catch (ExpiredJwtException e) {
      log.info("Expired JWT token.");
      log.error(String.valueOf(e));
    } catch (UnsupportedJwtException e) {
      log.info("Unsupported JWT token.");
      log.error(String.valueOf(e));
    } catch (IllegalArgumentException e) {
      log.info("JWT token compact of handler are invalid.");
      log.error(String.valueOf(e));
    }
    return false;
  }

  /**
   * @description: 获取Token
   * @param request http请求
   * @return 返回token对象
   */
  public String getToken(HttpServletRequest request) {
    final String requestHeader = request.getHeader(properties.getHeader());
    if (requestHeader != null && requestHeader.startsWith(properties.getTokenStartWith())) {
      return requestHeader.substring(7);
    }
    return null;
  }
}
