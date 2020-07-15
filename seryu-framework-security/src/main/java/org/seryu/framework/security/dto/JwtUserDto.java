package org.seryu.framework.security.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @program: seryu-framework-security
 * @description: 用户JWT封装对象
 * @author: xujunjie
 * @create: 2020-04-08 14:09
 */
@Getter
public class JwtUserDto extends UserDto implements UserDetails {
  private Collection<? extends GrantedAuthority> authorities;

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  public boolean isAccountNonExpired() {
    return true;
  }

  public boolean isAccountNonLocked() {
    return true;
  }

  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * @description: 获取角色列表
   * @return collection 角色集合
   */
  public Collection getRoles() {
    return getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toSet());
  }
}
