package com.joaoiora;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author João Iora
 */
public class SwimCoach
  implements Coach {

  /**
   *
   */
  private final FortuneService fortuneService;

  /**
  *
  */
  @Value("${foo.email}")
  private String email;

  /**
  *
  */
  @Value("${foo.team}")
  private String team;

  /**
   * @param fortuneService
   */
  public SwimCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Swim 1000 meters as a warm up.";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the team
   */
  public String getTeam() {
    return team;
  }

  /**
   * @param team the team to set
   */
  public void setTeam(String team) {
    this.team = team;
  }

}
