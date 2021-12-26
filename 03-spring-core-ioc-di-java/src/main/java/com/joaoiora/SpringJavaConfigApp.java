package com.joaoiora;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author João Iora
 */
public class SpringJavaConfigApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(SportConfig2.class)) {
      final var coach = context.getBean("swimCoach",
                                        SwimCoach.class);
      System.out.println(coach.getDailyWorkout());
      System.out.println(coach.getDailyFortune());
      System.out.println(coach.getTeam());
      System.out.println(coach.getEmail());
    }
  }

}
