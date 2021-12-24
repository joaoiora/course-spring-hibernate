package com.joaoiora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author João Iora
 */
@Controller
public class HomeController {

  /**
   * @return
   */
  @RequestMapping(path = "/")
  public String render() {
    return "main-menu";
  }

}
