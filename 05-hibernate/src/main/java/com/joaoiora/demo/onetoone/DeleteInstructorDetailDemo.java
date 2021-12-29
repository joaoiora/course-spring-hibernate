package com.joaoiora.demo.onetoone;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;

/**
 * @author João Iora
 */
public class DeleteInstructorDetailDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("01-one-to-one-uni-hibernate.cfg.xml")
        .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var id = 6;
      final var instructorDetail = session.get(InstructorDetail.class,
                                               id);
      System.out.println("instructorDetail: " +
                         instructorDetail);
      System.out.println("the associated instructor: " +
                         instructorDetail.getInstructor());
      System.out.println("Deleting instructorDetail: " +
                         instructorDetail);
      session.delete(instructorDetail);
      session.getTransaction().commit();
      System.out.println("Done!");
    }
    catch (final Exception exc) {
      exc.printStackTrace();
    }
  }

}
