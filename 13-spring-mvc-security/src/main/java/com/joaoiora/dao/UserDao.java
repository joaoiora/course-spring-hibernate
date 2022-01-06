package com.joaoiora.dao;

import com.joaoiora.model.UserEntity;

/**
 * @author João Iora
 */
public interface UserDao {

  /**
   * @param userName
   *
   * @return
   */
  UserEntity findByUserName(String userName);

  /**
   * @param user
   */
  void save(UserEntity user);

}
