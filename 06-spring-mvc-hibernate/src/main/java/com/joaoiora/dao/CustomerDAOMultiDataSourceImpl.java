package com.joaoiora.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joaoiora.entity.Customer;

/**
 * @author João Iora
 */
@Repository
public class CustomerDAOMultiDataSourceImpl
  implements CustomerDAO {

  /**
   *
   */
  @Autowired
  @Qualifier(value = "customerSessionFactory")
  private SessionFactory sessionFactory;

  /**
   *
   */
  @Transactional(transactionManager = "customerTransactionManager")
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
    try (var session = sessionFactory.openSession()) {
      session.saveOrUpdate(customer);
    }
  }

  @Override
  public Customer loadCustomer(Integer id) {
    try (var session = sessionFactory.openSession()) {
      return session.get(Customer.class,
                         id);
    }
  }

}
