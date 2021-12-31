package com.joaoiora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joaoiora.entity.Customer;
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

  /**
   * @param model
   *
   * @return
   */
  @GetMapping(value = "/showFormForAdd")
  public String showFormForAdd(Model model) {
    model.addAttribute("customer",
                       new Customer());
    return "customer-form";
  }

  /**
   * @param customer
   * @param model
   *
   * @return
   */
  @PostMapping(value = "/saveCustomer")
  public String saveCustomer(@ModelAttribute(value = "customer") Customer customer, Model model) {
    service.saveCustomer(customer);
    return "redirect:/customer/list";
  }

  /**
   * @param id
   * @param model
   *
   * @return
   */
  @GetMapping(value = "/showFormForUpdate")
  public String showFormForUpdate(@RequestParam(value = "id") Integer id, Model model) {
    final var customer = service.loadCustomer(id);
    model.addAttribute("customer",
                       customer);
    return "customer-form";
  }

}
