package com.joaoiora.demo.manytomany;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Course;
import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;
import com.joaoiora.entity.Review;
import com.joaoiora.entity.Student;

/**
 * @author João Iora
 */
public class AddCoursesForMaryDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hb-mappings-hibernate.cfg.xml")
        .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Instructor.class)
        .addAnnotatedClass(Student.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var student = session.get(Student.class,
                                      2);
      System.out.println("\nLoaded student: " +
                         student);
      System.out.println("Courses: " +
                         student.getCourses());
      final var course1 = new Course("Rubik's Cube - How to Speed Cube");
      final var course2 = new Course("Atari 2600 - Game Development");
      course1.addStudent(student);
      course2.addStudent(student);
      System.out.println("\nSaving the courses ...");
      session.save(course1);
      session.save(course2);
      session.getTransaction().commit();
      System.out.println("Done!");
    }
  }

}
