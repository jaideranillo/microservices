package com.microservices.scn.comic;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WriterClient {

  private String Url = "http://writer-service/writer";

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod="fallbackWriter")
  public String contactWriter(){
    ResponseEntity<String> response = restTemplate.getForEntity(Url, String.class);
    return response.getBody();
  }

  public String fallbackWriter(){
    return "Error contact writer. This is a default message";
  }

}
