package com.joaoiora;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author João Iora
 */
@Configuration
// @ComponentScan(value = "com.joaoiora")
@PropertySource(value = "classpath:sport.properties")
public class SportConfig2 {

  @Bean
  public FortuneService sadFortuneService() {
    return new SadFortuneService();
  }

  /**
   * @return
   */
  @Bean
  public Coach swimCoach() {
    return new SwimCoach(sadFortuneService());
  }

}
