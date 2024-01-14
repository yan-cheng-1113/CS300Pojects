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
import java.util.Arrays;

/**
 * This class contains a few methods related to the Schedule Object.
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (YANCHENG ZHU, KENNETH ZHANG)
 */
public class Schedule {
  private Room[] rooms;
  private Course[] courses;
  private int[] assignments;

  /**
   * Initializes a schedule object with given rooms and courses.
   * 
   * @param rooms
   * @param courses
   */
  public Schedule(Room[] rooms, Course[] courses) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = new int[courses.length];
    for (int i = 0; i < assignments.length; i++) {
      assignments[i] = -1;
    }
  }

  /**
   * Initializes a schedule object with given rooms, courses, and assignments.
   * 
   * @param rooms
   * @param courses
   * @param assignments
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignments;
  }

  /**
   * Get the number of rooms contained by the specific schedule.
   * 
   * @return number of rooms contained by the specific schedule.
   */
  public int getNumRooms() {
    return this.rooms.length;
  }

  /**
   * Get the room object stored at a specific position in the rooms array. Throws
   * IndexOutOfBoundsException if the given index is smaller than 0 or larger than rooms.length.
   * 
   * @param index index of the target room in the array of rooms.
   * @return a room object at the specific index.
   */
  public Room getRoom(int index) {
    if (index < 0 || index >= rooms.length) {
      throw new IndexOutOfBoundsException("Invalide index.");
    }
    return this.rooms[index];
  }

  /**
   * Get the number of courses contained by the specific schedule.
   * 
   * @return number of courses contained by the specific schedule.
   */
  public int getNumCourses() {
    return this.courses.length;
  }

  /**
   * Get the course object stored at a specific position in the courses array. Throws
   * IndexOutOfBoundsException if the given index is smaller than 0 or larger than courses.length.
   * 
   * @param index index of the target course in the array of courses.
   * @return a course object at the specific index.
   */
  public Course getCourse(int index) {
    if (index < 0 || index >= courses.length) {
      throw new IndexOutOfBoundsException("Invalide index.");
    }
    return this.courses[index];
  }

  /**
   * Check if the course at a given index has been assigned to the course by checking if same index
   * in the assignments array stores 0. Throws IndexOutOfBoundsException if the given index is
   * smaller than 0 or larger than assignments.length.
   * 
   * @param index index of the specific course in the array.
   * @return true if the course has been assigned to a course, false otherwise.
   */
  public boolean isAssigned(int index) {
    if (index < 0 || index >= assignments.length) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    if (assignments[index] != -1) {
      return true;
    }
    return false;
  }

  /**
   * Get the room object assigned to a course. Throws IndexOutOfBoundsException if the given index
   * is smaller than 0 or larger than assignments.length.
   * 
   * @param index
   * @return
   */
  public Room getAssignment(int index) {
    if (!this.isAssigned(index)) {
      throw new IllegalArgumentException();
    }
    if (index < 0 || index >= assignments.length) {
      throw new IndexOutOfBoundsException("Invalid index");
    }

    if (assignments[index] < 0 || assignments[index] >= rooms.length) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    return rooms[assignments[index]];
  }

  /**
   * Check if every course have been assigned to a room
   * 
   * @return true if all courses have been assigned to rooms, false otherwise.
   */
  public boolean isComplete() {
    for (int i = 0; i < assignments.length; i++) {
      if (assignments[i] == -1) {
        return false;
      }
    }
    return true;
  }

  /**
   * Assign a course to a room at given indices. Throws IndexOutOfBoundsException if the given
   * indices is smaller than 0 or larger than rooms.length or courses.length. Throws
   * IllegalArgumentException if the course has been assigned or the room doesn't have enough
   * capacity.
   * 
   * @param courseIndex index of a specific course in the courses array.
   * @param roomIndex   index of a specific room in the rooms array.
   * @return a schedule object contained indices of assigned rooms.
   */
  public Schedule assignCourse(int courseIndex, int roomIndex) {
    if (courseIndex < 0 || courseIndex >= courses.length) {
      throw new IndexOutOfBoundsException("invalid course index");
    }

    if (roomIndex < 0 || roomIndex >= rooms.length) {
      throw new IndexOutOfBoundsException("invalid room index");
    }

    if (this.isAssigned(courseIndex)) {
      throw new IllegalArgumentException("course has been assigned");
    }

    if (courses[courseIndex].getNumStudents() > rooms[roomIndex].getCapacity()) {
      throw new IllegalArgumentException("exceeds room capactiy");
    }
    // int[] newAssignments = Arrays.copyOf(assignments, assignments.length);
    int[] newAssignments = new int[assignments.length];
    for (int i = 0; i < assignments.length; i++) {
      newAssignments[i] = assignments[i];
    }
    newAssignments[courseIndex] = roomIndex;


    // Room[] newRooms = Arrays.copyOf(rooms, rooms.length);
    Room[] newRooms = new Room[rooms.length];
    for (int i = 0; i < rooms.length; i++) {
      newRooms[i] = rooms[i];
    }

    newRooms[roomIndex] = newRooms[roomIndex].reduceCapacity(courses[courseIndex].getNumStudents());
    return new Schedule(newRooms, this.courses, newAssignments);



  }

  /**
   * Create a string representation of the assignments array.
   * 
   * @return a string representation of the assignments array.
   */
  @Override
  public String toString() {
    String schedule = "{";
    for (int i = 0; i < assignments.length; i++) {
      if (i == 0) {
        if (assignments[i] != -1) {
          schedule += courses[i].getName() + ": " + rooms[assignments[i]].getLocation();
        } else {
          schedule += courses[i].getName() + ": Unassigned";
        }
      } else {
        if (assignments[i] != -1) {
          schedule += ", " + courses[i].getName() + ": " + rooms[assignments[i]].getLocation();
        } else {
          schedule += ", " + courses[i].getName() + ": Unassigned";
        }
      }
    }
    schedule += "}";
    return schedule;
  }



}
