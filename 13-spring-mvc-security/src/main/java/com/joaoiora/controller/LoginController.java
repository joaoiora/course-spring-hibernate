package com.joaoiora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author João Iora
 */
@Controller
public class LoginController {

  /**
   * @return
   */
  @GetMapping(value = "/showLoginPage")
  public String showLoginPage() {
    return "login";
  }

  /**
   * @return
   */
  @GetMapping(value = "/access-denied")
  public String accessDenied() {
    return "access-denied";
  }

}
