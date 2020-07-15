package org.seryu.framework.security.config;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.security.JwtAccessDeniedHandler;
import org.seryu.framework.security.JwtAuthenticationEntryPoint;
import org.seryu.framework.security.adapter.DefPermitAllsAdapter;
import org.seryu.framework.security.adapter.PermitAllsAdapter;
import org.seryu.framework.security.dto.PermitAllsDto;
import org.seryu.framework.security.token.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: seryu-framework-security
 * @description: 权限框架认证配置
 * @author: xujunjie
 * @create: 2020-04-08 15:34
 **/
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    private TokenProvider tokenProvider;
    private CorsFilter corsFilter;
    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    private JwtAccessDeniedHandler accessDeniedHandler;
    private ApplicationContext applicationContext;
    @Autowired
    private PermitAllsAdapter permitAllsAdapter;

    @Autowired
    private AccessDecisionManager accessDecisionManager;
    @Autowired
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    public SecurityConfig(TokenProvider tokenProvider, CorsFilter corsFilter, JwtAuthenticationEntryPoint authenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler, ApplicationContext applicationContext) {
        this.tokenProvider = tokenProvider;
        this.corsFilter = corsFilter;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.accessDeniedHandler = jwtAccessDeniedHandler;
        this.applicationContext = applicationContext;
    }

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        // 去除 ROLE_ 前缀
        return new GrantedAuthorityDefaults("");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 密码加密方式
        return new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5");
    }

    private TokenConfigurer securityConfigurerAdapter() {
        return new TokenConfigurer(tokenProvider);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 搜寻匿名标记 url： @AnonymousAccess
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
        Set<String> anonymousUrls = new HashSet<>();
        // 执行静态资源加载
        setMatchersPermitAll(httpSecurity);
        httpSecurity
                // 禁用 CSRF
                .csrf().disable()
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                // 授权异常
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)

                // 防止iframe 造成跨域
                .and()
                .headers()
                .frameOptions()
                .disable()

                // 不创建会话
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>()
                {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(accessDecisionManager);
                        return o;
                    }
                })
                // 所有请求都需要认证
                .anyRequest().authenticated()
                .and().apply(securityConfigurerAdapter());
    }

    /**
     * 设置不进行认证
     * @param httpSecurity
     */
    private void setMatchersPermitAll(HttpSecurity httpSecurity)
    {
        List<PermitAllsDto> permitAllsDtos = permitAllsAdapter.get();
        if(!CollectionUtils.isEmpty(permitAllsDtos) && permitAllsDtos.size() > 0)
        {
            permitAllsDtos.forEach(info->
            {
                try {
                    if(null != info.getHttpMethod())
                    {
                        httpSecurity.authorizeRequests().antMatchers(info.getHttpMethod(),info.getUris()).permitAll();
                    }
                    else
                    {
                        httpSecurity.authorizeRequests().antMatchers(info.getUris()).permitAll();
                    }

                } catch (Exception e) {
                    log.error("添加静态资源异常: {} {}",info.getHttpMethod(),info.getUris());
                }
            });
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public PermitAllsAdapter getPermitAllsAdapter()
    {
        return new DefPermitAllsAdapter();
    }
}
