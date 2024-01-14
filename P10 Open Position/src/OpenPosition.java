//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Open Position
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
 * A application handler of an open position using priority queue. Only saves a new Application when
 * the queue is not full, or when it can replace older, lower-scored ones with its higher scores.
 */
public class OpenPosition {
  private String positionName;
  private ApplicationQueue applications; // the priority queue of all applications
  private int capacity; // the number of vacancies

  /**
   * Creates a new open position with the given capacity
   * 
   * @param capacity the number of vacancies of this position
   * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
   *                                  positive integer
   */
  public OpenPosition(String positionName, int capacity) {
    // TODO verify the value of capacity
    if (capacity <= 0) {
      throw new IllegalArgumentException("Invalid capactiy");
    }

    // TODO initialize the data fields appropriately
    this.positionName = positionName;
    this.capacity = capacity;
    applications = new ApplicationQueue(capacity);
  }

  public String getPositionName() {
    return this.positionName;
  }

  /**
   * Tries to add the given Application to the priority queue of this position. return False when
   * the new Application has a lower score than the lowest-scored Application in the queue.
   * 
   * @return Whether the given Application was added successfully
   */
  public boolean add(Application application) {
    if (applications.isEmpty()) {
      applications.enqueue(application);
      return true;
    }
    if (applications.size() >= this.capacity) {
      if (application.compareTo(applications.peek()) < 0) {
        return false;
      } else {
        ApplicationQueue temp = new ApplicationQueue(applications.size() + 1);
        ApplicationQueue copy = applications.deepCopy();
        while (copy.size() > 0) {
          temp.enqueue(copy.dequeue());
        }
        temp.enqueue(application);
        applications = temp;
        this.capacity++;
        return true;
      }
    } else {
      applications.enqueue(application);
      return true;
    }
  }

  /**
   * Returns the list of Applications in the priority queue.
   * 
   * @return The list of Applications in the priority queue, in increasing order of the scores.
   */
  public String getApplications() {
    return applications.toString();
  }

  /**
   * Returns the total score of Applications in the priority queue.
   * 
   * @return The total score of Applications in the priority queue.
   */
  public int getTotalScore() {
    ApplicationQueue copy = applications.deepCopy();
    int score = 0;
    while (copy.size() > 0) {
      score += copy.dequeue().getScore();
    }
    return score;
  }


}
