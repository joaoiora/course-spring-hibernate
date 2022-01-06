package com.joaoiora.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joaoiora.model.CrmUser;
import com.joaoiora.service.UserService;

/**
 * @author João Iora
 */
@Controller
@RequestMapping(value = "/register")
public class RegistrationController {

  /**
   *
   */
  @Autowired
  private UserService service;

  /**
   *
   */
  private static final Logger LOG = Logger
      .getLogger(RegistrationController.class.getName());

  /**
   * @param binder
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    final var trimmer = new StringTrimmerEditor(true);
    binder.registerCustomEditor(String.class,
                                trimmer);
  }

  /**
   * @param model
   *
   * @return
   */
  @GetMapping("/showRegistrationForm")
  public String showRegistrationForm(Model model) {
    model.addAttribute("crmUser",
                       new CrmUser());
    return "registration-form";
  }

  /**
   * @param crmUser
   * @param binding
   * @param model
   *
   * @return
   */
  @PostMapping("/processRegistrationForm")
  public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser crmUser,
                                        BindingResult binding, Model model) {
    final var userName = crmUser.getUserName();
    LOG.info("Processing registration form for: " +
             userName);
    if (binding.hasErrors()) {
      model.addAttribute("crmUser",
                         new CrmUser());
      model.addAttribute("registrationError",
                         "User name/password can not be empty.");
      LOG.warning("User name/password can not be empty.");
      return "registration-form";
    }
    final var userExists = doesUserExist(userName);
    if (userExists) {
      model.addAttribute("crmUser",
                         new CrmUser());
      model.addAttribute("registrationError",
                         "User name already exists.");
      LOG.warning("User name already exists.");
      return "registration-form";
    }
    return proccessRegistrationForm(crmUser,
                                    userName);
  }

  /**
   * @param crmUser
   * @param userName
   *
   * @return
   */
  private String proccessRegistrationForm(CrmUser crmUser,
                                          final String userName) {
    service.save(crmUser);
    LOG.info("Successfully created user: " +
             userName);
    return "registration-confirmation";
  }

  /**
   * @param userName
   *
   * @return
   */
  private boolean doesUserExist(String userName) {
    LOG.info("Checking if user exists: " +
             userName);
    final var exists = service.userExists(userName);
    LOG.info("User: " +
             userName +
             ", exists: " +
             exists);
    return exists;
  }

}
