package com.microservices.scn.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdministrationConfiguration {

  public static void main(String[] args) {
    System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
    SpringApplication.run(AdministrationConfiguration.class, args);
  }
}
