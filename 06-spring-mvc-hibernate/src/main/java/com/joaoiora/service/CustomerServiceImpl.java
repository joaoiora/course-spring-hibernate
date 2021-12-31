package com.joaoiora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
  private CustomerDAO dao;

  @Transactional
  @Override
  public List<Customer> getCustomers() {
    return dao.getCustomers();
  }

  @Transactional
  @Override
  public void saveCustomer(Customer customer) {
    dao.saveCustomer(customer);
  }

  @Transactional
  @Override
  public Customer loadCustomer(Integer id) {
    return dao.loadCustomer(id);
  }

}
