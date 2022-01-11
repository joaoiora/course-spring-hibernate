package com.joaoiora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoiora.dao.EmployeeRepository;
import com.joaoiora.model.Employee;

/**
 * @author João Iora
 */
@Transactional
@Service
public class EmployeeServiceImpl
  implements EmployeeService {

  /**
   *
   */
  // private final EmployeeDAO dao;

  private final EmployeeRepository repository;

  /**
   * @param repository
   */
  @Autowired
  // public EmployeeServiceImpl(@Qualifier(value = "employeeJpaDAOImpl") EmployeeDAO dao) {
  public EmployeeServiceImpl(EmployeeRepository repository) {
    super();
    // this.dao = dao;
    this.repository = repository;
  }

  @Override
  public List<Employee> findAll() {
    return repository.findAll();
  }

  @Override
  public Employee find(Integer id) {
    return repository.findById(id).orElseGet(null);
  }

  @Override
  public void save(Employee employee) {
    repository.save(employee);
  }

  @Override
  public void delete(Integer id) {
    repository.deleteById(id);
  }

}
