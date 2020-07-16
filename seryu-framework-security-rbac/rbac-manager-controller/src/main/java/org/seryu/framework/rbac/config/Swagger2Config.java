package org.seryu.framework.rbac.config;

import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.seryu.framework.core.web.message.converters.SeryuMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/** Created by xujunjie on 17/8/22. */
@Configuration
@EnableSwagger2
public class Swagger2Config {
  @Bean
  public Docket admin() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(
            new ApiInfoBuilder()
                .title("RBAC后台接口")
                .description("用于后台管理类")
                .termsOfServiceUrl("")
                .version("1.0")
                .build())
        .securitySchemes(getSecurityScheme())
        // .globalOperationParameters(pars)
        .select()
        .apis(RequestHandlerSelectors.basePackage("org.seryu.framework.rbac.controller"))
        .paths(PathSelectors.regex("/admin/.*"))
        .build()
        .groupName("后台接口文档");
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(
            new ApiInfoBuilder()
                .title("RBAC接口")
                .description("用于对外接口类")
                .termsOfServiceUrl("")
                .version("1.0")
                .build())
        .securitySchemes(getSecurityScheme())
        // .globalOperationParameters(pars)
        .select()
        .apis(RequestHandlerSelectors.basePackage("org.seryu.framework.rbac.controller"))
        .paths(PathSelectors.regex("/api/.*"))
        .build()
        .groupName("下发接口文档");
  }

  private List<ApiKey> getSecurityScheme() {
    List<ApiKey> list = new ArrayList<>();
    return list;
  }

  /**
   * 统一输出风格
   *
   * @return
   */
  @SeryuMessageConverter(
      name = "jackjson",
      uri = {"/admin", "/api"})
  public HttpMessageConverter jackjson() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = new ObjectMapper();
    // 统一返回数据的输出风格
    objectMapper.setPropertyNamingStrategy(
        new com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy());
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //                objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    converter.setObjectMapper(objectMapper);
    return converter;
  }
}
