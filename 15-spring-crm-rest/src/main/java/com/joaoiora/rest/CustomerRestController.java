package com.joaoiora.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoiora.exception.CustomerNotFoundException;
import com.joaoiora.model.Customer;
import com.joaoiora.service.CustomerService;

/**
 * @author João Iora
 */
@RestController
@RequestMapping(value = "/api")
public class CustomerRestController {

  /**
   *
   */
  @Autowired
  @Qualifier(value = "customerServiceImpl")
  private CustomerService service;

  /**
   * @return
   */
  @GetMapping(value = "/customers")
  public List<Customer> getCustomers() {
    return service.getCustomers();
  }

  /**
   * @param id
   *
   * @return
   */
  @GetMapping(value = "/customers/{id}")
  public Customer getCustomer(@PathVariable int id) {
    final var customer = service.getCustomer(id);
    if (customer == null) {
      throw new CustomerNotFoundException("Customer with id " +
                                          id +
                                          " could not be found.");
    }
    return customer;
  }

  /**
   * @param customer
   *
   * @return
   */
  @PostMapping(value = "/customers")
  public Customer addCustomer(@RequestBody Customer customer) {
    service.saveCustomer(customer);
    return customer;
  }

  /**
   * @param customer
   *
   * @return
   */
  @PutMapping(value = "/customers")
  public Customer updateCustomer(@RequestBody Customer customer) {
    service.saveCustomer(customer);
    return customer;
  }

  /**
   * @param id
   */
  @DeleteMapping(value = "/customers/{id}")
  public void deleteCustomer(@PathVariable int id) {
    final var customer = service.getCustomer(id);
    if (customer == null) {
      throw new CustomerNotFoundException("Customer with id " +
                                          id +
                                          " could not be found.");
    }
    service.deleteCustomer(id);
  }

}
