package com.joaoiora.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joaoiora.model.Customer;
import com.joaoiora.service.CustomerService;

/**
 * @author João Iora
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

  /**
   *
   */
  @Autowired
  @Qualifier(value = "customerServiceRestImpl")
  private CustomerService service;

  /**
   * @param model
   *
   * @return
   */
  @GetMapping("/list")
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
  @GetMapping("/add")
  public static String showFormForAdd(Model model) {
    model.addAttribute("customer",
                       new Customer());
    return "customer-form";
  }

  /**
   * @param customer
   *
   * @return
   */
  @PostMapping("/save")
  public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    service.saveCustomer(customer);
    return "redirect:/customer/list";
  }

  /**
   * @param id
   * @param model
   *
   * @return
   */
  @GetMapping("/update")
  public String update(@RequestParam("id") int id, Model model) {
    model.addAttribute("customer",
                       service.getCustomer(id));
    return "customer-form";
  }

  /**
   * @param id
   *
   * @return
   */
  @GetMapping("/delete")
  public String deleteCustomer(@RequestParam("id") int id) {
    service.deleteCustomer(id);
    return "redirect:/customer/list";
  }

}
