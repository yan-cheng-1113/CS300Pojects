//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Access Control
// Course: CS 300 Spring 2022
//
// Author: Yancheng Zhu
// Email: zhu436@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// None
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class checks whether methods in the User and AccessControl classes work as expected.
 * 
 * @author Yancheng Zhu
 */

public class AccessControlTester {
  /**
   * This tester runs all the tester methods defined in this tester class.
   * 
   * @returns false if any of the tester methods fails, and true if all the tests are passed.
   */
  public static boolean runAllTests() {
    if (testUserConstructorAndMethods() && testAccessControlIsValidLoginNotValidUser()
        && testAddUserWithNoAdminPowers() && testAddRemoveUserWithAdminPowers()) {
      return true;
    }
    System.out.println("Error");
    return false;
  }

  /**
   * Checks whether methods in the User class work as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testUserConstructorAndMethods() {
    User test = new User("JoeDon", "123", true);
    if (!test.getUsername().equals("JoeDon")) {
      System.out.println("getUsername() failed");
      return false;
    }
    if (!test.getIsAdmin()) {
      System.out.println("getIsAdmin() failed");
      return false;
    }
    if (!test.isValidLogin("123")) {
      System.out.println("isValidLogin() failed");
      return false;
    }
    test.setPassword("456");
    test.setIsAdmin(false);
    if (!test.isValidLogin("456")) {
      System.out.println("isValidLogin() failed");
      return false;
    }
    if (test.getIsAdmin()) {
      System.out.println("getIsAdmin() failed");
      return false;
    }
    return true;
  }

  /**
   * Checks whether AccessControl.isValidLogin() method work as expected when a not valid user is
   * passed in.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAccessControlIsValidLoginNotValidUser() {
    AccessControl test = new AccessControl();
    if (AccessControl.isValidLogin("hahaha", "root")) {
      System.out.println("isValidLogin() failed");
      return false;
    }
    if (AccessControl.isValidLogin("admin", "rooe")) {
      System.out.println("isValidLogin() failed");
      return false;
    }
    if (AccessControl.isValidLogin("admid", "rooq")) {
      System.out.println("isValidLogin() failed");
      return false;
    }
    if (!AccessControl.isValidLogin("admin", "root")) {
      System.out.println("isValidLogin() failed");
      return false;
    }
    return true;
  }

  /**
   * Checks whether AccessControl.addUser() method work as expected when currentUser does not have
   * admin power.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddUserWithNoAdminPowers() {
    AccessControl test = new AccessControl();
    test.setCurrentUser("Owen");
    if (test.addUser("anotherone")) {
      System.out.println("addUser() failed");
      return false;
    }
    if (test.addUser("anotherOne")) {
      System.out.println("addUser() failed");
      return false;
    }
    return true;
  }

  /**
   * Checks whether AccessControl.addUser() and AccessControl.removeUser() methods work as expected
   * when currentUser has admin power.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddRemoveUserWithAdminPowers() {
    AccessControl testR = new AccessControl();
    testR.setCurrentUser("admin");
    try {
      if (testR.addUser(null)) {
        System.out.println("addUser() failed");
        return false;
      }
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      System.out.println("addUser() failed");
      return false;
    }
    try {
      if (testR.addUser("Bi")) {
        System.out.println("addUser() failed");
        return false;
      }
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      System.out.println("addUser() failed");
      return false;
    }

    if (!testR.addUser("anotherOne")) {
      System.out.println("addUser() failed");
      return false;
    }
    if (!AccessControl.isValidLogin("anotherOne", "changeme")) {
      System.out.println("addUser() failed");
      return false;
    }
    try {
      if (testR.addUser("anotherOne")) {
        System.out.println("addUser() failed");
        return false;
      }
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      System.out.println("addUser() failed");
      return false;
    }

    if (!testR.removeUser("anotherOne")) {
      System.out.println("removeUser() failed");
      return false;
    }

    if (AccessControl.isValidLogin("anotherOne", "changeme")) {
      System.out.println("removeUser() failed");
      return false;
    }
    try {
      if (testR.removeUser("anotherOne")) {
        System.out.println("removeUser() failed");
        return false;
      }
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      System.out.println("removeUser() failed");
      return false;
    }
    return true;
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    runAllTests();

  }

}
