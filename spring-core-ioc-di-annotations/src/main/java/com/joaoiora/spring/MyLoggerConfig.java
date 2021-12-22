package com.joaoiora.spring;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author João Iora
 */
public class MyLoggerConfig {

  /**
   *
   */
  private String rootLoggerLevel;

  /**
   *
   */
  private String printedLoggerLevel;

  /**
   *
   */
  public void initLogger() {
    // parse levels
    final var rootLevel = Level.parse(rootLoggerLevel);
    final var printedLevel = Level.parse(printedLoggerLevel);

    // get logger for app context
    final var applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());

    // get parent logger
    final var loggerParent = applicationContextLogger.getParent();

    // set root logging level
    loggerParent.setLevel(rootLevel);

    // set up console handler
    final var consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(printedLevel);
    consoleHandler.setFormatter(new SimpleFormatter());

    // add handler to the logger
    loggerParent.addHandler(consoleHandler);
  }

  /**
   * @param rootLoggerLevel
   */
  public void setRootLoggerLevel(String rootLoggerLevel) {
    this.rootLoggerLevel = rootLoggerLevel;
  }

  /**
   * @param printedLoggerLevel
   */
  public void setPrintedLoggerLevel(String printedLoggerLevel) {
    this.printedLoggerLevel = printedLoggerLevel;
  }

}
