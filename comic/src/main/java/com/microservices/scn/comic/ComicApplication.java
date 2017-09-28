package com.microservices.scn.comic;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

@SpringBootApplication
@EnableSwagger2
public class ComicApplication {

  @Bean
  public Docket comicApi() {
    ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2).select();
    apiSelectorBuilder.apis(withClassAnnotation(Api.class));
    return apiSelectorBuilder
        .build()
        .pathMapping("/")
        .useDefaultResponseMessages(false)
        .apiInfo(comicApiInfo())
        .forCodeGeneration(true);
  }

  private ApiInfo comicApiInfo() {
    return new ApiInfoBuilder()
        .title("Service Comic Api")
        .version("1.0")
        .license("Apache License Version 2.0")
        .build();
  }

  public static void main(String[] args) {
    SpringApplication.run(ComicApplication.class, args);
  }
}
