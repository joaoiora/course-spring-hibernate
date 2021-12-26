package com.joaoiora.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joaoiora.model.SwimCoach;

/**
 * @author João Iora
 */
public class SwimCoachApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (var context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
      final var coach = context.getBean("swimCoach",
                                        SwimCoach.class);
      System.out.println("Team Name: " +
                         coach.getTeam());
      System.out.println("Coach Email: " +
                         coach.getEmail());
      System.out.println(coach.getDailyWorkout());
      System.out.println(coach.getDailyFortune());
    }
  }

}
