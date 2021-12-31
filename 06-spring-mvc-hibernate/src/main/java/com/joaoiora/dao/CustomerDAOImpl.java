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
@SuppressWarnings("resource")
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
      final var query = session.createQuery("FROM Customer ORDER BY lastName",
                                            Customer.class);
      return query.getResultList();
    }
  }

  @Override
  public void saveCustomer(Customer customer) {
    final var currentSession = sessionFactory.getCurrentSession();
    currentSession.saveOrUpdate(customer);
  }

  @Override
  public Customer loadCustomer(Integer id) {
    final var session = sessionFactory.getCurrentSession();
    return session.get(Customer.class,
                       id);
  }

}
