package com.joaoiora.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joaoiora.model.Employee;

/**
 * @author João Iora
 */
@SuppressWarnings("resource")
@Repository
@Transactional
public class EmployeeHibernateDAOImpl
  implements EmployeeDAO {

  /**
   *
   */
  private final EntityManager em;

  /**
   * @param em
   */
  @Autowired
  public EmployeeHibernateDAOImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<Employee> findAll() {
    final var session = em.unwrap(Session.class);
    final var query = session.createQuery("from Employee",
                                          Employee.class);
    return query.getResultList();
  }

  @Override
  public Employee find(Integer id) {
    final var session = em.unwrap(Session.class);
    return session.get(Employee.class,
                       id);
  }

  @Override
  public void save(Employee theEmployee) {
    final var currentSession = em.unwrap(Session.class);
    currentSession.saveOrUpdate(theEmployee);
  }

  @Override
  public void delete(Integer id) {
    final var session = em.unwrap(Session.class);
    final var query = session.createQuery("DELETE FROM Employee WHERE id = :id")
        .setParameter("id",
                      id);
    query.executeUpdate();
  }

}
