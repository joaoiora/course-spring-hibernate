package com.joaoiora.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joaoiora.model.SoccerCoach;

/**
 * @author João Iora
 */
public class PropertiesSoccerCoachSpringApp {

  public static void main(String[] args) {
    try (final var context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
      final var coach = context.getBean("anotherSoccerCoach",
                                        SoccerCoach.class);
      System.out.println(coach.getDailyWorkout());
      System.out.println(coach.getDailyFortune());

      System.out.println(coach.getEmailAddress());
      System.out.println(coach.getTeam());
    }
  }

}
