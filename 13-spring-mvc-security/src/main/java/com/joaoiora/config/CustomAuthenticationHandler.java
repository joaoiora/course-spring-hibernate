package com.joaoiora.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.joaoiora.service.UserService;

/**
 * @author João Iora
 */
public class CustomAuthenticationHandler
  implements AuthenticationSuccessHandler {

  /**
   *
   */
  @Autowired
  private UserService service;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
                                      HttpServletResponse response,
                                      Authentication authentication)
    throws IOException, ServletException {
    final var userName = authentication.getName();
    final var user = service.findByUserName(userName);
    final var session = request.getSession();
    session.setAttribute("user",
                         user);
    response.sendRedirect(request.getContextPath() +
                          "/");
  }

}
