package com.microservices.scn.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

  public static void main(String[] args) {
    System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
    SpringApplication.run(EurekaApplication.class, args);
  }
}
