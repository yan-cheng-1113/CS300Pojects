//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Exam Scheduler
// Course: CS 300 Spring 2022
//
// Author: Yancheng Zhu
// Email: zhu436@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Pair: Kenneth Zhang
// Email: jzhang2428@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// None
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class contains a few methods related to the Course Object.
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (YANCHENG ZHU, KENNETH ZHANG)
 */
public class Course {
  private String name;
  private int numStudents;

  /**
   * Initializes a Course object with given name and number of students. Throws
   * IllegalArgumentException if the number of students passed in is negative.
   * 
   * @param name        name of the Course
   * @param numStudents number of students taking this Course.
   */
  public Course(String name, int numStudents) {
    if (numStudents < 0) {
      throw new IllegalArgumentException("Number of students cannot be negative.");
    }
    this.name = name;
    this.numStudents = numStudents;
  }

  /**
   * Get the name of a specific course.
   * 
   * @return name of the Course.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the number of students taking this course.
   * 
   * @return number of students taking this course.
   */
  public int getNumStudents() {
    return this.numStudents;
  }

}
