package com.joaoiora.service;

import java.util.List;

import com.joaoiora.entity.Customer;
import com.joaoiora.entity.Employee;

/**
 * @author João Iora
 */
public interface MultiDataSourceService {

  /**
   * @return
   */
  List<Customer> getCustomers();

  /**
   * @return
   */
  List<Employee> getEmployees();

}
