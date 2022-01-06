package com.joaoiora.dao;

import com.joaoiora.model.User;

/**
 * @author João Iora
 */
public interface UserDao {

  /**
   * @param userName
   *
   * @return
   */
  User findByUserName(String userName);

  /**
   * @param user
   */
  void save(User user);

}
