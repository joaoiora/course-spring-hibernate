package com.joaoiora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joaoiora.service.CustomerService;

/**
 * @author João Iora
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

  /**
   *
   */
  @Autowired
  private CustomerService service;

  /**
   * @param model
   *
   * @return
   */
  @GetMapping(value = "/list")
  // @PostMapping(value = "/list")
  public String listCustomers(Model model) {
    model.addAttribute("customers",
                       service.getCustomers());
    return "list-customers";
  }

}
