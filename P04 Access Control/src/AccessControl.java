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
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class contains methods and variables of an AccessControl object.
 * 
 * @author Yancheng Zhu
 */
public class AccessControl {
  private static ArrayList<User> users;
  private User currentUser;
  private static final String DEFAULT_PASSWORD = "changeme";

  /**
   * Creates a new AccessControl object
   * 
   */
  public AccessControl() {
    if (users == null) {
      users = new ArrayList<User>();
      users.add(new User("admin", "root", true));
    }
    currentUser = null;
  }

  /**
   * Reports whether a given username/password pair is a valid login
   * 
   * @param username username of the user
   * @param password password of the user
   * @return true if the input username and password match one of the user's username and password
   *         in the list of users, false otherwise
   */
  public static boolean isValidLogin(String username, String password) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i) != null && users.get(i).getUsername().equals(username)
          && users.get(i).isValidLogin(password)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Changes currentUser's password to the input password
   *
   * @param password password need to be changed to
   */
  public void changePassword(String newPassword) {
    currentUser.setPassword(newPassword);
  }

  /**
   * Set currentUser to null
   *
   */
  public void logout() {
    currentUser = null;
  }

  /**
   * Make one user in the list of users become the currentUser
   *
   * @param username username of the user need to be set to the currentUser
   */
  public void setCurrentUser(String username) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i) != null && users.get(i).getUsername().equals(username)) {
        currentUser = users.get(i);
        break;
      }
    }
  }

  /**
   * Creates a new user with the default password and false as admin status and add it to the users
   * ArrayList throws an IllegalArgumentException with a descriptive error message if username is
   * null or if its length is less than 5 ( < 5), or if a user with the same username is already in
   * the list of users
   *
   * @param username username of the user need to be added to the list of users
   * @return true if the current user has admin power and the new user was successfully added, false
   *         otherwise
   */
  public boolean addUser(String username) {
    if (username == null || username.length() < 5) {
      throw new IllegalArgumentException("Wrong format");
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i) != null && users.get(i).getUsername().equals(username)) {
        throw new IllegalArgumentException("Username exists");
      }
    }
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    User newOne = new User(username, DEFAULT_PASSWORD, false);
    users.add(newOne);
    return true;
  }

  /**
   * Creates a new user with the default password and specified admin status and add it to the users
   * ArrayList throws an IllegalArgumentException with a descriptive error message if username is
   * null or if its length is less than 5 ( < 5), or if a user with the same username is already in
   * the list of users
   *
   * @param username username of the user need to be added to the list of users
   * @param isAdmin  admin status of the user
   * @return true if the current user has admin power and the new user was successfully added, false
   *         otherwise
   */
  public boolean addUser(String username, boolean isAdmin) {
    if (username == null || username.length() < 5) {
      throw new IllegalArgumentException("Wrong format");
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i) != null && users.get(i).getUsername().equals(username)) {
        throw new IllegalArgumentException("Username exists");
      }
    }
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    User newUser = new User(username, DEFAULT_PASSWORD, isAdmin);
    users.add(newUser);
    return true;
  }

  /**
   * Removes a user given their unique username throws a NoSuchElementException with a descriptive
   * error message if no match with username is found in the list of users
   *
   * @param username username of the user need to be removed from the list of users
   * @return true if the current user has Admin powers and the user whose username is passed as
   *         input was successfully removed, false otherwise
   */
  public boolean removeUser(String username) {
    if (currentUser != null && currentUser.getIsAdmin()) {
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i) != null && users.get(i).getUsername().equals(username)) {
          users.set(i, null);
          return true;
        }
      }
      throw new NoSuchElementException("User not found");
    }
    return false;

  }

  /**
   * Give a user admin power throws a NoSuchElementException with a descriptive error message if no
   * match with username is found in the list of users
   *
   * @param username username of the user need to be given admin power
   * @return true if this operation terminates successfully, false if the current user is null or
   *         does not have admin powers
   */
  public boolean giveAdmin(String username) {
    if (currentUser != null && currentUser.getIsAdmin()) {
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i) != null && users.get(i).getUsername().equals(username)) {
          users.get(i).setIsAdmin(true);
          return true;
        }
      }
      throw new NoSuchElementException("User not found");
    }
    return false;
  }

  /**
   * Remove the admin power of a user given their username throws a NoSuchElementException with a
   * descriptive error message if no match with username is found in the list of users
   *
   * @param username username of the user need to be taken admin power
   * @return true if this operation terminates successfully, false if the current user is null or
   *         does not have admin powers
   */
  public boolean takeAdmin(String username) {
    if (currentUser != null && currentUser.getIsAdmin()) {
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i) != null && users.get(i).getUsername().equals(username)) {
          users.get(i).setIsAdmin(false);
          return true;
        }
      }
      throw new NoSuchElementException("User not found");
    }
    return false;
  }

  /**
   * Reset the password of a user given their username throws a NoSuchElementException with a
   * descriptive error message if no match with username is found in the list of users
   *
   * @param username username of the user need to be reset password
   * @return true if this operation terminates successfully, false if the current user is null or
   *         does not have admin powers
   */
  public boolean resetPassword(String username) {
    if (currentUser != null && currentUser.getIsAdmin()) {
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i) != null && users.get(i).getUsername().equals(username)) {
          users.get(i).setPassword("DEFAULT_PASSWORD");
          return true;
        }
      }
      throw new NoSuchElementException("User not found");
    }
    return false;
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {


  }

}
