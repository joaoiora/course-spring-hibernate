package com.joaoiora;

import com.joaoiora.model.Coach;
import com.joaoiora.model.HappyFortuneService;
import com.joaoiora.model.TrackCoach;

public class MyApp {

  public static void main(String[] args) {
    final Coach coach = new TrackCoach(new HappyFortuneService());
    System.out.println(coach.getDailyWorkout());
  }

}
