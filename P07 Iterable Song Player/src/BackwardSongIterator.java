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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterator to play songs in the reverse backward direction from a doubly
 * linked list of songs.
 * 
 * @author Yancheng Zhu
 * @author Kenneth Zhang
 *
 */
public class BackwardSongIterator implements Iterator<Song> {
  private LinkedNode<Song> next;

  /**
   * Creates a new iterator which iterates through songs in back/tail to front/head order
   * 
   * @param last reference to the tail of a doubly linked list of songs
   */
  public BackwardSongIterator(LinkedNode<Song> last) {

    this.next = last;

  }

  /**
   * Checks whether there are more songs to return in the reverse order
   * 
   * @return true if there are more songs to return in the reverse order
   */
  @Override
  public boolean hasNext() {
    if (next != null) {
      return true;
    }
    return false;
  }

  /**
   * Returns the next song in the iteration. Throws NoSuchElementException if there are no more
   * songs to return in the reverse order
   * 
   * @return the next song in the iteration
   */
  @Override
  public Song next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException("No more songs to return");
    }
    Song returnSong = next.getData();
    this.next = next.getPrev();
    return returnSong;
  }

}
