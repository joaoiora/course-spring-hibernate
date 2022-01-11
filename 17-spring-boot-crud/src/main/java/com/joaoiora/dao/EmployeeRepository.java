package com.joaoiora.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoiora.model.Employee;

/**
 * @author João Iora
 */
public interface EmployeeRepository
  extends JpaRepository<Employee, Integer> {

}
