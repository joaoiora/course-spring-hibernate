package com.joaoiora.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joaoiora.entity.Employee;

/**
 * @author João Iora
 */
@Repository
public class EmployeeDAOImpl
  implements EmployeeDAO {

  /**
  *
  */
  @Autowired
  @Qualifier(value = "employeeSessionFactory")
  private SessionFactory sessionFactory;

  /**
  *
  */
  @Transactional(transactionManager = "employeeTransactionManager")
  @Override
  public List<Employee> getEmployees() {
    try (var session = sessionFactory.openSession()) {
      final var query = session.createQuery("FROM Employee ORDER BY lastName",
                                            Employee.class);
      return query.getResultList();
    }
  }

}
