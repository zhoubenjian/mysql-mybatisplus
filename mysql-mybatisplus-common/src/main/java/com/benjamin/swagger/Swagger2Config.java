package com.benjamin.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
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
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.benjamin.controller"))
                .paths(PathSelectors.any())
                .build();
    }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("benjamin's Swagger2 Api ")
                .description("Just have a little faith.")
                .termsOfServiceUrl("http://127.0.0.1:9000/swagger.ui")
                //.contact("")
                .version("1.0")
                .build();
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/null/api-docs",
//                "/api-docs").setKeepQueryParams(true);
//        registry.addRedirectViewController("/null/swagger-resources/configuration/ui",
//                "/swagger-resources/configuration/ui");
//        registry.addRedirectViewController("/null/swagger-resources/configuration/security",
//                "/swagger-resources/configuration/security");
//        registry.addRedirectViewController("/null/swagger-resources", "/swagger-resources");
//    }
}
