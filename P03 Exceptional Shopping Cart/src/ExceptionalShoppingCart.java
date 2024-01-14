//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 Exceptional Shopping Cart
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.util.Scanner;

/**
 * This class contains some methods about shopping cart.
 * 
 * @author Yancheng Zhu
 */
public class ExceptionalShoppingCart {

  // Define final parameters (constants)
  private static final double TAX_RATE = 0.05; // sales tax

  // a perfect-size two-dimensional array that stores the list of available items in a given market
  // MarketItems[i][0] refers to a String representation of the item key (unique identifier)
  // MarketItems[i][1] refers the item name
  // MarketItems[i][2] a String representation of the unit price of the item in dollars
  private static String[][] marketItems =
      new String[][] {{"4390", "Apple", "$1.59"}, {"4046", "Avocado", "$0.59"},
          {"4011", "Banana", "$0.49"}, {"4500", "Beef", "$3.79"}, {"4033", "Blueberry", "$6.89"},
          {"4129", "Broccoli", "$1.79"}, {"4131", "Butter", "$4.59"}, {"4017", "Carrot", "$1.19"},
          {"3240", "Cereal", "$3.69"}, {"3560", "Cheese", "$3.49"}, {"3294", "Chicken", "$5.09"},
          {"4071", "Chocolate", "$3.19"}, {"4363", "Cookie", "$9.5"}, {"4232", "Cucumber", "$0.79"},
          {"3033", "Eggs", "$3.09"}, {"4770", "Grape", "$2.29"}, {"3553", "Ice Cream", "$5.39"},
          {"3117", "Milk", "$2.09"}, {"3437", "Mushroom", "$1.79"}, {"4663", "Onion", "$0.79"},
          {"4030", "Pepper", "$1.99"}, {"3890", "Pizza", "$11.5"}, {"4139", "Potato", "$0.69"},
          {"3044", "Spinach", "$3.09"}, {"4688", "Tomato", "$1.79"}, null, null, null, null};

  /**
   * Creates a deep copy of the market catalog
   * 
   * @return Returns a deep copy of the market catalog 2D array of strings
   */
  public static String[][] getCopyOfMarketItems() {
    String[][] copy = new String[marketItems.length][];
    for (int i = 0; i < marketItems.length; i++) {
      if (marketItems[i] != null) {
        copy[i] = new String[marketItems[i].length];
        for (int j = 0; j < marketItems[i].length; j++)
          copy[i][j] = marketItems[i][j];
      }
    }
    return copy;
  }

