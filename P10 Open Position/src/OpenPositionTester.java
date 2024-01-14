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
import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of Application,
 * ApplicationIterator, ApplicationQueue and OpenPosition classes in the assignment.
 *
 */
public class OpenPositionTester {

  /**
   * This method tests and makes use of the Application constructor, getter methods, toString() and
   * compareTo() methods.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testApplication() {
    // create an Application with valid input
    Application testA = new Application("Joe", "Joe@gmail.com", 20);
    Application testB = new Application("Joy", "Joy@gmail.com", 30);
    // create an Application with invalid input:
    // blank name
    try {
      Application testC = new Application("", "A@gmail.com", 50);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    // null email
    try {
      Application testC = new Application("A", "", 50);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    // no @ email
    try {
      Application testC = new Application("A", "Acom", 50);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    // too many @ email
    try {
      Application testC = new Application("A", "A@@", 50);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    // invalid score
    try {
      Application testC = new Application("A", "A@.com", -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      Application testC = new Application("A", "A@.com", 0);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    try {
      Application testC = new Application("A", "A@.com", 101);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      Application testC = new Application("A", "A@.com", 100);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    // verify getters
    if (!testA.getName().equals("Joe")) {
      return false;
    }
    if (!testA.getEmail().equals("Joe@gmail.com")) {
      return false;
    }
    if (testA.getScore() != 20) {
      return false;
    }
    // verify compareTo
    if (testA.compareTo(testB) >= 0) {
      return false;
    }
    try {
      int temp = testA.compareTo(null);
      return false;
    } catch (NullPointerException e) {

    } catch (Exception e) {
      return false;
    }
    // verify toString
    if (!testA.toString().equals("Joe:Joe@gmail.com:20")) {
      return false;
    }

    return true;
  }

  /**
   * This method tests and makes use of the ApplicationIterator class.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testApplicationIterator() {
    // create an ApplicationQueue with capacity at least 3
    // and at least 3 Applications with different scores
    ApplicationQueue testQueue = new ApplicationQueue(3);
    // and at least 4 Applications with different scores
    Application first = new Application("A", "A@wisc.edu", 1);
    Application second = new Application("B", "B@wisc.edu", 2);
    Application third = new Application("C", "C@wisc.edu", 3);

    // add those Applications to the queue
    testQueue.enqueue(third);
    testQueue.enqueue(second);
    testQueue.enqueue(first);
    // verify that iterating through the queue gives you the applications in order of
    // INCREASING score
    if (!(testQueue.toString().trim()
        .equals("A:A@wisc.edu:1" + "\n" + "B:B@wisc.edu:2" + "\n" + "C:C@wisc.edu:3"))) {
      return false;
    }

    return true;
  }

  /**
   * This method tests and makes use of the enqueue() and dequeue() methods in the ApplicationQueue
   * class.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testEnqueueDequeue() {
    // create an ApplicationQueue with capacity 3
    ApplicationQueue testQueue = new ApplicationQueue(3);
    // and at least 4 Applications with different scores
    Application first = new Application("A", "A@wisc.edu", 1);
    Application second = new Application("B", "B@wisc.edu", 2);
    Application third = new Application("C", "C@wisc.edu", 3);
    Application fourth = new Application("D", "D@wisc.edu", 4);
    // enqueue an invalid value (null)
    try {
      testQueue.enqueue(null);
      return false;
    } catch (NullPointerException e) {

    } catch (Exception e) {
      return false;
    }
    // enqueue one valid application
    testQueue.enqueue(third);
    if (testQueue.peek().compareTo(third) != 0 || testQueue.size() != 1) {
      return false;
    }
    // enqueue two more valid applications
    testQueue.enqueue(second);
    testQueue.enqueue(fourth);
    if (!(testQueue.toString().trim()
        .equals("B:B@wisc.edu:2" + "\n" + "C:C@wisc.edu:3" + "\n" + "D:D@wisc.edu:4"))
        || testQueue.size() != 3) {
      return false;
    }
    // enqueue one more application (exceeds capacity)
    try {
      testQueue.enqueue(first);
      return false;
    } catch (IllegalStateException e) {

    } catch (Exception e) {
      return false;
    }
    // dequeue one application (should be lowest score)
    testQueue.dequeue();
    if (!(testQueue.toString().trim().equals("C:C@wisc.edu:3" + "\n" + "D:D@wisc.edu:4"))
        || testQueue.size() != 2) {
      return false;
    }
    // dequeue all applications
    testQueue.dequeue();
    testQueue.dequeue();
    if (testQueue.size() != 0) {
      return false;
    }
    // dequeue from an empty queue
    try {
      testQueue.dequeue();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }

    return true;
  }

  /**
   * This method tests and makes use of the common methods (isEmpty(), size(), peek()) in the
   * ApplicationQueue class.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testCommonMethods() {
    // create an ApplicationQueue with 0 capacity (should fail)
    try {
      ApplicationQueue testQueue = new ApplicationQueue(0);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    Application first = new Application("A", "A@wisc.edu", 1);
    Application second = new Application("B", "B@wisc.edu", 2);
    Application third = new Application("C", "C@wisc.edu", 3);
    OpenPosition op = new OpenPosition("testPosition", 3);
    // create an OpenPosition with capacity 3
    ApplicationQueue testQueue = new ApplicationQueue(3);
    // create an ApplicationQueue with capacity 3
    // and at least 3 Applications with different scores

    // verify the methods' behaviors on an empty queue
    if (testQueue.isEmpty() != true) {
      return false;
    }

    try {
      testQueue.peek();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }

    if (testQueue.size() != 0) {
      return false;
    }
    // add one Application and verify the methods' behaviors
    testQueue.enqueue(second);
    if (testQueue.isEmpty() != false) {
      return false;
    }

    if (testQueue.peek().compareTo(second) != 0) {
      return false;
    }

    if (testQueue.size() != 1) {
      return false;
    }
    // add the rest of the Applications and verify the methods' behaviors
    testQueue.enqueue(first);
    testQueue.enqueue(third);

    if (testQueue.isEmpty() != false) {
      return false;
    }

    if (testQueue.peek().compareTo(first) != 0) {
      return false;
    }

    if (testQueue.size() != 3) {
      return false;
    }
    return true;
  }

  /**
   * This method tests and makes use of OpenPosition class.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testOpenPosition() {
    // create an OpenPosition with 0 capacity (should fail)
    try {
      OpenPosition test = new OpenPosition("test", 0);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    // and at least 5 Applications with different scores
    OpenPosition test = new OpenPosition("test", 5);
    test.add(new Application("A", "A@gmail.com", 10));
    test.add(new Application("A", "A@gmail.com", 50));
    // verify that the 3 MIDDLE-scoring Applications can be added
    // don't use the highest and lowest scoring applications YET
    if (!test.add(new Application("A", "A@gmail.com", 25))) {
      return false;
    }
    if (!test.add(new Application("A", "A@gmail.com", 15))) {
      return false;
    }
    if (!test.add(new Application("A", "A@gmail.com", 29))) {
      return false;
    }
    // verify that getApplications returns the correct value for your input
    if (!test.getApplications().trim().equals("A:A@gmail.com:10\n" + "A:A@gmail.com:15\n"
        + "A:A@gmail.com:29\n" + "A:A@gmail.com:25\n" + "A:A@gmail.com:50")) {
      return false;
    }
    // verify that the result of getTotalScore is the sum of all 3 Application scores
    if (test.getTotalScore() != 10 + 50 + 25 + 15 + 29) {
      return false;
    }
    // verify that the lowest-scoring application is NOT added to the OpenPosition
    if (test.add(new Application("A", "A@gmail.com", 9))) {
      return false;
    }
    // verify that the highest-scoring application IS added to the OpenPosition
    if (!test.add(new Application("A", "A@gmail.com", 51))) {
      return false;
    }
    // verify that getApplications has changed correctly

    if (!test.getApplications().trim()
        .equals("A:A@gmail.com:10\n" + "A:A@gmail.com:15\n" + "A:A@gmail.com:50\n"
            + "A:A@gmail.com:25\n" + "A:A@gmail.com:29\n" + "A:A@gmail.com:51")) {
      return false;
    }
    // verify that the result of getTotalScore has changed correctly
    if (test.getTotalScore() != 10 + 50 + 25 + 15 + 29 + 51) {
      return false;
    }
    return true;
  }

  /**
   * This method calls all the test methods defined and implemented in your OpenPositionTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    return testApplication() && testApplicationIterator() && testEnqueueDequeue()
        && testCommonMethods() && testOpenPosition();
  }

  /**
   * Driver method defined in this OpenPositionTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }
}
