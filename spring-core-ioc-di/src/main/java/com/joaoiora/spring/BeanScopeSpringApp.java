package com.joaoiora.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joaoiora.model.Coach;

/**
 * @author João Iora
 */
public class BeanScopeSpringApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml")) {

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
      System.out.println("---------------------------------------");

      final var prototypeCoach = context.getBean("prototypeCoach",
                                                 Coach.class);
      final var anotherPrototypeCoach = context.getBean("prototypeCoach",
                                                        Coach.class);

      System.out.println("Same objects reference: " +
                         (prototypeCoach == anotherPrototypeCoach));
      System.out.println("Prototype Coach: " +
                         prototypeCoach);
      System.out.println("Another Prototype Coach: " +
                         anotherPrototypeCoach);
    }
  }

}
