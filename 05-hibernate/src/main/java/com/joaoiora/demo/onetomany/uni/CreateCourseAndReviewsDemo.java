package com.joaoiora.demo.onetomany.uni;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Course;
import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;
import com.joaoiora.entity.Review;

/**
 * @author João Iora
 */
public class CreateCourseAndReviewsDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hb-mappings-hibernate.cfg.xml")
        .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Instructor.class)
        .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var course = new Course("Pacman 5 - How To Score One Million Points");
      course.addReview(new Review("Great course ... loved it!"));
      course.addReview(new Review("Cool course, job well done"));
      course.addReview(new Review("What a dumb course, you are an idiot!"));
      System.out.println("Saving the course");
      System.out.println(course);
      System.out.println(course.getReviews());
      session.save(course);
      session.getTransaction().commit();
      System.out.println("Done!");
    }
  }

}
