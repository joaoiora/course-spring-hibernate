package com.joaoiora.dao;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joaoiora.model.UserEntity;

/**
 * @author João Iora
 */
@Repository
public class UserDaoImpl
  implements UserDao {

  /**
   *
   */
  @Autowired
  private SessionFactory sessionFactory;

  @SuppressWarnings("resource")
  @Override
  public UserEntity findByUserName(String theUserName) {
    final var session = sessionFactory.getCurrentSession();
    final var query = session
        .createQuery("FROM UserEntity WHERE userName = :userName",
                     UserEntity.class);
    query.setParameter("userName",
                       theUserName);
    try {
      return query.getSingleResult();
    }
    catch (final NoResultException e) {
      return null;
    }
  }

  @Override
  public void save(UserEntity user) {
    @SuppressWarnings("resource")
    final var currentSession = sessionFactory.getCurrentSession();
    currentSession.saveOrUpdate(user);
  }

}
