package com.joaoiora.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
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
  private UserDetailsManager userDetailsManager;

  /**
   *
   */
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  /**
   *
   */
  private static final Logger logger = Logger
      .getLogger(RegistrationController.class.getName());

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
    logger.info("Processing registration form for: " +
                userName);
    // form validation
    if (binding.hasErrors()) {
      model.addAttribute("crmUser",
                         new CrmUser());
      model.addAttribute("registrationError",
                         "User name/password can not be empty.");
      logger.warning("User name/password can not be empty.");
      return "registration-form";
    }
    final var userExists = doesUserExist(userName);
    if (userExists) {
      model.addAttribute("crmUser",
                         new CrmUser());
      model.addAttribute("registrationError",
                         "User name already exists.");
      logger.warning("User name already exists.");
      return "registration-form";
    }
    var encodedPassword = passwordEncoder.encode(crmUser.getPassword());
    encodedPassword = "{bcrypt}" +
                      encodedPassword;
    final var authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
    final var tempUser = new User(userName, encodedPassword, authorities);
    userDetailsManager.createUser(tempUser);
    logger.info("Successfully created user: " +
                userName);
    return "registration-confirmation";
  }

  /**
   * @param userName
   *
   * @return
   */
  private boolean doesUserExist(String userName) {
    logger.info("Checking if user exists: " +
                userName);
    final var exists = userDetailsManager.userExists(userName);
    logger.info("User: " +
                userName +
                ", exists: " +
                exists);
    return exists;
  }

}
