package com.joaoiora.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Component
@Scope
public class TennisCoach
  implements Coach {

  /**
   *
   */
  @Autowired
  @Qualifier(value = "randomFortuneService")
  private FortuneService fortuneService;

  /**
   *
   */
  public TennisCoach() {
    super();
    System.out.println(">> TennisCoach: inside no-arg ctor");
  }

  // /**
  // * @param fortuneService
  // */
  // @Autowired
  // public TennisCoach(FortuneService fortuneService) {
  // this.fortuneService = fortuneService;
  // }

  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  /**
   * @param fortuneService
   */
  // @Autowired
  public void doSomeStuff(FortuneService fortuneService) {
    System.out.println(">> TennisCoach: inside doSomeStuff method");
    this.fortuneService = fortuneService;
  }

  /**
   * @param fortuneService the fortuneService to set
   */
  // @Autowired
  public void setFortuneService(FortuneService fortuneService) {
    System.out.println(">> TennisCoach: inside setFortuneService method");
    this.fortuneService = fortuneService;
  }

}
