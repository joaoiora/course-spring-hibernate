package com.joaoiora;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author João Iora
 */
public class AnnotationDemoApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(SportConfig.class)) {
      final var coach = context.getBean("tennisCoach",
                                        Coach.class);
      System.out.println(coach.getDailyWorkout());

      final var coach2 = context.getBean(Coach.class);
      System.out.println(coach2.getDailyWorkout());

      System.out.println("Same object reference: " +
                         (coach == coach2));
      System.out.println("Coach: " +
                         coach);
      System.out.println("Coach 2: " +
                         coach2);
    }
  }

}
