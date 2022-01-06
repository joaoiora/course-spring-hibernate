package com.joaoiora.dao;

import com.joaoiora.model.Role;

/**
 * @author João Iora
 */
public interface RoleDao {

  /**
   * @param roleName
   *
   * @return
   */
  Role findRoleByName(String roleName);

}
