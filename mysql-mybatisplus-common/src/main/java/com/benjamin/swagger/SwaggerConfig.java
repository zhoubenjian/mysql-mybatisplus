package com.benjamin.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.lsqingfeng.action.swagger.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(setHeaderToken());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("action-swagger")
                .description("swagger实战")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

    /**
     * 设置swagger文档中全局参数
     * @return  java.util.List<springfox.documentation.service.Parameter>
     */
    private List<Parameter> setHeaderToken() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder userId = new ParameterBuilder();
        userId.name("token")
                .description("用户TOKEN")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true).build();
        pars.add(userId.build());
        return pars;
    }
}
