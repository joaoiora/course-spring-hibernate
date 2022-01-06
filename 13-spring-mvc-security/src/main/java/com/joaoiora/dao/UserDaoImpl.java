package com.joaoiora.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joaoiora.model.User;

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

  @Override
  public User findByUserName(String theUserName) {
    try (var session = sessionFactory.openSession()) {
      final var query = session
          .createQuery("from User where userName = :userName",
                       User.class);
      query.setParameter("userName",
                         theUserName);
      return query.getSingleResult();
    }
  }

  @Override
  public void save(User user) {
    @SuppressWarnings("resource")
    final var currentSession = sessionFactory.getCurrentSession();
    currentSession.saveOrUpdate(user);
  }

}
