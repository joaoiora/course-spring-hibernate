package com.joaoiora.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.joaoiora.model.CrmUser;
import com.joaoiora.model.User;

/**
 * @author João Iora
 */
public interface UserService
  extends UserDetailsService {

  /**
   * @param userName
   *
   * @return
   */
  User findByUserName(String userName);

  /**
   * @param crmUser
   */
  void save(CrmUser crmUser);

  /**
   * @param userName
   *
   * @return
   */
  boolean userExists(String userName);

}
