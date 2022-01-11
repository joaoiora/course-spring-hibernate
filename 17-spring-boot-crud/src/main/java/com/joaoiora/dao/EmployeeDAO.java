package com.joaoiora.dao;

import java.util.List;

import com.joaoiora.model.Employee;

/**
 * @author João Iora
 */
public interface EmployeeDAO {

  /**
   * @return
   */
  List<Employee> findAll();

  /**
   * @param id
   *
   * @return
   */
  Employee find(Integer id);

  /**
   * @param employee
   */
  void save(Employee employee);

  /**
   * @param id
   */
  void delete(Integer id);

}
