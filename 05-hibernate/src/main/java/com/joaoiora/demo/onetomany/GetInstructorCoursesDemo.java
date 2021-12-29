package com.joaoiora.demo.onetomany;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Course;
import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;

/**
 * @author João Iora
 */
public class GetInstructorCoursesDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hb-mappings-hibernate.cfg.xml")
        .addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
        .buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var instructor = session.get(Instructor.class,
                                         1);
      System.out.println("Instructor: " +
                         instructor);
      System.out.println("Courses: " +
                         instructor.getCourses());
      session.getTransaction().commit();
      System.out.println("Done!");
    }
  }

}
