package com.joaoiora;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author João Iora
 */
@Configuration
@PropertySource("classpath:mylogger.properties")
public class MyLoggerConfig {

  /**
   *
   */
  @Value("${root.logger.level}")
  private String rootLoggerLevel;

  /**
   *
   */
  @Value("${printed.logger.level}")
  private String printedLoggerLevel;

  /**
   *
   */
  @PostConstruct
  public void initLogger() {
    final var rootLevel = Level.parse(rootLoggerLevel);
    final var printedLevel = Level.parse(printedLoggerLevel);
    final var applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
    final var loggerParent = applicationContextLogger.getParent();
    loggerParent.setLevel(rootLevel);
    final var consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(printedLevel);
    consoleHandler.setFormatter(new SimpleFormatter());
    loggerParent.addHandler(consoleHandler);
  }

}
