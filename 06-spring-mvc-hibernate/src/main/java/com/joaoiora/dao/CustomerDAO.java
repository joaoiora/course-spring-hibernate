package com.joaoiora.dao;

import java.util.List;

import com.joaoiora.entity.Customer;

/**
 * @author João Iora
 */
public interface CustomerDAO {

  /**
   * @return
   */
  List<Customer> getCustomers();

}
