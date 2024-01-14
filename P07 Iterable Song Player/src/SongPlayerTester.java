//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Iterable Song Player
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
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 *
 */
public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method, overridden
   * method toString() and equal() method defined in the Song class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {
    Song song = new Song("Brandy", "Lurie and Elliot", "3:06");
    if (!(song.getSongName().equals("Brandy"))) {
      return false;
    }

    if (!(song.getArtist().equals("Lurie and Elliot"))) {
      return false;
    }

    if (!(song.getDuration().equals("3:06"))) {
      return false;
    }

    String expected = "Brandy---Lurie and Elliot---3:06";
    if (!(song.toString().equals(expected))) {
      return false;
    }

    Song otherSong = new Song("Mojito", "Jay Chou", "3:05");
    if (song.equals(otherSong) == true) {
      return false;
    }

    return true;
  }

  /**
   * This method test and make use of the LinkedNode constructor, an accessor (getter) method, and a
   * mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {
    Song headSong = new Song("LongJv", "Zhen Ding", "2:50");
    Song curSong = new Song("ChunZhenLiTang", "Zhen Ding", "6:66");
    Song thirdSong = new Song("KKK", "ZZZ", "1:00");

    LinkedNode<Song> head = new LinkedNode<Song>(null, headSong, null);
    LinkedNode<Song> curNode = new LinkedNode<Song>(head, curSong, null);
    LinkedNode<Song> thirdNode = new LinkedNode<Song>(null, thirdSong, null);
    head.setNext​(curNode);
    curNode.setNext​(thirdNode);
    thirdNode.setPrev​(curNode);

    if (!(curNode.getPrev().getData().equals(headSong))) {
      return false;
    }

    if (!(head.getNext().getData().equals(curSong))) {
      return false;
    }

    if (!(curNode.getNext().getData().equals(thirdSong))) {
      return false;
    }

    try {
      LinkedNode<Song> testNode = new LinkedNode<Song>(null, null, null);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd() {
    Song headSong = new Song("LongJv", "Zhen Ding", "2:50");
    Song curSong = new Song("ChunZhenLiTang", "Zhen Ding", "6:66");
    Song jay = new Song("Mojito", "Jay Chou", "3:05");

    LinkedNode<Song> head = new LinkedNode<Song>(null, headSong, null);
    LinkedNode<Song> curNode = new LinkedNode<Song>(head, curSong, null);
    head.setNext​(curNode);

    Song addedSong = new Song("CSGO", "Zhen Ding", "2:50");
    SongPlayer sp = new SongPlayer();
    sp.addLast(addedSong);
    sp.addFirst​(curSong);
    sp.addFirst​(headSong);
    sp.add​(1, jay);

    if (!(sp.get(1).equals(jay))) {
      return false;
    }
    if (sp.size() != 4) {
      return false;
    }


    if (!(sp.getFirst().equals(headSong))) {
      return false;
    }

    try {
      sp.addFirst​(null);
      return false;
    } catch (NullPointerException e) {

    } catch (Exception e) {
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of getFirst(), getLast() and get(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerGet() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst​(new Song("Dragon Fist", "Jay Chou", "4:32"));
    songList.addLast(new Song("Save Your Tears", "The Weeknd", "3:35"));
    songList.add​(1, new Song("Simple Love", "Jay Chou", "4:30"));

    // Test 1, test it will throws NoSuchElementException in getFirst() and getLast()
    SongPlayer songList1 = new SongPlayer();
    try {
      songList1.getFirst();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }

    try {
      songList1.getLast();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }

    // Test 2, test it will throws IndexOutOfBoundsException in get(index) method
    try {
      songList.get(7);
      return false;
    } catch (IndexOutOfBoundsException i) {

    } catch (Exception e) {
      return false;
    }

    // Test 3, test the correctness of the getFirst()
    try {
      Song expectSong1 = new Song("Dragon Fist", "Jay Chou", "4:32");
      if (!songList.getFirst().equals(expectSong1)) {
        return false;
      }
    } catch (NoSuchElementException i) {
      return false;
    } catch (Exception e) {
      return false;
    }


    // Test 4, test the correctness of the getLast()
    try {
      Song expectSong2 = new Song("Save Your Tears", "The Weeknd", "3:35");
      if (!songList.getLast().equals(expectSong2)) {
        return false;
      }
    } catch (NoSuchElementException i) {
      return false;
    } catch (Exception e) {
      return false;
    }

    // Test 5, test the correctness of the get()
    try {
      Song expectSong3 = new Song("Simple Love", "Jay Chou", "4:30");
      if (!songList.get(1).equals(expectSong3)) {
        return false;
      }
    } catch (IndexOutOfBoundsException i) {
      return false;
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {

    Song headSong = new Song("LongJv", "Zhen Ding", "2:50");
    Song curSong = new Song("ChunZhenLiTang", "Zhen Ding", "6:66");
    Song thirdSong = new Song("KKK", "ZZZ", "1:00");

    SongPlayer sp = new SongPlayer();
    sp.addFirst​(headSong);
    sp.addLast(curSong);
    sp.addLast(thirdSong);
    SongPlayer test = new SongPlayer();

    if (!(sp.removeFirst().equals(headSong))) {
      return false;
    }

    if (!(sp.remove​(1).equals(thirdSong))) {
      return false;
    }

    if (!(sp.removeLast().equals(curSong))) {
      return false;
    }
    try {
      test.removeFirst();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      test.removeLast();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      sp.remove​(-1);
      return false;
    } catch (IndexOutOfBoundsException e) {

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of iterator(), switchPlayingDirection() and String
   * play() method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerIterator() {
    SongPlayer songList = new SongPlayer();
    Song first = new Song("Mojito", "Jay Chou", "3:05");
    Song second = new Song("Secret", "Jay Chou", "4:56");
    Song third = new Song("Superman Can’t Fly", "Jay Chou", "4:59");
    songList.addFirst​(first);
    songList.addLast(second);
    songList.add​(2, third);
    LinkedNode<Song> head = new LinkedNode<Song>(null, first, null);
    LinkedNode<Song> mid = new LinkedNode<Song>(head, second, null);
    LinkedNode<Song> tail = new LinkedNode<Song>(mid, third, null);

    ForwardSongIterator fwd = (ForwardSongIterator) songList.iterator();
    String expected = "Mojito---Jay Chou---3:05\n" + "Secret---Jay Chou---4:56\n"
        + "Superman Can’t Fly---Jay Chou---4:59\n";
    if (songList.play().equals(expected)) {
      return false;
    }
    if (!fwd.next().getSongName().equals("Mojito")) {
      return false;
    }
    songList.switchPlayingDirection();
    BackwardSongIterator bwd = (BackwardSongIterator) songList.iterator();
    expected = "Superman Can’t Fly---Jay Chou---4:59\n" + "Secret---Jay Chou---4:56\n"
        + "Mojito---Jay Chou---3:05\n";
    if (songList.play().equals(expected)) {
      return false;
    }
    if (!bwd.next().getSongName().equals("Superman Can’t Fly")) {
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of contains(Object song), clear(), isEmpty()and size()
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerCommonMethod() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addFirst​(new Song("Secret", "Jay Chou", "4:56"));
    songList.addFirst​(new Song("Clear Day", "Jay Chou", "4:59"));
    songList.addFirst​(new Song("Dragon Fist", "Jay Chou", "4:32"));
    songList.addFirst​(new Song("Superman Can’t Fly", "Jay Chou", "4:59"));
    songList.addLast(new Song("Save Your Tears", "The Weeknd", "3:35"));
    songList.add​(1, new Song("Simple Love", "Jay Chou", "4:30"));

    // Test 1: test the correctness of contains() method;
    if (!songList.contains​(new Song("Mojito", "Jay Chou", "3:05"))) {
      System.out.println("The contains() method1 does not return the expected output");
      return false;
    }

    if (songList.contains​(new Song("dd", "Jay Chou", "3:05"))) {
      System.out.println("The contains() method2 does not return the expected output");
      return false;
    }

    // Test 2: test the correctness of clear() method
    SongPlayer songList2 = new SongPlayer();
    songList2.addFirst​(new Song("Dragon Fist", "Jay Chou", "4:32"));
    songList2.addLast(new Song("Save Your Tears", "The Weeknd", "3:35"));
    songList2.add​(1, new Song("Simple Love", "Jay Chou", "4:30"));

    songList2.clear();
    if (songList2.size() != 0) {
      System.out.print("The clear() method does not return the expected output");
      return false;
    }

    // Test 3: test the correctness of isEmpty() method
    if (songList2.isEmpty() != true) {
      System.out.print("The isEmpty() method1 does not return the expected output");
      return false;
    }

    if (songList.isEmpty() != false) {
      System.out.print("The isEmpty() method2 does not return the expected output");
      return false;
    }

    // Test 4: test the correctness of size() method
    if (songList.size() != 7) {
      System.out.print("The size() method does not return the expected output");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of ForwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {
    Song headSong = new Song("LongJv", "Zhen Ding", "2:50");
    Song curSong = new Song("ChunZhenLiTang", "Zhen Ding", "6:66");
    LinkedNode<Song> head = new LinkedNode<Song>(null, headSong, null);
    LinkedNode<Song> curNode = new LinkedNode<Song>(head, curSong, null);
    head.setNext​(curNode);

    ForwardSongIterator fwIterator = new ForwardSongIterator(head);

    if (fwIterator.hasNext() == false) {
      return false;
    }

    Song fwNext = fwIterator.next();
    if (!(fwNext.getSongName().equals("LongJv"))) {
      return false;
    }

    ForwardSongIterator fwIterator2 = new ForwardSongIterator(curNode.getNext());
    try {
      fwIterator2.next();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }

    return true;
  }


  /**
   * This method checks for the correctness of BackwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBackwardSongIterator() {
    Song headSong = new Song("LongJv", "Zhen Ding", "2:50");
    Song curSong = new Song("ChunZhenLiTang", "Zhen Ding", "6:66");
    LinkedNode<Song> head = new LinkedNode<Song>(null, headSong, null);
    LinkedNode<Song> tail = new LinkedNode<Song>(head, curSong, null);

    BackwardSongIterator bwd = new BackwardSongIterator(tail);
    if (!bwd.hasNext()) {
      return false;
    }
    if (bwd.next().getSongName().equals("Longjv")) {
      return false;
    }
    BackwardSongIterator bwd2 = new BackwardSongIterator(head);
    try {
      bwd2.next();
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * This method calls all the test methods defined and implemented in your SongPlayerTester class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    return testSong() && testLinkedNode() && testForwardSongIterator() && testSongPlayerAdd()
        && testSongPlayerRemove() && testSongPlayerGet() && testSongPlayerIterator()
        && testSongPlayerCommonMethod() && testBackwardSongIterator();
  }

  /**
   * Driver method defined in this SongPlayerTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }
}
