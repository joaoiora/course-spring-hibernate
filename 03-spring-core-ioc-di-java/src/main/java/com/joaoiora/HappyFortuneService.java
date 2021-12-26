package com.joaoiora;

import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Component
public class HappyFortuneService
  implements FortuneService {

  @Override
  public String getFortune() {
    return "Today is your lucky day!";
  }

}
