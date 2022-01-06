package com.joaoiora.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author João Iora
 */
@RestController
@RequestMapping(value = "/test")
public class TestRestController {

  /**
   * @return
   */
  @GetMapping(value = "/hello")
  public String hello() {
    return "Hello World!";
  }

}
