package com.microservices.scn.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigurationApplication {

  public static void main(String[] args) {
    System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
    SpringApplication.run(ConfigurationApplication.class, args);
  }

}
