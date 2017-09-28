package com.microservices.scn.writer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController("/")
public class WriterController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  DiscoveryClient discoveryClient;

  @RequestMapping(value = "writer/", method = RequestMethod.GET)
  @ApiOperation(value = "Writer", nickname = "Writer", response = String.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
      @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
  public String findAll() {
    discoveryClient.getServices().forEach(id -> {
      discoveryClient.getInstances(id).forEach(instance -> {
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
      });
    });
    return  "Writing comics!!";
  }
}
