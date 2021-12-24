package com.joaoiora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Component
public class TennisCoach
  implements Coach {

  /**
   *
   */
  @Autowired
  @Qualifier(value = "happyFortuneService")
  private FortuneService fortuneService;

  /**
   *
   */
  public TennisCoach() {
    super();
    System.out.println(">> TennisCoach: inside no-arg ctor");
  }

  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
