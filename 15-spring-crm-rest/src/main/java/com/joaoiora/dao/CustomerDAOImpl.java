package com.joaoiora.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joaoiora.model.Customer;

/**
 * @author João Iora
 */
@SuppressWarnings("resource")
@Repository
public class CustomerDAOImpl
  implements CustomerDAO {

  /**
   *
   */
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Customer> getCustomers() {
    final var session = sessionFactory.getCurrentSession();
    final var query = session.createQuery("FROM Customer ORDER BY lastName",
                                          Customer.class);
    return query.getResultList();
  }

  @Override
  public void saveCustomer(Customer customer) {
    final var session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(customer);
  }

  @Override
  public Customer getCustomer(int id) {
    final var session = sessionFactory.getCurrentSession();
    return session.get(Customer.class,
                       id);
  }

  @Override
  public void deleteCustomer(int id) {
    final var session = sessionFactory.getCurrentSession();
    final var query = session
        .createQuery("DELETE FROM Customer WHERE id = :id");
    query.setParameter("id",
                       id);
    query.executeUpdate();
  }

}
