//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P03 Exceptional Shopping Cart
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
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.util.Scanner;

/**
 * This class checks whether methods in the ExceptionalShoppingCart class work as expected.
 * 
 * @author Yancheng Zhu
 */
public class ExceptionalShoppingCartTester {
  /**
   * This tester runs all the tester methods defined in this tester class.
   * 
   * @returns false if any of the tester methods fails, and true if all the tests are passed.
   */
  public static boolean runAllTests() {
    if (testLookupMethods() && testAddItemToMarketCatalog() && testGetProductPrice()
        && testAddItemToCart() && testNbOccurrences() && testContains() && testRemoveItem()
        && testEmptyCart() && testCheckOout() && testGetCartSummary() && testSaveCartSummary()
        && testParseCartSummaryLine() && testLoadCartSummary()) {
      return true;

    } else {
      System.out.println("Problem detected");
      return false;
    }

  }

  /**
   * Checks whether ExceptionalShoppingCart.lookupProductByName() and
   * ShoppingCart.lookupProductById() methods work as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookupMethods() {
    try {
      ExceptionalShoppingCart.lookupProductByName("a");
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.lookupProductById(5678);
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.lookupProductById(10000);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.lookupProductById(999);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.lookupProductById(4390);
    } catch (NoSuchElementException e) {
      return false;
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.lookupProductByName("Avocado");
    } catch (NoSuchElementException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.addItemToMarketCatalog() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddItemToMarketCatalog() {
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("id", "tuidan", "$2.0");
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("1113", "", "$5.0");
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("1234", null, "$19.5");
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("5332", "kaogou", "$two");
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("5423", "dantui", "$20.0");
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.getProductPrice() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetProductPrice() {
    try {
      ExceptionalShoppingCart.getProductPrice("haochi");
      return false;
    } catch (NoSuchElementException e) {// System.out.println(e.getMessage());
    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.getProductPrice("Beef");
    } catch (NoSuchElementException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.addItemToCart() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddItemToCart() {
    String[] cart = new String[10];
    try {
      ExceptionalShoppingCart.addItemToCart("item", cart, -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.addItemToCart("item", cart, 10);
      return false;
    } catch (IllegalStateException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.addItemToCart("item", cart, 0);
    } catch (IllegalStateException e) {
      return false;
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.nbOccurrences() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testNbOccurrences() {
    String[] testCart = new String[10];
    try {
      ExceptionalShoppingCart.nbOccurrences("item", testCart, -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.nbOccurrences("item", testCart, 0);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.contains() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
    String[] testCart = new String[] {"Apple", "Beef", null};
    try {
      ExceptionalShoppingCart.contains("Beef", testCart, -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.contains("Beef", testCart, 2);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.removeItem() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveItem() {
    String[] testCart = new String[] {"Apple", "Beef", null};
    try {
      ExceptionalShoppingCart.removeItem(testCart, "Beef", -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.removeItem(testCart, "tui", 2);
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.removeItem(testCart, "Apple", 2);
    } catch (NoSuchElementException e) {
      return false;
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.emptyCart() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testEmptyCart() {
    String[] testCart = new String[3];
    try {
      ExceptionalShoppingCart.emptyCart(testCart, -1);
      return false;

    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    testCart = null;
    try {
      ExceptionalShoppingCart.emptyCart(testCart, 0);
      return false;
    } catch (NullPointerException e) {

    } catch (Exception e) {
      return false;
    }
    testCart = new String[] {"Apple", "Beef", null};
    try {
      ExceptionalShoppingCart.emptyCart(testCart, 2);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (NullPointerException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.checOut() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCheckOout() {
    String[] testCart = new String[10];
    try {
      ExceptionalShoppingCart.checkout(testCart, -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.checkout(testCart, 0);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.getCartSummary() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetCartSummary() {
    String[] testCart = new String[10];
    try {
      ExceptionalShoppingCart.getCartSummary(testCart, -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.getCartSummary(testCart, 0);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.saveCartSummary() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSaveCartSummary() {
    String fileName = "testFile.txt";
    String[] testCart = new String[] {"Apple", "Beef", null};
    File testFile = new File(fileName);
    try {
      ExceptionalShoppingCart.saveCartSummary(testCart, -1, testFile);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.saveCartSummary(testCart, 2, testFile);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.parseCartSummary() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testParseCartSummaryLine() {
    String line = "( 11 ) Avocado";
    String[] testCart = new String[] {"Apple", "Beef", null, null, null};
    try {
      ExceptionalShoppingCart.parseCartSummaryLine(line, testCart, 2);
      return false;
    } catch (DataFormatException e) {

    } catch (Exception e) {
      return false;
    }
    line = "( 0 ) Avocado";
    try {
      ExceptionalShoppingCart.parseCartSummaryLine(line, testCart, 2);
      return false;
    } catch (DataFormatException e) {

    } catch (Exception e) {
      return false;
    }
    line = "( a ) Avocado";
    try {
      ExceptionalShoppingCart.parseCartSummaryLine(line, testCart, 2);
      return false;
    } catch (DataFormatException e) {

    } catch (Exception e) {
      return false;
    }
    line = "( 2 ) dan";
    try {
      ExceptionalShoppingCart.parseCartSummaryLine(line, testCart, 2);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    line = "( 5 ) Milk";
    try {
      ExceptionalShoppingCart.parseCartSummaryLine(line, testCart, 2);
      return false;
    } catch (IllegalStateException e) {

    } catch (Exception e) {
      return false;
    }
    line = "( 2 ) Butter";
    try {
      ExceptionalShoppingCart.parseCartSummaryLine(line, testCart, 2);
    } catch (DataFormatException e) {
      return false;
    } catch (IllegalArgumentException e) {
      return false;
    } catch (IllegalStateException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ExceptionalShoppingCart.loadCartSummary() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLoadCartSummary() {
    String fileName = "test.txt";
    File test = new File(fileName);
    FileWriter writer = null;
    try {
      writer = new FileWriter(test);

    } catch (IOException e) {
      e.printStackTrace();
    }
    PrintWriter prWriter = new PrintWriter(writer);
    prWriter.print("( 2 ) Butter\n");
    prWriter.close();
    String[] testCart = new String[] {"Apple", "Beef", null, null, null};
    try {
      ExceptionalShoppingCart.loadCartSummary(test, testCart, -1);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      ExceptionalShoppingCart.loadCartSummary(test, testCart, 5);
      return false;
    } catch (IllegalStateException e) {

    } catch (Exception e) {
      return false;
    }
    int size = 2;
    try {
      size = ExceptionalShoppingCart.loadCartSummary(test, testCart, 2);
    } catch (IllegalArgumentException e) {
      return false;
    } catch (IllegalStateException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    if (size != 4) {
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
