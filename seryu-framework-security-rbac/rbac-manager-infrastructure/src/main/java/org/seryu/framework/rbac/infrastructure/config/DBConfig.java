package org.seryu.framework.rbac.infrastructure.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.seryu.framework.db.mybatisPlugs.code.MetaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: ${PROJECT_NAME}
 * @description: 数据库连接配置
 * @author: ${USER}
 * @create: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 */
@Data
@Slf4j
@Configuration
@MapperScan(
    basePackages = "org.seryu.framework.rbac.infrastructure.repository.*",
    sqlSessionTemplateRef = "sqlSessionTemplate")
public class DBConfig {
  @Autowired private PaginationInterceptor paginationInterceptor;

  @Bean
  public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor page = new PaginationInterceptor();
    page.setDialectType("mysql");
    return page;
  }

  @Bean(name = "sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
      throws Exception {
    GlobalConfig globalConfig = new GlobalConfig();
    globalConfig.setMetaObjectHandler(new MetaHandler());

    MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setGlobalConfig(globalConfig);
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    List<Resource> resourceList = new ArrayList<>();
    resourceList.addAll(Arrays.asList(resolver.getResources("classpath:mapper/*.xml")));
    Resource[] resources = resourceList.toArray(new Resource[resourceList.size()]);
    bean.setMapperLocations(resources);

    bean.setPlugins(paginationInterceptor);
    return bean.getObject();
  }

  @Bean(name = "transactionManager")
  @Primary
  public DataSourceTransactionManager transactionManager(
      @Qualifier("dataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "sqlSessionTemplate")
  @Primary
  public SqlSessionTemplate sqlSessionTemplate(
      @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
