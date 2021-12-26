package com.joaoiora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author João Iora
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

  /**
   * @param model
   *
   * @return
   */
  @RequestMapping(value = "/showForm")
  public String showForm(Model model) {
    model.addAttribute("student",
                       new Student());
    return "student-form";
  }

  /**
   * @param student
   *
   * @return
   */
  @RequestMapping(value = "/processForm")
  public String processForm(@ModelAttribute(value = "student") Student student) {
    System.out.println(student);
    return "student-confirmation";
  }

}
