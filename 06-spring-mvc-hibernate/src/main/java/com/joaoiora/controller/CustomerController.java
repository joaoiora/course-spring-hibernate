package com.joaoiora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author João Iora
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

  /**
   * @param model
   *
   * @return
   */
  @RequestMapping(value = "/list")
  public String listCustomers(Model model) {
    return "list-customers";
  }

}
