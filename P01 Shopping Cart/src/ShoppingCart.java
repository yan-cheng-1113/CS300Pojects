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
 * This class implements a simple version of a Shopping Cart using Java Arrays.
 * 
 * @author Yancheng Zhu
 */
public class ShoppingCart {

  private static final double TAX_RATE = 0.05;// sales tax

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
   * Returns details of a specific product in the market given its name
   *
   * @param name name of the product to search
   * @return A string representation of the product to search including the identifier of the
   *         product, its name, and its price in dollars if match found.
   */
  public static String lookupProductByName(String name) {
    String result = "No match found";
    for (int i = 0; i < marketItems.length; ++i) {
      if (marketItems[i] != null && marketItems[i][1].equals(name)) {
        result = marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2];
        return result;
      }


    }
    return result;
  }

  /**
   * Returns details of a specific product in the market given its id number.
   *
   * @param id identifier of the product to search
   * @return A string representation of the product to search including the identifier of the
   *         product, its name, and its price in dollars if match found.
   */
  public static String lookupProductById(int id) {
    String result = "No match found";
    for (int i = 0; i < marketItems.length; i++) {
      if (marketItems[i] != null && Integer.parseInt(marketItems[i][0]) == id) {
        result = marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2];
        return result;
      }


    }
    return result;

  }

  /**
   * Returns the price in dollars (a double value) of a market item given its name
   *
   * @param name name of the product to search
   * @return A double representation of the price of the product, -1.0 if no match was found in the
   *         market catalog,
   */
  public static double getProductPrice(String name) {
    double price = -1.0;
    for (int i = 0; i < marketItems.length; ++i) {
      if (marketItems[i] != null && marketItems[i][1].equals(name)) {
        price = Double.parseDouble(marketItems[i][2].substring(1));
        return price;
      }

    }
    return price;
  }

  /**
   * Returns a deep copy of the marketItems array
   *
   * @return A deep copy of the marketItems array
   */
  public static String[][] getCopyOfMarketItems() {
    String[][] copy = new String[marketItems.length][];
    for (int i = 0; i < marketItems.length; i++) {
      copy[i] = marketItems[i];
    }
    return copy;
  }

  /**
   * Appends an item to a given cart. If the cart is already full, the item will not be added to the
   * cart.
   * 
   * @param item the name of the product to be added to the cart
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the size of the oversize array cart after trying to add item. This method returns the
   *         same of size without making any change to the contents of the array if it is full.
   */
  public static int addItemToCart(String item, String[] cart, int size) {
    int newSize = 0;
    if (size != cart.length && item != null) {
      cart[size] = item;
      newSize = size + 1;
    } else {
      newSize = size;
    }
    return newSize;
  }

  /**
   * Counts the number of occurrences of a given item within a cart.
   * 
   * @param item the name of the product to be added to the cart
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the number of occurrences of item (exact match) within the oversize array cart
   */
  public static int nbOccurrences(String item, String[] cart, int size) {
    int occurenceCount = 0;
    for (int i = 0; i < size; i++) {
      if (cart[i].equals(item)) {
        occurenceCount++;
      }
    }
    return occurenceCount;
  }

  /**
   * Checks whether a cart contains at least one occurrence of a given item.
   * 
   * @param item the name of the product to be added to the cart
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return true if there is a match (exact match) of item within the provided cart, and false
   *         otherwise.
   */
  public static boolean contains(String item, String[] cart, int size) {
    boolean contain = false;
    if (nbOccurrences(item, cart, size) > 0) {
      contain = true;
    }
    return contain;
  }

  /**
   * Returns the total value in dollars of the cart after being taxed.
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the total value in dollars of the cart accounting taxes.
   */
  public static double checkout(String[] cart, int size) {
    double expense = 0.0;
    if (size > 0) {
      for (int i = 0; i < size; i++) {
        expense += getProductPrice(cart[i]) * (1.0 + TAX_RATE);
      }
    }
    return expense;
  }

  /**
   * Removes one occurrence of item from a given cart. If no match with item was found in the cart,
   * the method returns the same value of input size without making any change to the contents of
   * the array.
   * 
   * @param item the name of the product to be added to the cart
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the size of the oversize array cart after trying to remove item from the cart.
   */
  public static int removeItem(String[] cart, String item, int size) {
    int presentSize = size;
    for (int i = 0; i < size; i++) {
      if (cart[i].equals(item)) {
        presentSize -= 1;
        for (int j = i; j < size - 1; j++) {
          cart[j] = cart[j + 1];
        }
        cart[size - 1] = null;
        return presentSize;
      }
    }
    return presentSize;
  }

  /**
   * Removes all items from a given cart
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the size of the cart after removing all its items.
   */
  public static int emptyCart(String[] cart, int size) {
    int presentSize = 0;
    for (int i = 0; i < size; i++) {
      if (cart[i] != null) {
        cart[i] = null;
      }
    }
    return presentSize;
  }

  /**
   * Returns a string representation of the summary of the contents of a given cart
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return a string representation of the summary of the contents of the cart.
   */
  public static String getCartSummary(String[] cart, int size) {
    String summary = "";
    if (size > 0) {
      String[] tempCart = new String[size];
      int tempSize = size;
      int index = 0;
      for (int j = 0; j < cart.length; j++) {
        if (cart[j] != null) {
          tempCart[index] = cart[j];
          index++;
        } else {
          continue;
        }
      }
      for (int i = 0; i < tempSize; i++) {
        String item = tempCart[i];
        int count = nbOccurrences(item, tempCart, tempSize);
        if (count < 2) {
          summary += "(" + count + ")" + " " + item + "\n";
        } else {
          summary += "(" + count + ")" + " " + item + "\n";
          for (int j = 0; j < count; j++) {
            tempSize = removeItem(tempCart, item, tempSize);
          }
          i--;
        }
      }
    }
    return summary;
  }
}
