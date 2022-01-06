package com.joaoiora.dao;

import com.joaoiora.model.RoleEntity;

/**
 * @author João Iora
 */
public interface RoleDao {

  /**
   * @param roleName
   *
   * @return
   */
  RoleEntity findRoleByName(String roleName);

}
