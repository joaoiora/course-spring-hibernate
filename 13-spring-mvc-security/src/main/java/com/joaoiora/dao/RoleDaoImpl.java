package com.joaoiora.dao;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joaoiora.model.RoleEntity;

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

  @SuppressWarnings("resource")
  @Override
  public RoleEntity findRoleByName(String roleName) {
    final var session = sessionFactory.getCurrentSession();
    final var query = session
        .createQuery("FROM RoleEntity WHERE name = :roleName",
                     RoleEntity.class);
    query.setParameter("roleName",
                       roleName);
    try {
      return query.getSingleResult();
    }
    catch (final NoResultException e) {
      return null;
    }
  }

}