  /**
   * Returns a string representation of the item whose name is provided as input
   * 
   * @param name name of the item to find
   * @return "itemId name itemPrice" if an item with the provided name was found
   * 
   */
  public static String lookupProductByName(String name) {
    // throws NoSuchElementException with descriptive error message if no match found
    String s = "No match found";
    for (int i = 0; i < marketItems.length; i++) {
      if (marketItems[i] != null && name.equals(marketItems[i][1])) {
        return marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2];
      }
    }
    if (s.equals("No match found")) {
      throw new NoSuchElementException("No such element in the cart.");
    }
    return s;
  }


  /**
   * Returns a string representation of the item whose id is provided as input
   * 
   * @param key id of the item to find
   * @return "itemId name itemPrice" if an item with the provided name was found
   */
  public static String lookupProductById(int key) {
    // throws IllegalArgumentException with descriptive error message if key is not a 4-digits int
    // throws NoSuchElementException with descriptive error message if no match found
    String s = "No match found";
    if (key < 1000 || key > 9999) {
      throw new IllegalArgumentException("key has to be a 4-digit int");
    }
    for (int i = 0; i < marketItems.length; i++) {
      if (marketItems[i] != null) {
        if (marketItems[i][0].equals(String.valueOf(key)))
          return marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2];
      }
    }
    if (s.equals("No match found")) {
      throw new NoSuchElementException("No such element in the cart.");
    }
    return s;
  }

  /**
   * Returns the index of the first null position that can be used to add new market items returns
   * the length of MarketItems if no available null position is found
   * 
   * @return returns an available position to add new market items or the length of market items if
   *         no available positions are found
   */
  private static int indexOfInsertionPos() {
    for (int i = 0; i < marketItems.length; i++) {
      if (marketItems[i] == null)
        return i;
    }
    return marketItems.length;
  }

  /**
   * add a new item to market items array, expand the capacity of marketitems if it is full when
   * trying to add new item, use indexofInsertionPos() to find the position to add
   * 
   * @param id    id of the item to add
   * @param name  name of the item to add
   * @param price price of the item to add
   */
  public static void addItemToMarketCatalog(String id, String name, String price) {
    // throws IllegalArgumentException with descriptive error message if id not parsable to 4-digits
    // int, name is null or empty string, and price not parsable to double
    if (name == null || name == "") {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (id.length() != 4) {
      throw new IllegalArgumentException("ID must be a four-digit integer");
    }
    try {
      int idNumber = Integer.parseInt(id);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("ID must be a four-digit integer");
    }
    try {
      double expense = Double.parseDouble(price.substring(1));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Price must be double");
    }
    int next = indexOfInsertionPos();
    if (next == marketItems.length) {
      System.out.println("Full catalog! No further item can be added!");
      String[][] expanded = new String[(marketItems.length) * 2][];
      for (int i = 0; i < marketItems.length; i++) {
        expanded[i] = marketItems[i];
      }
      marketItems = expanded;
      marketItems[next] = new String[] {id, name, price};
    } else {
      marketItems[next] = new String[] {id, name, price};
    }
  }

  /**
   * Returns the price in dollars (a double value) of a market item given its name.
   * 
   * @param name name of the item to get the price
   * @return the price of the item
   */
  public static double getProductPrice(String name) {
    // throws NoSuchElementException with descriptive error message if price not found
    double price = -1.0;
    for (int i = 0; i < marketItems.length; i++) {
      if (marketItems[i] != null && name.equals(marketItems[i][1])) {
        return Double.valueOf(marketItems[i][2].substring(1));
      }
    }
    if (Math.abs(price - (-1.0)) < 0.0001) {
      throw new NoSuchElementException("Price is not found");
    }
    return price;
  }

  /**
   * Appends an item to a given cart (appends means adding to the end). If the cart is already full
   * (meaning its size equals its length), IllegalStateException wil be thrown.
   * 
   * @param item the name of the product to be added to the cart
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the size of the oversize array cart after trying to add item to the cart.
   */
  public static int addItemToCart(String item, String[] cart, int size) {
    // throws IllegalArgumentException with descriptive error message if size is less than zero
    // throws IllegalStateException with descriptive error message if this cart is full
    if (size < 0) {
      throw new IllegalArgumentException("Size must be larger than 0");
    }
    if (size == cart.length) {
      throw new IllegalStateException("Cart is full");
    }
    cart[size] = item;
    size++;
    return size;
  }

  /**
   * Returns the number of occurrences of a given item within a cart. This method must not make any
   * changes to the contents of the cart.
   * 
   * @param item the name of the item to search
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the number of occurrences of item (exact match) within the oversize array cart. Zero or
   *         more occurrences of item can be present in the cart.
   */
  public static int nbOccurrences(String item, String[] cart, int size) {
    // throws IllegalArgumentException with descriptive error message if size is less than zero
    if (size < 0) {
      throw new IllegalArgumentException("Size must be larger than 0");
    }
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (cart[i].equals(item)) {
        count++;
      }
    }
    return count;
  }

  /**
   * Checks whether a cart contains at least one occurrence of a given item. This method must not
   * make any changes to the contents of the cart.
   * 
   * @param item the name of the item to search
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return Returns true if there is a match (exact match) of item within the provided cart, and
   *         false otherwise.
   */
  public static boolean contains(String item, String[] cart, int size) {
    // throws IllegalArgumentException with descriptive error message if size is less than zero
    if (size < 0) {
      throw new IllegalArgumentException("Size must be larger than 0");
    }
    for (int i = 0; i < size; i++) {
      if (cart[i].equals(item)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Removes one occurrence of item from a given cart.
   * 
   * @param item the name of the item to remove
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return Returns the size of the oversize array cart after trying to remove item from the cart.
   */
  public static int removeItem(String[] cart, String item, int size) {
    // throws IllegalArgumentException with descriptive error message if size is less than zero
    // throws NoSuchElementException with descriptive error message if item not found in the cart
    if (size < 0) {
      throw new IllegalArgumentException("Size must be larger than 0");
    }
    int temp = size;
    for (int i = 0; i < size; i++) {
      if (cart[i].equals(item)) {
        cart[i] = cart[size - 1];
        cart[size - 1] = null;
        return size - 1;
      }
    }
    if (size == temp) {
      throw new NoSuchElementException("Item not found");
    }
    return size;
  }


  /**
   * Removes all items from a given cart. The array cart must be empty (contains only null
   * references) after this method returns.
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return Returns the size of the cart after removing all its items.
   */
  public static int emptyCart(String[] cart, int size) {
    // throws IllegalArgumentException with descriptive error message if size is less than zero
    // throws NullPointerException with descriptive error message if cart is null
    if (size < 0) {
      throw new IllegalArgumentException("Size must be larger than 0");
    }
    if (cart == null) {
      throw new NullPointerException("Cart cannot be null");
    }
    for (int i = 0; i < cart.length; i++) {
      cart[i] = null;
    }
    return 0;
  }


  /**
   * This method returns the total value in dollars of the cart. All products in the market are
   * taxable (subject to TAX_RATE).
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return Returns the total value in dollars of the cart accounting taxes.
   */
  public static double checkout(String[] cart, int size) {
    // throws IllegalArgumentException with descriptive error message if size is less than zero
    if (size < 0) {
      throw new IllegalArgumentException("Size must be larger than 0");
    }
    double total = 0.0;
    for (int i = 0; i < size; i++) {
      total += getProductPrice(cart[i]) * (1 + TAX_RATE);
    }
    return total;
  }

  /**
   * Returns a string representation of the summary of the contents of a given cart. The format of
   * the returned string contains a set of lines where each line contains the number of occurrences
   * of a given item, between spaces and parentheses, followed by one space followed by the name of
   * a unique item in the cart. ( #occurrences ) name1 ( #occurrences ) name2 etc.
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return Returns a string representation of the summary of the contents of the cart
   */
  public static String getCartSummary(String[] cart, int size) {
    // throws IllegalArgumentException with descriptive error message if size is less than zero
    if (size < 0) {
      throw new IllegalArgumentException("Size must be larger than 0");
    }
    String s = "";
    for (int i = 0; i < size; i++) {
      if (!contains(cart[i], cart, i)) {
        s = s + "( " + nbOccurrences(cart[i], cart, size) + " ) " + cart[i] + "\n";
      }
    }
    return s.trim();
  }


  /**
   * Save the cart summary to a file.
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @param file the file to save the cart summary
   */
  public static void saveCartSummary(String[] cart, int size, File file) {
    // throws IllegalArgumentException with descriptive error message if size is less than zero
    // NO other exception should be thrown by this method
    // Use finally block to close any resource used to write the cart summary into file
    if (size < 0) {
      throw new IllegalArgumentException("Size must be larger than 0");
    }
    FileWriter flWriter = null;
    PrintWriter prWriter = null;
    String summary = "";
    try {
      flWriter = new FileWriter(file);
      prWriter = new PrintWriter(flWriter);
      summary = getCartSummary(cart, size);
      prWriter.print(summary);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      prWriter.close();
    }

  }


  /**
   * Parse one line of cart summary and add nbOccurrences of item to cart correct formatting for
   * line:"( " + nbOccurrences + " ) " + itemName delimiter: one space (multiple spaces: wrong
   * formatting)
   * 
   * @param line a line of the cart summary to be parsed into one item to be added
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @throws DataFormatException
   */
  protected static int parseCartSummaryLine(String line, String[] cart, int size)
      throws DataFormatException {
    // throws DataFormatException with descriptive error message if wrong formatting (including
    // nbOccurrences not parsable to a positive integer less or equal to 10)

    // throws IllegalArgumentException with descriptive error message if itemName not found in
    // marketItems

    // throws IllegalStateException with descriptive error message if cart reaches its capacity
    // NO other exception should be thrown by this method
    Scanner scnr = new Scanner(line);
    String temp = "";
    while (scnr.hasNextLine()) {
      temp = scnr.nextLine();
      String name = "";
      int count = 0;
      try {
        count = Integer.parseInt(temp.substring(temp.indexOf(" ") + 1, temp.indexOf(")") - 1));
      } catch (NumberFormatException e) {
        throw new DataFormatException("Wrong number of occurence");
      }
      if (count > 10 || count <= 0) {
        throw new DataFormatException("Wrong number of occurence");
      }
      name = temp.substring(temp.indexOf(")") + 2);
      try {
        lookupProductByName(name);
      } catch (NoSuchElementException e) {
        throw new IllegalArgumentException("Item not found");
      }
      for (int i = 0; i < count; i++) {
        if (size == cart.length) {
          throw new IllegalStateException("The cart is full");
        }
        cart[size] = name;
        size++;
      }
    }

    return size; // default return statement added to avoid compiler errors
  }

  /**
   * Load the cart summary from the file. For each line of summary, add nbOccurrences of item to
   * cart. Must call parseCartSummaryLine to operate
   * 
   * @param file file to load the cart summary from
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return Returns the size of the cart after adding items to the cart
   */
  public static int loadCartSummary(File file, String[] cart, int size) {
    // This method MUST call parseCartSummaryLine to operate (to parse each line in file)

    // throws IllegalArgumentException with descriptive error message if size is less than zero
    // throws IllegalStateException with descriptive error message if cart reaches its capacity
    // NO other exception should be thrown by this method
    // Use finally block to close any resource used to read from file
    if (size < 0) {
      throw new IllegalArgumentException("Size must be larger than 0");
    }
    int newSize = size;
    Scanner reader = null;
    String temp = "";
    try {
      reader = new Scanner(file);
      while (reader.hasNextLine()) {
        temp = reader.nextLine();
        try {
          newSize = parseCartSummaryLine(temp, cart, newSize);
        } catch (IllegalStateException e) {
          throw new IllegalStateException("Cart is full");
        } catch (Exception e) {
          continue;
        }
      }
    } catch (FileNotFoundException e) {
      return size;
    } finally {
      if (reader != null) {
        reader.close();
      }
    }
    return newSize; // default return statement added to avoid compiler errors
  }
}
