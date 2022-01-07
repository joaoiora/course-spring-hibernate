package com.joaoiora.rest;

import java.util.List;

import javax.management.ServiceNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoiora.model.Student;

/**
 * @author João Iora
 */
@RestController
@RequestMapping(value = "/api")
public class StudentRestController {

  /**
   *
   */
  private final List<Student> students = List.of(new Student("John", "Doe"),
                                                 new Student("Mary", "Poppins"),
                                                 new Student("Susan", "Boyle"),
                                                 new Student("Jack", "Bauer"));

  /**
   * @return
   */
  @GetMapping(value = "/students")
  public List<Student> getStudents() {
    return students;
  }

  /**
   * @param id
   *
   * @return
   *
   * @throws ServiceNotFoundException
   */
  @GetMapping(value = "/students/{id}")
  public Student getStudent(@PathVariable int id)
    throws ServiceNotFoundException {
    if ((id >= students.size()) || (id < 0)) {
      throw new ServiceNotFoundException("Could not find Student with id: " +
                                         id +
                                         ".");
    }
    return students.get(id);
  }

}
