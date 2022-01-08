package com.joaoiora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author João Iora
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.joaoiora" })
public class SpringBootDemoApplication {

  /**
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoApplication.class,
                          args);
  }

}
