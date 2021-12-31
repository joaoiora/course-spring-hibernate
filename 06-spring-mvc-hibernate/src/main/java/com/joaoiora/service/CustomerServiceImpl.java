package com.joaoiora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoiora.dao.CustomerDAO;
import com.joaoiora.entity.Customer;

/**
 * @author João Iora
 */
@Service
public class CustomerServiceImpl
  implements CustomerService {

  /**
   *
   */
  @Autowired
  @Qualifier(value = "customerDAOImpl")
  private CustomerDAO dao;

  @Transactional(transactionManager = "customerTransactionManager")
  @Override
  public List<Customer> getCustomers() {
    return dao.getCustomers();
  }

  @Transactional(transactionManager = "customerTransactionManager")
  @Override
  public void saveCustomer(Customer customer) {
    dao.saveCustomer(customer);
  }

  @Transactional(transactionManager = "customerTransactionManager")
  @Override
  public Customer loadCustomer(Integer id) {
    return dao.loadCustomer(id);
  }

}
