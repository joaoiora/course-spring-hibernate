package com.joaoiora.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Component
@Scope(value = "request")
public class TennisCoach
  implements Coach {

  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley";
  }

}
