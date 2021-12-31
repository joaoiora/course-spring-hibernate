package com.joaoiora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joaoiora.service.MultiDataSourceService;

/**
 * @author João Iora
 */
@Controller
@RequestMapping(value = "/multi-datasource")
public class MultiDataSourceController {

  /**
   *
   */
  @Autowired
  private MultiDataSourceService service;

  /**
   * @param model
   *
   * @return
   */
  @GetMapping("/list")
  public String getData(Model model) {
    model.addAttribute("customers",
                       service.getCustomers());
    model.addAttribute("employees",
                       service.getEmployees());
    return "display-results";
  }

}
