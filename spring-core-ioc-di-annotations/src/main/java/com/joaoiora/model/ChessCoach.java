package com.joaoiora.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Component
public class ChessCoach
  implements Coach {

  /**
   *
   */
  @Autowired
  @Qualifier(value = "fileRandomFortuneService")
  private FortuneService fortuneService;

  /**
   *
   */
  public ChessCoach() {
    System.out.println(">> ChessCoach: inside no-arg ctor");
  }

  @Override
  public String getDailyWorkout() {
    return "Play 100 games a day";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
