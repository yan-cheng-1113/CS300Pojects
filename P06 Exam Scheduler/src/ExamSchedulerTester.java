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
import java.util.ArrayList;

/**
 * This class contains a few methods aims to test methods written for this project.
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (Kenneth ZHANG,Yancheng Zhu )
 */
public class ExamSchedulerTester {
  /**
   * Test if all methods work as expected
   * 
   * @return true if all method function properly, false other wise.
   */
  private static boolean runAllTest() {
    return testCourse() && testRoom() && testScheduleAccessors() && testAssignCourse()
        && testFindAllSchedules() && testFindSchedule();
  }

  /**
   * This method aims at testing the constructor and methods in the Course class.
   * 
   * @return true if constructor and methods in the Course class function properly and false
   *         otherwise.
   */
  public static boolean testCourse() {
    try {
      Course testClass = new Course("CS301", -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }

    Course testCourse = new Course("CS302", 10);
    if (!testCourse.getName().equals("CS302")) {
      return false;
    }
    if (testCourse.getNumStudents() != 10) {
      return false;
    }
    return true;
  }

  /**
   * This method aims at testing the constructor and methods in the Room class.
   * 
   * @return true if constructor and methods in the Room class function properly and false
   *         otherwise.
   */
  public static boolean testRoom() {
    try {
      Room test = new Room("2241", -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }

    Room testR = new Room("2242", 50);
    if (!testR.getLocation().equals("2242")) {
      return false;
    }

    if (testR.getCapacity() != 50) {
      return false;
    }

    try {
      testR.reduceCapacity(60);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }

    Room testRo = testR.reduceCapacity(10);
    if (!testRo.getLocation().equals("2242")) {
      return false;
    }

    if (testRo.getCapacity() != 40) {
      return false;
    }
    return true;
  }

  /**
   * This method aims at testing all the accessors in the Schedule class.
   * 
   * @return true if all the accessors in the Schedule class function properly and false otherwise.
   * 
   */
  public static boolean testScheduleAccessors() {
    Room[] testRooms = new Room[3];
    Course[] testCourses = new Course[3];
    testRooms[0] = new Room("001", 75);
    testRooms[1] = new Room("002", 100);
    testRooms[2] = new Room("003", 15);
    testCourses[0] = new Course("01", 15);
    testCourses[1] = new Course("02", 90);
    testCourses[2] = new Course("03", 70);

    Schedule sch1 = new Schedule(testRooms, testCourses);
    // test getNumRooms
    if (sch1.getNumRooms() != testRooms.length) {
      return false;
    }
    // test getRoom
    try {
      sch1.getRoom(-1);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }
    // test getRoom
    try {
      sch1.getRoom(100);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }
    // test getRoom
    if (!(sch1.getRoom(0).getLocation().equals(testRooms[0].getLocation()))
        || sch1.getRoom(0).getCapacity() != testRooms[0].getCapacity()) {
      return false;
    }
    // test getCourse
    try {
      sch1.getCourse(-1);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }
    // test getCourse
    try {
      sch1.getCourse(100);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }

    if (!(sch1.getCourse(0).getName().equals(testCourses[0].getName()))
        || sch1.getCourse(0).getNumStudents() != testCourses[0].getNumStudents()) { // test
                                                                                    // getCourse
      return false;
    }
    // test getNumCourses
    if (sch1.getNumCourses() != 3) {
      return false;
    }
    // test isAssigned
    try {
      sch1.isAssigned(100);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }
    // test isAssigned
    try {
      sch1.isAssigned(-1);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }
    // test getAssignment
    try {
      sch1.getAssignment(100);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }
    // test getAssignment
    if (!((sch1.assignCourse(1, 1).getAssignment(1).getLocation()
        .equals(testRooms[1].getLocation())))
        || sch1.assignCourse(1, 1).getAssignment(1).getCapacity() != testRooms[1].getCapacity()
            - testCourses[1].getNumStudents()) {

      return false;
    }
    return true;
  }

  /**
   * This method aims at testing the assignCourse method in the Schedule class.
   * 
   * @return true if assignCourse function properly and false otherwise.
   * 
   */
  public static boolean testAssignCourse() {
    Room[] testRooms = new Room[3];
    Course[] testCourses = new Course[3];
    testRooms[0] = new Room("001", 75);
    testRooms[1] = new Room("002", 100);
    testRooms[2] = new Room("003", 15);
    testCourses[0] = new Course("01", 15);
    testCourses[1] = new Course("02", 90);
    testCourses[2] = new Course("03", 70);

    Schedule sch1 = new Schedule(testRooms, testCourses);

    try {// test assignCourse
      sch1.assignCourse(100, 100);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }

    try {// test assignCourse
      sch1.assignCourse(-1, -1);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }

    try {
      sch1.assignCourse(0, 0);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }

    try {
      sch1.assignCourse(1, 0);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }

    if (!((sch1.assignCourse(0, 0).getAssignment(0).getLocation()
        .equals(testRooms[0].getLocation())))
        || sch1.assignCourse(0, 0).getAssignment(0).getCapacity() != testRooms[0].getCapacity()
            - testCourses[0].getNumStudents()) {
      return false;
    }



    return true;
  }

  /**
   * Test if findAllSchedules method functions as expected.
   * 
   * @return true if method works as expected, false otherwise.
   */
  public static boolean testFindAllSchedules() {
    Room[] testRooms = new Room[3];
    Course[] testCourses = new Course[3];
    testRooms[0] = new Room("001", 75);
    testRooms[1] = new Room("002", 100);
    testRooms[2] = new Room("003", 115);
    testCourses[0] = new Course("01", 15);
    testCourses[1] = new Course("02", 90);
    testCourses[2] = new Course("03", 70);
    ArrayList<Schedule> testSchs = ExamScheduler.findAllSchedules(testRooms, testCourses);
    for (int i = 0; i < testSchs.size(); i++) {
      String schs = testSchs.get(i).toString();
      if (schs.equals("{01: 001, 02: 002, 03: 003}")) {
        continue;
      } else if (schs.equals("{01: 001, 02: 003, 03: 002}")) {
        continue;
      } else if (schs.equals("{01: 002, 02: 003, 03: 001}")) {
        continue;
      } else if (schs.equals("{01: 002, 02: 003, 03: 002}")) {
        continue;
      } else if (schs.equals("{01: 003, 02: 002, 03: 001}")) {
        continue;
      } else if (schs.equals("{01: 003, 02: 002, 03: 003}")) {
        continue;
      } else if (schs.equals("{01: 003, 02: 003, 03: 001}")) {
        continue;
      } else if (schs.equals("{01: 003, 02: 003, 03: 002}")) {
        continue;
      } else {
        return false;
      }
    }

    return true;
  }

  /**
   * Test if findSchedule method functions as expected.
   * 
   * @return true if method works as expected, false otherwise.
   */
  public static boolean testFindSchedule() {
    Room[] testRooms = new Room[3];
    Course[] testCourses = new Course[3];
    testRooms[0] = new Room("001", 75);
    testRooms[1] = new Room("002", 100);
    testRooms[2] = new Room("003", 15);
    testCourses[0] = new Course("01", 15);
    testCourses[1] = new Course("02", 90);
    testCourses[2] = new Course("03", 70);
    Schedule testSch = new Schedule(testRooms, testCourses);
    testSch = ExamScheduler.findSchedule(testRooms, testCourses);
    String expected = "{01: 003, 02: 002, 03: 001}";

    if (!testSch.isComplete()) {
      return false;
    }

    if (!expected.equals(testSch.toString())) {
      return false;
    }

    testRooms[0] = new Room("001", 5);
    testRooms[1] = new Room("002", 10);
    testRooms[2] = new Room("003", 15);
    testCourses[0] = new Course("01", 15);
    testCourses[1] = new Course("02", 90);
    testCourses[2] = new Course("03", 70);
    try {
      Schedule tSche = ExamScheduler.findSchedule(testRooms, testCourses);
      return false;
    } catch (IllegalStateException e) {
    } catch (Exception e) {
      return false;
    }
    return true;
  }



  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(runAllTest());

  }

}
