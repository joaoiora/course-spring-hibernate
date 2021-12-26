package com.joaoiora;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author João Iora
 */
@Controller
@RequestMapping(value = "/hello")
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

  /**
   * @param studentName
   * @param model
   *
   * @return
   */
  @RequestMapping(value = "/processFormVersionThree")
  public String processFormVersionThree(@RequestParam(value = "studentName") String studentName, Model model) {
    model.addAttribute("message",
                       "Hey my friend from v3! " +
                                  studentName.toUpperCase());
    return "helloworld";
  }

}
