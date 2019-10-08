package com.sftp.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author linzf
 * @since 2019-10-08
 * 类描述：sftp测试专用类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis((input) -> {
                    Class<?> declaringClass = input.declaringClass();
                    if (declaringClass.isAnnotationPresent(RestController.class)) {
                        return true;
                    }
                    if (input.isAnnotatedWith(ResponseBody.class)) {
                        return true;
                    }
                    return false;
                })
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //大标题
                .title("sftp接口测试页面！")
                //版本
                .version("1.0")
                .build();
    }

}
