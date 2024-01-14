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
 * 
 * @author zihuatanejo
 *
 */
public class ForwardSongIterator implements Iterator<Song> {
  private LinkedNode<Song> next;

  /**
   * 
   * @param first
   */
  public ForwardSongIterator(LinkedNode<Song> first) {
    this.next = first;
  }

  /**
   * 
   * @return
   */
  @Override
  public boolean hasNext() {
    if (this.next != null) {
      return true;
    }
    return false;
  }

  /**
   * 
   * @return
   */
  @Override
  public Song next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException("No more songs to return");
    }
    Song retSong = next.getData();
    this.next = next.getNext();
    return retSong;
  }

}
