package com.joaoiora.dao;

import java.util.List;

import com.joaoiora.entity.Employee;

/**
 * @author João Iora
 */
public interface EmployeeDAO {

  /**
   * @return
   */
  List<Employee> getEmployees();

}
