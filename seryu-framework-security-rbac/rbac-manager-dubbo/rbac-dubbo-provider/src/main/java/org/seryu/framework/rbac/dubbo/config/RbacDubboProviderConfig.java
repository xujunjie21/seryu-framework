package org.seryu.framework.rbac.dubbo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: ${PROJECT_NAME}
 * @description: dubbo配置
 * @author: ${USER}
 * @create: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 **/
@Configuration
@ImportResource({"classpath*:dubbo/rbac/serivce/dubbo.xml"})
public class RbacDubboProviderConfig
{

}
