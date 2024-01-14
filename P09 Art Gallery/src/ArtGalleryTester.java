//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Art Gallery
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
import java.util.ArrayList;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * ArtworkGallery.
 * 
 * @author Yancheng Zhu
 * @author Kenneth Zhang
 *
 */

public class ArtGalleryTester {

  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Artwork class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testArtworkCompareToEquals() {
    // TODO complete the implementation of this method
    Artwork a = new Artwork("Chaplin, Brainwash", 2020, 9090);
    Artwork b = new Artwork("Chaplin, Brainwash", 2020, 9090);
    if (!a.equals(b)) {
      return false;
    }
    Artwork c = new Artwork("Gothic, Wood", 1930, 6000);
    if (c.compareTo(a) >= 0) {
      return false;
    }
    Artwork d = new Artwork("Gothic, Wood", 1930, 6001);
    if (c.compareTo(d) >= 0) {
      return false;
    }
    if (a.equals(c)) {
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of the implementation of both addArtwork() and toString() methods
   * implemented in the ArtworkGallery class. This unit test considers at least the following
   * scenarios. (1) Create a new empty ArtworkGallery, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one artwork and then
   * check that the addArtwork() method call returns true, the tree is not empty, its size is 1, and
   * the .toString() called on the tree returns the expected output. (3) Try adding another artwork
   * which is smaller than the artwork at the root, (4) Try adding a third artwork which is greater
   * than the one at the root, (5) Try adding at least two further artwork such that one must be
   * added at the left subtree, and the other at the right subtree. For all the above scenarios, and
   * more, double check each time that size() method returns the expected value, the add method call
   * returns true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * artwork with respect to year, cost, and then name. (6) Try adding a artwork already stored in
   * the tree. Make sure that the addArtwork() method call returned false, and that the size of the
   * tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddArtworkToStringSize() {
    // TODO complete the implementation of this method
    ArtGallery AG = new ArtGallery();
    if (AG.size() != 0) {
      return false;
    }
    if (!AG.isEmpty()) {
      return false;
    }
    if (!(AG.toString().equals(""))) {
      return false;
    }
    boolean test = AG.addArtwork(new Artwork("Gothic, Wood", 1930, 6000));
    if (!test || AG.isEmpty() || AG.size() != 1) {
      return false;
    }
    if (!AG.toString().equals("[(Name: Gothic, Wood) (Year: 1930) (Cost: $6000.0)]")) {
      return false;
    }
    test = AG.addArtwork(new Artwork("Mona Lisa, DaVinci", 1503, 1000));
    if (!test || AG.size() != 2) {
      return false;
    }
    if (!AG.toString().equals("[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]\n"
        + "[(Name: Gothic, Wood) (Year: 1930) (Cost: $6000.0)]")) {
      return false;
    }
    test = AG.addArtwork(new Artwork("NightHawks, Hopper", 1942, 4000));
    if (!test || AG.size() != 3) {
      return false;
    }
    if (!AG.toString()
        .equals("[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]\n"
            + "[(Name: Gothic, Wood) (Year: 1930) (Cost: $6000.0)]\n"
            + "[(Name: NightHawks, Hopper) (Year: 1942) (Cost: $4000.0)]")) {
      return false;
    }
    test = AG.addArtwork(new Artwork("Whistler, Abbott", 1871, 5000));
    if (!test || AG.size() != 4) {
      return false;
    }
    if (!AG.toString()
        .equals("[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]\n"
            + "[(Name: Whistler, Abbott) (Year: 1871) (Cost: $5000.0)]\n"
            + "[(Name: Gothic, Wood) (Year: 1930) (Cost: $6000.0)]\n"
            + "[(Name: NightHawks, Hopper) (Year: 1942) (Cost: $4000.0)]")) {
      return false;
    }
    test = AG.addArtwork(new Artwork("Guernica, Picasso", 1937, 3000));
    if (!test || AG.size() != 5) {
      return false;
    }
    if (!AG.toString()
        .equals("[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]\n"
            + "[(Name: Whistler, Abbott) (Year: 1871) (Cost: $5000.0)]\n"
            + "[(Name: Gothic, Wood) (Year: 1930) (Cost: $6000.0)]\n"
            + "[(Name: Guernica, Picasso) (Year: 1937) (Cost: $3000.0)]\n"
            + "[(Name: NightHawks, Hopper) (Year: 1942) (Cost: $4000.0)]")) {
      return false;
    }
    test = AG.addArtwork(new Artwork("Guernica, Picasso", 1937, 3000));
    if (test || AG.size() != 5) {
      return false;
    }
    if (!AG.toString()
        .equals("[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]\n"
            + "[(Name: Whistler, Abbott) (Year: 1871) (Cost: $5000.0)]\n"
            + "[(Name: Gothic, Wood) (Year: 1930) (Cost: $6000.0)]\n"
            + "[(Name: Guernica, Picasso) (Year: 1937) (Cost: $3000.0)]\n"
            + "[(Name: NightHawks, Hopper) (Year: 1942) (Cost: $4000.0)]")) {
      return false;
    }

    return true;
  }

  /**
   * This method checks mainly for the correctness of the ArtworkGallery.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ArtworkGallery. Then, check
   * that calling the lookup() method on an empty ArtworkGallery returns false. (2) Consider a
   * ArtworkGallery of height 3 which lookup at least 5 artwork. Then, try to call lookup() method
   * to search for the artwork having a match at the root of the tree. (3) Then, search for a
   * artwork at the right and left subtrees at different levels considering successful and
   * unsuccessful search operations. Make sure that the lookup() method returns the expected output
   * for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    // TODO complete the implementation of this method
    {
      // TODO complete the implementation of this method
      ArtGallery test = new ArtGallery();
      if (test.lookup("A", 2002, 100)) {
        return false;
      }
      test.addArtwork(new Artwork("NightHawks, Hopper", 1942, 4000));
      test.addArtwork(new Artwork("Mona Lisa, DaVinci", 1503, 1000));
      test.addArtwork(new Artwork("Whistler, Abbott", 1871, 5000));
      test.addArtwork(new Artwork("Amazone, Tsalapatanis", 2021, 6080));
      test.addArtwork(new Artwork("Der Schrei, Silber", 2019, 12160));
      if (!test.lookup("NightHawks, Hopper", 1942, 4000)) {
        return false;
      }
      if (!test.lookup("Der Schrei, Silber", 2019, 12160)) {
        return false;
      }
      if (!test.lookup("Mona Lisa, DaVinci", 1503, 1000)) {
        return false;
      }
      if (!test.lookup("Whistler, Abbott", 1871, 5000)) {
        return false;
      }
      return true;
    }
  }

  /**
   * Checks for the correctness of ArtworkGallery.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty artwork tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ArtworkGallery with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*)
   * (*) / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    // TODO complete the implementation of this method
    ArtGallery test = new ArtGallery();
    if (test.height() != 0) {
      return false;
    }
    test.addArtwork(new Artwork("NightHawks, Hopper", 1942, 4000));
    if (test.height() != 1) {
      return false;
    }
    test.addArtwork(new Artwork("Mona Lisa, DaVinci", 1503, 1000));
    test.addArtwork(new Artwork("Whistler, Abbott", 1871, 5000));
    test.addArtwork(new Artwork("Chaplin, Brainwash", 2020, 9090));
    test.addArtwork(new Artwork("Der Schrei, Silber", 2019, 12160));
    test.addArtwork(new Artwork("Amazone, Tsalapatanis", 2022, 6080));
    test.addArtwork(new Artwork("Aba, Tsalapatanis", 2021, 6080));
    if (test.height() != 4) {
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of ArtworkGallery.getBestArtwork() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestArtwork() {
    // TODO complete the implementation of this method
    return true; // Default return statement added to resolve compiler errors
  }


  /**
   * Checks for the correctness of ArtworkGallery.lookupAll() method. This test must consider at
   * least 3 test scenarios. (1) Ensures that the ArtworkGallery.lookupAll() method returns an empty
   * arraylist when called on an empty tree. (2) Ensures that the ArtworkGallery.lookupAll() method
   * returns an array list which contains all the artwork satisfying the search criteria of year and
   * cost, when called on a non empty artwork tree with one match, and two matches and more. Vary
   * your search criteria such that the lookupAll() method must check in left and right subtrees.
   * (3) Ensures that the ArtworkGallery.lookupAll() method returns an empty arraylist when called
   * on a non-empty artwork tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookupAll() {
    // TODO complete the implementation of this method
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.buyArtwork() method. This test must consider at
   * least 3 test scenarios. (1) Buying artwork that is at leaf node (2) Buying artwork at non-leaf
   * node (3) ensures that the ArtworkGallery.buyArtwork() method throws a NoSuchElementException
   * when called on an artwork that is not present in the BST
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBuyArtwork() {
    // TODO complete the implementation of this method
    ArtGallery gallery = new ArtGallery();
    Artwork root = new Artwork("Starry Night, Van Gogh", 1889, 2000.0);
    Artwork art1 = new Artwork("Mona Lisa, DaVinci", 1503, 1000.0);
    Artwork art2 = new Artwork("Whistler, Abbott", 1871, 5000.0);
    Artwork art3 = new Artwork("Gothic, Wood", 1871, 6000.0);
    Artwork art4 = new Artwork("Shunjie,Zhu", 2022, 10000.0);
    Artwork art5 = new Artwork("Weiwei", 2022, 15000.0);
    Artwork art6 = new Artwork("114515", 2022, 8000.0);
    Artwork art7 = new Artwork("I have a dream, Xixi", 1888, 8000.0);
    Artwork art8 = new Artwork("请叫我靓仔, lala", 1999, 8000.0);


    gallery.addArtwork(root);
    gallery.addArtwork(art1);
    gallery.addArtwork(art2);
    gallery.addArtwork(art3);
    gallery.addArtwork(art4);
    gallery.addArtwork(art5);
    gallery.addArtwork(art6);

    // Test 1, test if ArtworkGallery.buyArtwork() method return the correct output when
    // buying artwork that is at leaf node
    gallery.buyArtwork("Weiwei", 2022, 15000.0);
    System.out.println(gallery.toString());
    if (!gallery.toString()
        .equals("[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]\n"
            + "[(Name: Whistler, Abbott) (Year: 1871) (Cost: $5000.0)]\n"
            + "[(Name: Gothic, Wood) (Year: 1871) (Cost: $6000.0)]\n"
            + "[(Name: Starry Night, Van Gogh) (Year: 1889) (Cost: $2000.0)]\n"
            + "[(Name: 114515) (Year: 2022) (Cost: $8000.0)]\n"
            + "[(Name: Shunjie,Zhu) (Year: 2022) (Cost: $10000.0)]")) {
      System.out.println("Problem detected: Your test case 1 buyArtwork() method "
          + "failed to return the expected boolean output.");
      return false;
    }

    // Test 2, test if ArtworkGallery.buyArtwork() method return the correct output when
    // Buying artwork which is the root
    gallery.buyArtwork("Starry Night, Van Gogh", 1889, 2000.0);
    if (!gallery.toString()
        .equals("[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]\n"
            + "[(Name: Whistler, Abbott) (Year: 1871) (Cost: $5000.0)]\n"
            + "[(Name: Gothic, Wood) (Year: 1871) (Cost: $6000.0)]\n"
            + "[(Name: 114515) (Year: 2022) (Cost: $8000.0)]\n"
            + "[(Name: Shunjie,Zhu) (Year: 2022) (Cost: $10000.0)]")) {
      System.out.println("Problem detected: Your test case 2 buyArtwork() method "
          + "failed to return the expected boolean output.");
      return false;
    }

    // Test 3, test if ArtworkGallery.buyArtwork() method return the correct output when
    // Buying artwork at non-leaf node
    gallery.addArtwork(art7);
    gallery.addArtwork(art8);
    gallery.buyArtwork("Whistler, Abbott", 1871, 5000.0);
    if (!gallery.toString()
        .equals("[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]\n"
            + "[(Name: Gothic, Wood) (Year: 1871) (Cost: $6000.0)]\n"
            + "[(Name: I have a dream, Xixi) (Year: 1888) (Cost: $8000.0)]\n"
            + "[(Name: 请叫我靓仔, lala) (Year: 1999) (Cost: $8000.0)]\n"
            + "[(Name: 114515) (Year: 2022) (Cost: $8000.0)]\n"
            + "[(Name: Shunjie,Zhu) (Year: 2022) (Cost: $10000.0)]")) {
      System.out.println("Problem detected: Your test case 3 buyArtwork() method "
          + "failed to return the expected boolean output.");
      return false;
    }

    // Test4, test if ArtworkGallery.buyArtwork() method throws a NoSuchElementException
    // when called on an artwork that is not present in the BST
    try {
      gallery.buyArtwork("Starry Night, Van Gogh", 1889, 2000.0);
      if (!gallery.toString()
          .equals("[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]\n"
              + "[(Name: Whistler, Abbott) (Year: 1871) (Cost: $5000.0)]\n"
              + "[(Name: Gothic, Wood) (Year: 1871) (Cost: $6000.0)]\n"
              + "[(Name: 114515) (Year: 2022) (Cost: $8000.0)]\n"
              + "[(Name: Shunjie,Zhu) (Year: 2022) (Cost: $10000.0)]")) {
        System.out.println("Problem detected: Your test case 4 buyArtwork() method "
            + "failed to return the expected boolean output.");
        return false;
      }
    } catch (NoSuchElementException e) {
      e.getMessage();
    } catch (Exception e1) {
      System.out.println("Problem detected: Your test case 4 buyArtwork() method "
          + "throws an unexpected Exception.");
      return false;
    }
    return true;
  }

  /**
   * Returns false if any of the tester methods defined in this tester class fails.
   * 
   * @return false if any of the tester methods defined in this tester class fails, and true if all
   *         tests pass
   */
  public static boolean runAllTests() {
    // TODO complete the implementation of this method
    if (!testArtworkCompareToEquals() || !testAddArtworkToStringSize() || !testLookup()
        || !testHeight() || !testGetBestArtwork() || !testLookupAll() || !testBuyArtwork()) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {

    System.out.println("testArworkCompareToEquals(): " + testArtworkCompareToEquals());
    System.out.println("testAddArtworkToStringSize(): " + testAddArtworkToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testGetBestArtwork(): " + testGetBestArtwork());
    System.out.println("testLookupAll(): " + testLookupAll());
    System.out.println("testBuyArtwork(): " + testBuyArtwork());
    System.out.println("runAllTests(): " + runAllTests());


  }

}
