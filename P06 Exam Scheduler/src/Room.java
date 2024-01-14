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
public class Room {
  private String location;
  private int capacity;

  /**
   * Initialize a Room object with its location and capacity. Throws IllegalArgumentException if the
   * capacity of room passed in is negative.
   * 
   * @param location location of the room.
   * @param capacity capacity of the room.
   */
  public Room(String location, int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity cannot be negative.");
    }
    this.location = location;
    this.capacity = capacity;
  }

  /**
   * Get the location of a specific room.
   * 
   * @return location of the room.
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * Get the capacity of a specific room.
   * 
   * @return capacity of the room.
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Reduce the capacity of a room according to the number of students being added into it. Throws
   * IllegalArgumentException if the number needs to be reduce exceeds room's capacity.
   * 
   * @param numReduced the number that has to be extracted from the current capacity.
   * @return new capacity of the room.
   */
  public Room reduceCapacity(int numReduced) {
    if (numReduced > this.capacity) {
      throw new IllegalArgumentException("numReduced Cannot be larger than capacity.");
    }

    return new Room(this.location, this.capacity - numReduced);
  }
}
