package com.joaoiora.model;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author João Iora
 */
public class SoccerCoach
  implements Coach, DisposableBean {

  /**
   *
   */
  private FortuneService fortuneService;

  /**
   *
   */
  private String emailAddress;

  /**
   *
   */
  private String team;

  /**
   *
   */
  public SoccerCoach() {
    System.out.println("inside no-arg constructor");
  }

  /**
  *
  */
  public void doMyStartupStuff() {
    System.out.println("TrackCoach: inside method doMyStartupStuff");
  }

  @Override
  public void destroy()
    throws Exception {
    System.out.println("SoccerCoach: inside method destroy");
  }

  /**
   * @return the fortuneService
   */
  public FortuneService getFortuneService() {
    return fortuneService;
  }

  /**
   * @param fortuneService the fortuneService to set
   */
  public void setFortuneService(FortuneService fortuneService) {
    System.out.println("inside setter method - setFortuneService");
    this.fortuneService = fortuneService;
  }

  /**
   * @return the emailAddress
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * @param emailAddress the emailAddress to set
   */
  public void setEmailAddress(String emailAddress) {
    System.out.println("inside setter method - setEmailAddress");
    this.emailAddress = emailAddress;
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
    System.out.println("inside setter method - setTeam");
    this.team = team;
  }

  @Override
  public String getDailyWorkout() {
    return "Score 100 goals in under an hour";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
