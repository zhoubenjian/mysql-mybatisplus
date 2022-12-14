package com.benjamin.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)   // 是否开启 (true 开启  false隐藏。生产环境建议隐藏)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.benjamin.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Benjamin's Swagger2 Api documentation")
                .description("Just have a little faith.")
                .termsOfServiceUrl("http://localhost:9000/swagger-ui.html")
                .contact(new Contact("Benjamin", "", "bjzhou@outlook.com"))
                .version("1.0")
                .build();
    }
}
