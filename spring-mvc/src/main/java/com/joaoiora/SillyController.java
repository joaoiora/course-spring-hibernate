package com.joaoiora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author João Iora
 */
@Controller
public class SillyController {

  /**
   * @return
   */
  @RequestMapping(value = "/showForm")
  public String showForm() {
    return "silly";
  }

}
