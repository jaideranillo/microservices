package com.microservices.scn.writer.Configuration;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class GetInformation implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

  private static int port;

  public static int getPort(){
    return port;
  }

  @Override
  public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
    port = event.getEmbeddedServletContainer().getPort();
  }
}
