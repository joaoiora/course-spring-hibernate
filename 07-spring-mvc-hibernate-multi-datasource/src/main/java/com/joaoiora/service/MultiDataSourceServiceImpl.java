package com.joaoiora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaoiora.dao.CustomerDAO;
import com.joaoiora.dao.EmployeeDAO;
import com.joaoiora.entity.Customer;
import com.joaoiora.entity.Employee;

/**
 * @author João Iora
 */
@Service
public class MultiDataSourceServiceImpl
  implements MultiDataSourceService {

  /**
   *
   */
  @Autowired
  private CustomerDAO customerDAO;

  /**
   *
   */
  @Autowired
  private EmployeeDAO employeeDAO;

  /**
   *
   */
  @Override
  public List<Customer> getCustomers() {
    return customerDAO.getCustomers();
  }

  /**
   *
   */
  @Override
  public List<Employee> getEmployees() {
    return employeeDAO.getEmployees();
  }

}
