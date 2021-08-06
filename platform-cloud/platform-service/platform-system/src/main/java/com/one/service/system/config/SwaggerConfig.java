package com.one.service.system.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableKnife4j
public class SwaggerConfig {

    /**
     * 自定义 footer 用到
     */
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerConfig(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }



    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.OAS_30)

                // 添加 自定义 footer
                .extensions(openApiExtensionResolver.buildSettingExtensions())

                .apiInfo(apiInfo())
                .select()
                //指定接口包所在路径
//                .apis(RequestHandlerSelectors.basePackage("com.one.service.system"))
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //方法上面有@ApiOperation注解 生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("系统服务接口文档")
                .description("One-Platform 系统服务接口文档")
                .termsOfServiceUrl("http://localhost:9002/")
                .contact(new Contact("明天","www.xxx.com","lmm_@163.com"))
                .version("1.0")
                .build();
    }


}
