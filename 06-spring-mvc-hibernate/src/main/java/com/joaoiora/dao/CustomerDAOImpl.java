package com.joaoiora.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joaoiora.entity.Customer;

/**
 * @author João Iora
 */
@Repository
public class CustomerDAOImpl
  implements CustomerDAO {

  /**
   *
   */
  @Autowired
  private SessionFactory sessionFactory;

  /**
   *
   */
  @Override
  public List<Customer> getCustomers() {
    try (var session = sessionFactory.openSession()) {
      final var query = session.createQuery("FROM Customer",
                                            Customer.class);
      return query.getResultList();
    }
  }

}
