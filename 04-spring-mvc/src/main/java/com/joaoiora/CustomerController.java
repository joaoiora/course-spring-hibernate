package com.joaoiora;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author João Iora
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

  /**
   * @param binder
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    final var stringTrimmerEditor = new StringTrimmerEditor(true);
    binder.registerCustomEditor(String.class,
                                stringTrimmerEditor);
  }

  /**
   * @param model
   *
   * @return
   */
  @RequestMapping("/showForm")
  public String showForm(Model model) {
    model.addAttribute("customer",
                       new Customer());
    return "customer-form";
  }

  /**
   * @param customer
   * @param bindingResult
   *
   * @return
   */
  @RequestMapping("/processForm")
  public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
    System.out.println("Last name: |" +
                       customer.getLastName() +
                       "|");
    System.out.println(">> Binding Result: " +
                       bindingResult);
    if (bindingResult.hasErrors()) {
      return "customer-form";
    }
    return "customer-confirmation";
  }

}
