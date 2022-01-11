package com.joaoiora.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoiora.model.Employee;
import com.joaoiora.service.EmployeeService;

/**
 * @author João Iora
 */
@RestController
@RequestMapping(value = "/api")
public class EmployeeRestController {

  /**
   *
   */
  private final EmployeeService service;

  /**
   * @param service
   */
  @Autowired
  public EmployeeRestController(EmployeeService service) {
    this.service = service;
  }

  /**
   * @return
   */
  @GetMapping(value = "/employees")
  public List<Employee> findAll() {
    return service.findAll();
  }

  /**
   * @param id
   *
   * @return
   */
  @GetMapping(value = "/employees/{id}")
  public Employee find(@PathVariable Integer id) {
    final var employee = service.find(id);
    if (employee == null) {
      throw new RuntimeException("Could not find Employee with given id: " +
                                 id +
                                 ".");
    }
    return employee;
  }

  /**
   * @param employee
   *
   * @return
   */
  @PostMapping(value = "/employees")
  public Employee add(@RequestBody Employee employee) {
    service.save(employee);
    return employee;
  }

  /**
   * @param employee
   *
   * @return
   */
  @PutMapping(value = "/employees")
  public Employee update(@RequestBody Employee employee) {
    service.save(employee);
    return employee;
  }

  /**
   * @param id
   *
   * @return
   */
  @DeleteMapping(value = "/employees/{id}")
  public String delete(@PathVariable Integer id) {
    final var employee = service.find(id);
    if (employee == null) {
      throw new RuntimeException("Could not find Employee with given id: " +
                                 id +
                                 ".");
    }
    service.delete(id);
    return "Deleted Employee with id: " +
           id;
  }

}
