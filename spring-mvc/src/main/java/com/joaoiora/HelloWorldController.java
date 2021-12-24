package com.joaoiora;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author João Iora
 */
@Controller
public class HelloWorldController {

  /**
   * @return
   */
  @RequestMapping(value = "/showForm")
  public String showForm() {
    return "helloworld-form";
  }

  /**
   * @return
   */
  @RequestMapping(value = "/processForm")
  public String processForm() {
    return "helloworld";
  }

  /**
   * @param request
   * @param model
   *
   * @return
   */
  @RequestMapping(value = "/processFormVersionTwo")
  public String processFormVersionTwo(HttpServletRequest request, Model model) {
    var name = request.getParameter("studentName");
    name = name.toUpperCase();
    model.addAttribute("message",
                       "Yo! " +
                                  name);
    return "helloworld";
  }

}
