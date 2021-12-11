package com.joaoiora.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joaoiora.model.Coach;

/**
 * @author João Iora
 */
public class CoachSpringApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
      final var coach = context.getBean("coach",
                                        Coach.class);
      System.out.println(coach.getDailyWorkout());
      System.out.println(coach.getDailyFortune());
    }
  }

}
