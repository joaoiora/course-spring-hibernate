package com.joaoiora.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author João Iora
 */
@Entity
@Table(name = "course")
public class Course {

  /**
   *
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  /**
   *
   */
  @Column(name = "title")
  private String title;

  /**
   *
   */
  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
  @JoinColumn(name = "instructor_id")
  private Instructor instructor;

  /**
   *
   */
  public Course() {
    super();
  }

  /**
   * @param title
   */
  public Course(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "Course [id=" +
           id +
           ", title=" +
           title +
           "]";
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the instructor
   */
  public Instructor getInstructor() {
    return instructor;
  }

  /**
   * @param instructor the instructor to set
   */
  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

}
