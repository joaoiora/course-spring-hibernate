package com.joaoiora.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joaoiora.model.Employee;

/**
 * @author João Iora
 */
@Repository
@Transactional
public class EmployeeJpaDAOImpl
  implements EmployeeDAO {

  /**
   *
   */
  private final EntityManager em;

  /**
   * @param em
   */
  @Autowired
  public EmployeeJpaDAOImpl(EntityManager em) {
    super();
    this.em = em;
  }

  @Override
  public List<Employee> findAll() {
    return em.createQuery("FROM Employee",
                          Employee.class)
        .getResultList();
  }

  @Override
  public Employee find(Integer id) {
    return em.find(Employee.class,
                   id);
  }

  @Override
  public void save(Employee employee) {
    if (employee.getId() == null) {
      em.persist(employee);
    }
    else {
      em.merge(employee);
    }
  }

  @Override
  public void delete(Integer id) {
    final var customer = find(id);
    if (customer != null) {
      em.remove(customer);
    }
  }

}
