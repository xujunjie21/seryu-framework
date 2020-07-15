package org.seryu.framework.security.service;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * @program: seryu-framework-security
 * @description:
 * @author: xujunjie
 * @create: 2020-05-06 18:34
 */
@Service
public class SeryuAccessDecisionManager implements AccessDecisionManager {
  @Override
  public void decide(
      Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
      throws AccessDeniedException, InsufficientAuthenticationException {

    if (null == configAttributes || configAttributes.size() <= 0) {
      return;
    }
    ConfigAttribute c;
    String needRole;
    for (Iterator<ConfigAttribute> iterator = configAttributes.iterator(); iterator.hasNext(); ) {
      c = iterator.next();
      needRole = c.getAttribute();
      for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
        if (needRole.trim().equals(grantedAuthority.getAuthority())) {
          return;
        }
      }
    }
    throw new AccessDeniedException("没有对应的权限");
  }

  @Override
  public boolean supports(ConfigAttribute attribute) {
    return false;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return false;
  }
}
