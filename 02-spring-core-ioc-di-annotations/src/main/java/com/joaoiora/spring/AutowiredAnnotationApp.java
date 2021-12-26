package com.joaoiora.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joaoiora.model.Coach;

/**
 * @author João Iora
 */
public class AutowiredAnnotationApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (var context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
      final var coach = context.getBean("tennisCoach",
                                        Coach.class);
      System.out.println(coach.getDailyWorkout());
      System.out.println(coach.getDailyFortune());
    }
  }

}
