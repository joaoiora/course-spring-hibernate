package com.joaoiora.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.joaoiora.model.Employee;

/**
 * @author João Iora
 */
@RepositoryRestResource(path = "members")
public interface EmployeeRepository
  extends JpaRepository<Employee, Integer> {

}
