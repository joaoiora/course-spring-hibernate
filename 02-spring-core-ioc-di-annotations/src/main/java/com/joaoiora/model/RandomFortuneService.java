package com.joaoiora.model;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Component
public class RandomFortuneService
  implements FortuneService {

  /**
   *
   */
  private final List<String> fortunes = List.of("The love of your life is stepping into your planet this summer.",
                                                "A dream you have will come true.",
                                                "You must try, or hate yourself for not trying.",
                                                "Your ability for accomplishment will follow with success.",
                                                "It's better to be alone sometimes.");

  @Override
  public String getFortune() {
    return fortunes.get(new Random().nextInt(fortunes.size()));
  }

}
