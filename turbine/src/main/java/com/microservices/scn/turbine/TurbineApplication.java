package com.microservices.scn.turbine;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
public class TurbineApplication {

  public static void main(String[] args) {
    System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
    SpringApplication.run(TurbineApplication.class, args);
  }

}
