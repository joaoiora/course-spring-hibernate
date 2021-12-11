package com.joaoiora.model;

/**
 * @author João Iora
 */
public class TrackCoach
  implements Coach {

  /**
   *
   */
  private final FortuneService fortuneService;

  /**
   * @param fortuneService
   */
  public TrackCoach(FortuneService fortuneService) {
    System.out.println("inside construtor - foturneService as arg");
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5k";
  }

  @Override
  public String getDailyFortune() {
    return "Just do it: " +
           fortuneService.getFortune() +
           " aaa";
  }

}
