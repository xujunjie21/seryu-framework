package org.seryu.framework.security.service;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.collection.CollectionUtil;
import org.seryu.framework.security.SecurityPermissionService;
import org.seryu.framework.security.bo.SecurityPermissionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: seryu-framework-security
 * @description:
 * @author: xujunjie
 * @create: 2020-05-06 18:33
 */
@Service
public class SeryuInvocationSecurityMetadataSourceService
    implements FilterInvocationSecurityMetadataSource {
  @Autowired private SecurityPermissionService permissionServiceQryI;

  /** 创建定时缓存 */
  private TimedCache<String, List<SecurityPermissionDetail>> timedCache =
      CacheUtil.newTimedCache(10 * 1000);

  private String key = "Permissions";

  @Override
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
    String requestUrl = ((FilterInvocation) object).getRequestUrl();
    HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    List<SecurityPermissionDetail> all = timedCache.get(key);

    if (CollectionUtil.isEmpty(all)) {
      synchronized (this) {
        all = timedCache.get(key);
        if (CollectionUtil.isEmpty(all)) {
          timedCache.put(key, permissionServiceQryI.findAll());
          all = timedCache.get(key);
        }
      }
    }

    AntPathRequestMatcher matcher;
    for (SecurityPermissionDetail bo : all) {
      matcher = new AntPathRequestMatcher(bo.getUrl());
      if (matcher.matches(request)) {
        Set<String> collect = new HashSet<>();
        bo.getRoles()
            .forEach(
                info -> {
                  collect.add(info.getRoleKey());
                });
        return SecurityConfig.createList(collect.toArray(new String[bo.getRoles().size()]));
      }
    }

    return null; // SecurityConfig.createList("Test");
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return true;
  }
}
