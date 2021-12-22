package com.joaoiora.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joaoiora.model.Coach;

/**
 * @author João Iora
 */
public class Practice3SpringApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var context = new ClassPathXmlApplicationContext("practice3-applicationContext.xml")) {

      final var coach = context.getBean("coach",
                                        Coach.class);
      final var anotherCoach = context.getBean("coach",
                                               Coach.class);

      System.out.println("Same objects reference: " +
                         (coach == anotherCoach));
      System.out.println("Coach: " +
                         coach);
      System.out.println("Another Coach: " +
                         anotherCoach);
      System.out.println(coach.getDailyFortune());
      System.out.println(anotherCoach.getDailyFortune());
      System.out.println("---------------------------------------");

      final var soccerCoach = context.getBean("soccerCoach",
                                              Coach.class);
      final var anotherSoccerCoach = context.getBean("soccerCoach",
                                                     Coach.class);

      System.out.println("Same objects reference: " +
                         (soccerCoach == anotherSoccerCoach));
      System.out.println("Soccer Coach: " +
                         soccerCoach);
      System.out.println("Another Soccer Coach: " +
                         anotherSoccerCoach);
      System.out.println(soccerCoach.getDailyFortune());
      System.out.println(anotherSoccerCoach.getDailyFortune());
    }
  }

}
