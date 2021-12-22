package com.joaoiora.model;

/**
 * @author João Iora
 */
public class ChessCoach
  implements Coach {

  /**
   *
   */
  private final FortuneService fortuneService;

  /**
   * @param fortuneService
   */
  public ChessCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  /**
   * @return the fortuneService
   */
  public FortuneService getFortuneService() {
    return fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Play 10 games of chess a day";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
