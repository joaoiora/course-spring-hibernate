package com.joaoiora.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author João Iora
 */
@RestController
public class SimpleRestController {

  /**
   *
   */
  @Value(value = "${coach.name}")
  private String coachName;

  /**
   *
   */
  @Value(value = "${team.name}")
  private String teamName;

  /**
   * @return
   */
  @GetMapping(value = "/")
  public String home() {
    return "Hello World! Current time on server is " +
           LocalDateTime.now();
  }

  /**
   * @return
   */
  @GetMapping(value = "/teaminfo")
  public String teamInfo() {
    return "Coach: " +
           coachName +
           ", Team: " +
           teamName +
           ".";
  }

}
