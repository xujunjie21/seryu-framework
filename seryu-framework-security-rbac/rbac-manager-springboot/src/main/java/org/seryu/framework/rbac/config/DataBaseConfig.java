package org.seryu.framework.rbac.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @program: test-parentz
 * @description:
 * @author: xujunjie
 * @create: 2020-07-14 21:05
 **/
@Configuration
public class DataBaseConfig {
    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    //DataSource配置
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

}
