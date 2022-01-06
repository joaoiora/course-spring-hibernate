package com.joaoiora.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joaoiora.model.Role;

/**
 * @author João Iora
 */
@Repository
public class RoleDaoImpl
  implements RoleDao {

  /**
   *
   */
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Role findRoleByName(String roleName) {
    try (var session = sessionFactory.openSession()) {
      final var query = session.createQuery("FROM Role WHERE name = :roleName",
                                            Role.class);
      query.setParameter("roleName",
                         roleName);
      return query.getSingleResult();
    }
  }

}
