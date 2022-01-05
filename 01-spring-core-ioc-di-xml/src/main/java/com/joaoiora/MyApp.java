package com.joaoiora;

import com.joaoiora.model.Coach;
import com.joaoiora.model.HappyFortuneService;
import com.joaoiora.model.TrackCoach;

/**
 * @author João Iora
 */
public class MyApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    final Coach coach = new TrackCoach(new HappyFortuneService());
    System.out.println(coach.getDailyFortune());
  }

}
