package com.joaoiora;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.joaoiora.service.TrafficFortuneService;

/**
 * @author João Iora
 */
public class AroundAdviceApp {

  /**
   *
   */
  private static final Logger LOG = Logger.getLogger(AroundAdviceApp.class.getName());

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(AOPConfig.class)) {
      LOG.info("Starting program...");
      final var service = context.getBean(TrafficFortuneService.class);
      LOG.info("Today's Traffic Fortune is: " +
               service.getFortune());
      LOG.info("--------------------------------------------------------------------------------------");
      LOG.info("Tomorrow's Traffic Fortune is: " +
               service.getFortuneThatThrowsException());
      LOG.info("Finished.");
    }
  }

}
