package com.joaoiora;

/**
 * @author João Iora
 */
public class SadFortuneService
  implements FortuneService {

  @Override
  public String getFortune() {
    return "Today is a sad day";
  }

}
