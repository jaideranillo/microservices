package com.microservices.scn.writer;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
@EnableSwagger2
public class WriterApplication {

  @Bean
  public Docket writerApi() {
    ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2).select();
    apiSelectorBuilder.apis(withClassAnnotation(Api.class));
    return apiSelectorBuilder
        .build()
        .pathMapping("/")
        .useDefaultResponseMessages(false)
        .apiInfo(writerApiInfo())
        .forCodeGeneration(true);
  }

  private ApiInfo writerApiInfo() {
    return new ApiInfoBuilder()
        .title("Service Writer Api")
        .version("1.0")
        .license("Apache License Version 2.0")
        .build();
  }


  public static void main(String[] args) {
    SpringApplication.run(WriterApplication.class, args);
  }

}
