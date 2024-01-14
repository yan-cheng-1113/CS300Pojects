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

/**
 * This class contains methods and variables of a User object.
 * 
 * @author Yancheng Zhu
 */

public class User {
  private final String USERNAME;
  private String password;
  private boolean isAdmin;

  /**
   * Creates a new user with the given password and admin status
   * 
   * @param username username of the user
   * @param password password of the user
   * @param isAdmin  whether the user has admin power
   */
  public User(String username, String password, boolean isAdmin) {
    this.USERNAME = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  /**
   * Checks whether the password passed in is correct
   * 
   * @param password password of the user
   * @return true if the input password matches user's password, false otherwise
   */
  public boolean isValidLogin(String password) {
    if (password.equals(this.password)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns username of the user
   * 
   * @return user's username
   */
  public String getUsername() {
    return USERNAME;
  }

  /**
   * Returns whether the user has admin power
   * 
   * @return true if the user has admin power, false otherwise
   */
  public boolean getIsAdmin() {
    return isAdmin;
  }

  /**
   * Changes user's password to the input password
   * 
   * @param password password need to be changed to
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Changes user's admin status
   * 
   * @param isAdmin new admin status of the user
   */
  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }
}
