//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 Shopping Cart
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
 * This class checks whether methods in the ShoppingCart class work as expected.
 * 
 * @author Yancheng Zhu
 */
public class ShoppingCartTester {
  /**
   * Checks whether ShoppingCart.lookupProductByName() and ShoppingCart.lookupProductById() methods
   * work as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookupMethods() {
    // define test scenarios.
    // 1. The item to find is at index 0 of the marketItems array
    String expectedOutput = "4390 Apple $1.59";
    if (!ShoppingCart.lookupProductByName("Apple").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Apple as input");
      return false;
    }
    if (!ShoppingCart.lookupProductById(4390).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id " + "of Apple as input");
      return false;
    }
    // 2. The item to find is at the last non-null position of
    // the marketItems array
    expectedOutput = "4688 Tomato $1.79";
    if (!ShoppingCart.lookupProductByName("Tomato").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Tomato as input");
      return false;
    }
    if (!ShoppingCart.lookupProductById(4688).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id " + "of Tomato as input");
      return false;
    }
    // 3. The item to find is at an arbitrary position of the
    // middle of the marketItems array
    expectedOutput = "4363 Cookie $9.5";
    if (!ShoppingCart.lookupProductByName("Cookie").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Cookie as input");
      return false;
    }
    if (!ShoppingCart.lookupProductById(4363).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id " + "of Cookie as input");
      return false;
    }
    // 4. The item to find is not found in the market
    expectedOutput = "No match found";
    if (!ShoppingCart.lookupProductByName("NOT FOUND").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed the name of "
          + "a product not found in the market.");
      return false;
    }
    if (!ShoppingCart.lookupProductById(1000).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the identifier"
          + "of a product not found in the market.");
      return false;
    }
    return true; 
  }

  /**
   * Checks the correctness of ShoppingCart.getProductPrice() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetProductPrice() {
    // 1. Price of the first item in the cart.
    double expectedPrice = 1.59;
    if (Math.abs(ShoppingCart.getProductPrice("Apple") - expectedPrice) > 0.001) {
      System.out.println(
          "Problem detected: Your getProductPrice() method failed to return the expected output.");
      return false;
    }
    // 2. Price of the last item in the cart.
    expectedPrice = 1.79;
    if (Math.abs(ShoppingCart.getProductPrice("Tomato") - expectedPrice) > 0.001) {
      System.out.println(
          "Problem detected: Your getProductPrice() method failed to return the expected output.");
      return false;
    }
    // 3. Price of an item at an arbitrary position in the cart.
    expectedPrice = 9.5;
    if (Math.abs(ShoppingCart.getProductPrice("Cookie") - expectedPrice) > 0.001) {
      System.out.println(
          "Problem detected: Your getProductPrice() method failed to return the expected output.");
      return false;
    }
    // 4. Price of an item that is not in the cart.
    expectedPrice = -1.0;
    if (Math.abs(ShoppingCart.getProductPrice("Unknown") - expectedPrice) > 0.001) {
      System.out.println(
          "Problem detected: Your getProductPrice() method failed to return the expected output.");
      return false;
    }
    return true;
  }

  /**
   * This tester method checks the correctness of addItemToCart, contains, and nbOccurrences methods
   * defined in the ShoppingCart class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddItemToCartContainsNbOccurrences() {
    // 1. Add item to an empty cart.
    String[] testCart = new String[] {null, null, null, null, null, null, null};
    int expectedSize = 1;
    if (ShoppingCart.addItemToCart("Apple", testCart, 0) != expectedSize) {
      System.out.println(
          "Problem detected: Your addItemToCart() method failed to return the expected output.");
      return false;
    }
    if (!ShoppingCart.contains("Apple", testCart, 1)) {
      System.out.println(
          "Problem detected: Your contains() method failed to return the expected output.");
      return false;
    }
    if (ShoppingCart.nbOccurrences("Apple", testCart, 1) != 1) {
      System.out.println(
          "Problem detected: Your nbOccurences() method failed to return the expected output.");
      return false;
    }
    // 2. Add item to a full cart.
    testCart = new String[] {"Apple", "Banana", "Beef"};
    expectedSize = 3;
    if (ShoppingCart.addItemToCart("Cookie", testCart, 3) != expectedSize) {
      System.out.println(
          "Problem detected: Your addItemToCart() method failed to return the expected output.");
      return false;
    }
    if (ShoppingCart.contains("Cookie", testCart, 3)) {
      System.out.println(
          "Problem detected: Your contains() method failed to return the expected output.");
      return false;
    }
    if (ShoppingCart.nbOccurrences("Cookie", testCart, 3) != 0) {
      System.out.println(
          "Problem detected: Your nbOccurences() method failed to return the expected output.");
      return false;
    }
    // 3. A successful addition.
    testCart = new String[] {"Apple", "Pair", "Milk", "Orange", null, null, null};
    expectedSize = 5;
    if (ShoppingCart.addItemToCart("Tomato", testCart, 4) != expectedSize) {
      System.out.println(
          "Problem detected: Your addItemToCart() method failed to return the expected output.");
      return false;
    }
    if (!ShoppingCart.contains("Tomato", testCart, 5)) {
      System.out.println(
          "Problem detected: Your contains() method failed to return the expected output.");
      return false;
    }
    if (ShoppingCart.nbOccurrences("Tomato", testCart, 5) != 1) {
      System.out.println(
          "Problem detected: Your nbOccurences() method failed to return the expected output.");
      return false;
    }
    return true;
  }

  /**
   * This tester method checks the correctness of removeItem() method defined in the ShoppingCart
   * class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveItem() {
    // 1. Remove the first item from the cart.
    String[] testCart = new String[] {"Apple", "Banana", "Beef", null};
    if (ShoppingCart.removeItem(testCart, "Apple", 3) != 2) {
      System.out.println(
          "Problem detected: Your removeItem() method failed to return the expected output.");
      return false;
    }
    if (ShoppingCart.nbOccurrences("Apple", testCart, 2) != 0) {
      System.out.println(
          "Problem detected: Your removeItem() method failed to return the expected output.");
      return false;
    }
    // 2. Remove the last item from the cart.
    testCart = new String[] {"Apple", "Banana", "Beef", "Orange", null, null};
    if (ShoppingCart.removeItem(testCart, "Orange", 4) != 3) {
      System.out.println(
          "Problem detected: Your removeItem() method failed to return the expected output.");
      return false;
    }
    if (ShoppingCart.nbOccurrences("Orange", testCart, 3) != 0) {
      System.out.println(
          "Problem detected: Your removeItem() method failed to return the expected output.");
      return false;
    }
    // 3. Remove an item at an arbitrary position from the cart.
    testCart = new String[] {"Apple", "Banana", "Apple", "Orange", null};
    if (ShoppingCart.removeItem(testCart, "Banana", 4) != 3) {
      System.out.println(
          "Problem detected: Your removeItem() method failed to return the expected output.");
      return false;
    }
    if (ShoppingCart.nbOccurrences("Banana", testCart, 3) != 0) {
      System.out.println(
          "Problem detected: Your removeItem() method failed to return the expected output.");
      return false;
    }
    // 4. Remove the item from an empty cart.
    testCart = new String[3];
    if (ShoppingCart.removeItem(testCart, "Apple", 0) != 0) {
      System.out.println(
          "Problem detected: Your removeItem() method failed to return the expected output.");
      return false;
    }
    // 5. Remove a non-existing item from the cart.
    testCart = new String[] {"Apple", "Banana", "Beef"};
    if (ShoppingCart.removeItem(testCart, "Orange", 3) != 3) {
      System.out.println(
          "Problem detected: Your removeItem() method failed to return the expected output.");
      return false;
    }
    return true;
  }

  /**
   * This tester method checks the correctness of checkout and getCartSummary() methods defined in
   * the ShoppingCart class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCheckoutGetCartSummary() {
    // 1. Get summary of an empty cart.
    String[] testCart = new String[7];
    String expectedSummary = "";
    double expectedExpense = 0.0;
    if (!ShoppingCart.getCartSummary(testCart, 0).equals(expectedSummary)) {
      System.out.println(
          "Problem detected: Your getCartSummary() method failed to return the expected output.");
      return false;
    }
    if (Math.abs(ShoppingCart.checkout(testCart, 0) - expectedExpense) > 0.001) {
      System.out.println(
          "Problem detected: Your checkout() method failed to return the expected output.");
      return false;
    }
    // 2. Get summary of a cart contains non-duplicate items.
    testCart = new String[] {"Milk", "Apple", "Banana", "Pizza", null, null};
    expectedSummary = "(1) Milk\n(1) Apple\n(1) Banana\n(1) Pizza\n";
    expectedExpense = 16.4535;
    if (!ShoppingCart.getCartSummary(testCart, 4).equals(expectedSummary)) {
      System.out.println(
          "Problem detected: Your getCartSummary() method failed to return the expected output.");
      return false;
    }
    if (Math.abs(ShoppingCart.checkout(testCart, 4) - expectedExpense) > 0.001) {
      System.out.println(
          "Problem detected: Your checkout() method failed to return the expected output.");
      return false;
    }
    // 3. Get summary of a cart contains duplicate items
    testCart = new String[] {"Tomato", "Milk", "Milk", "Eggs", "Tomato", "Onion", "Eggs", "Milk",
        "Banana", null, null};
    expectedSummary = "(2) Tomato\n(3) Milk\n(2) Eggs\n(1) Onion\n(1) Banana\n";
    expectedExpense = 18.1755;
    if (!ShoppingCart.getCartSummary(testCart, 9).equals(expectedSummary)) {
      System.out.println(
          "Problem detected: Your getCartSummary() method failed to return the expected output.");
      return false;
    }
    if (Math.abs(ShoppingCart.checkout(testCart, 9) - expectedExpense) > 0.001) {
      System.out.println(
          "Problem detected: Your checkout() method failed to return the expected output.");
      return false;
    }
    return true;
  }

  /**
   * This tester runs all the tester methods defined in this tester class.
   * 
   * @returns false if any of the tester methods fails, and true if all the tests are passed.
   */
  public static boolean runAllTests() {
    if (testLookupMethods() && testGetProductPrice() && testAddItemToCartContainsNbOccurrences()
        && testRemoveItem() && testCheckoutGetCartSummary()) {
      System.out.println("All tests passed.");
      return true;
    } else {
      System.out.println("Problem detected.");
      return false;
    }
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
