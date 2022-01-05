package com.joaoiora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author João Iora
 */
@Controller
public class AppController {

  /**
   * @return
   */
  @GetMapping(value = "/")
  public String home() {
    return "home";
  }

}
