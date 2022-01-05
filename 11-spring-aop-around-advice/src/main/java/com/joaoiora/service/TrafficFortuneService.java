package com.joaoiora.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Component
public class TrafficFortuneService {

  /**
   * @return
   */
  public String getFortune() {
    try {
      TimeUnit.SECONDS.sleep(1);
    }
    catch (final Exception e) {
      e.printStackTrace();
    }
    return "Expect heavy traffic this morning.";
  }

  /**
   * @return
   */
  public String getFortuneThatThrowsException() {
    throw new RuntimeException("Accident on the Highway. It is closed until further notice.");
  }

}
