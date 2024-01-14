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
* This class models an iterable collection of songs. Songs can be played in the 
* forward or reverse order.
* <p>
* Bugs: (a list of bugs and other problems)
*
* @author (Kenneth ZHANG,Yancheng Zhu )
*/
public class SongPlayer implements Iterable<Song> {

  
  private int size; //size of the list
  private LinkedNode<Song> head; //head of this doubly linked list
  private LinkedNode<Song> tail; //tail of this doubly linked list
  private boolean playingBackward; //true if this song player is reading the list backward
  
  
  /**
   * Adds a Song as Last Song
   *
   * @param oneSong the song that is going to be added to the tail of this 
   *                doubly linked list of songs
   */
  public void addLast(Song oneSong) {
    if (this.head == null){
      LinkedNode<Song> newFirst = new LinkedNode<Song>(null,oneSong,null);
      this.head = newFirst;
      this.tail = newFirst;
      size ++;
    }
    else {
    LinkedNode<Song> newLast = new LinkedNode<Song>(this.tail,oneSong,null);
    this.tail.setNext​(newLast);
    this.tail = newLast;
    size ++;
    }
  }
  
  /**
   * add Song as First Song
   *
   * @param oneSong the song that is going to be added to the head of this 
   *                doubly linked list of songs
   */
  public void addFirst​(Song oneSong) {
    if (oneSong == null) {
      throw new NullPointerException("the song is null");
    }
    if (this.head == null){
      LinkedNode<Song> newFirst = new LinkedNode<Song>(null,oneSong,null);
      this.head = newFirst;
      this.tail = newFirst;
      size ++;
    }
    else {
    LinkedNode<Song> newFirst = new LinkedNode<Song>(null,oneSong,this.head);
    this.head.setPrev​(newFirst);
    this.head = newFirst;
    size ++;
    }
  }
  
  
  /**
   * adds Song at a given position/order within this collection of songs
   *
   * @param index  the given index where the new song will be added
   * @param oneSong the song that is going to be added
   *
   */
  public void add​(int index,Song oneSong) {
    if (oneSong == null) {
      throw new NullPointerException("the song is null");
    }
    
    if (index == this.size) {
      addLast(oneSong);
    }
    
    if (index == 0) {
      addFirst​(oneSong);
    }
    if (index < 0 || index > this.size  - 1) {
      throw new IndexOutOfBoundsException("index is not valid");
    }
    else {
    LinkedNode<Song> tempNode = head;
    for (int i = 0; i < index; ++i) {
      tempNode = tempNode.getNext();
    }
    LinkedNode<Song> added = new LinkedNode<Song>(tempNode.getPrev(), oneSong, tempNode);
    tempNode.setPrev​(added);
    tempNode.getPrev().getPrev().setNext​(added);
    size ++;
    }
    }
  
  /**
   *Returns the first Song in this list.
   *
   *@return the Song at the head of this list
   */
  public Song getFirst() {
    if (this.head == null) {
      throw new NoSuchElementException("The list is empty");
    }
    return this.head.getData();
  }
  
  /**
   *Returns the last Song in this list.
   *
   *@return the Song at the tail of this list
   */
  public Song getLast() {
    if (this.head == null) {
      throw new NoSuchElementException("The list is empty");
    }
    return this.tail.getData();
  }
  
  /**
   *Returns the song at the specified position in this list.
   *
   *
   *@param index  index of the song to return
   *@return the song at the specified position in this list
   */
  public Song get(int index) {
  
  if (index < 0 || index > this.size - 1) {
    throw new IndexOutOfBoundsException();
  }
  
  if (this.size == 1) {
    return getFirst();
  }
  else {
    LinkedNode<Song> tempNode = head;
    for (int i = 0; i < index; ++i) {
      tempNode = tempNode.getNext();
    }
    Song returnSong = tempNode.getData();
    return returnSong;
  }
  
  
  }
  
  /**
   *Removes and returns the first song from this list.
   *
   *@return the first song from this list
   */
  public Song removeFirst() {
    if (this.head == null) {
      throw new NoSuchElementException("The list is empty");
    }
    
    if (this.size == 1) {
      Song removeSong = this.head.getData();
      this.head = null;
      this.tail = null;
      this.size --;
      return removeSong;
    }
    else {
    Song removeSong = this.head.getData();
    this.head = this.head.getNext();
    this.head.setPrev​(null);
    this.size --;
    return removeSong;
    }
  }
  
  
  /**
   *Removes and returns the last song from this list.
   *
   *@return the last song from this list
   */
  public Song removeLast() {
    if (this.head == null) {
      throw new NoSuchElementException("The list is empty");
    }
    
    if (this.size == 1) {
      Song removeSong = this.tail.getData();
      this.head = null;
      this.tail = null;
      this.size --;
      return removeSong;
    }
    else {
    Song removeSong = this.tail.getData();
    this.tail = this.tail.getPrev();
    this.tail.setNext​(null);
    this.size --;
    return removeSong;
    }
  }
  
  /**
   *Removes the song at the specified position in this list and returns the song that was removed 
   *from the list. The order of precedence of the other songs in the list should not be modified.
   *
   *@param index  the index of the song to be removed
   *@return the song previously at the specified position
   */
  public Song remove​(int index) {
    if (index < 0 || index > this.size - 1) {
      throw new IndexOutOfBoundsException("index is not valid");
    }
    
    if (this.size == 1) {
      Song removeSong = this.head.getData();
      this.head = null;
      this.tail = null;
      this.size --;
      return removeSong;
    }
    
    if (index == 0) {
      return removeFirst();
    }
    
    if (index == this.size - 1) {
      return removeLast();
    }
    LinkedNode<Song> tempNode = head;
    for (int i = 0; i < index; ++i) {
      tempNode = tempNode.getNext();
    }
    Song returnSong = tempNode.getData();
    tempNode.getPrev().setNext​(tempNode.getNext());
    tempNode.getNext().setPrev​(tempNode.getPrev());
    this.size --;
    
    return returnSong;
  }
  
  /**
   *Returns true if this list contains a match with the specified song. More formally, returns true 
   *if and only if this list contains at least one song e such that Objects.equals(o, e).
   *
   *@param o  song whose presence in this list is to be tested
   *@return true if this list contains the specified song and false otherwise
   */
  public boolean contains​(Song o) {
    ForwardSongIterator fwIterator = new ForwardSongIterator(this.head);
    try {
      while(fwIterator.hasNext()) {
        Song curSong = fwIterator.next();
        if (curSong.equals(o)) {
          return true;
        }
      }
      
    }catch(NoSuchElementException e) {
      return false;
    }
    
    return false;
  }
  
  /**
   *Removes all of the songs from this list. The list will be empty after this call returns.
   *
   */
  public void clear() {
    LinkedNode<Song> tempNode;
    
    while(this.head != null) {
      tempNode = this.head;
      this.head = this.head.getNext();
      tempNode = null;
    }
    size = 0;
    
  }
  
  
  /**
   *Returns true if this list is empty.
   *
   *@return true if this list is empty and false otherwise
   */
  public boolean isEmpty() {
    if (this.head == null) {
      return true;
    }
    return false;
  }
  
  
  /**
   *Returns the number of songs in this list.
   *
   *@return  the number of songs in this list
   */
  public int size() {
    ForwardSongIterator fwIterator = new ForwardSongIterator(this.head);
    int curSize = 0;
    try {
      while(fwIterator.hasNext()) {
        curSize += 1;
        fwIterator.next();
      }
      
    }catch(NoSuchElementException e) {
      return curSize;
    }
    
    return curSize;
  }
  
  /**
   *Returns an iterator to iterate through the songs in this list with respect to current playing 
   *direction of this song player (either in the forward or in the backward direction)
   *
   *@return  an Iterator to traverse the list of songs in this SongPlayer with respect to the 
   *         current playing direction specified by the playingBackward data field.
   */
  @Override
  public java.util.Iterator<Song> iterator(){
    if (this.playingBackward == true) {
      return new BackwardSongIterator(this.tail);
    }
    else {
      return new ForwardSongIterator(this.head);
    }
  }
  
  /**
   * 
   *Mutator of the playingDirection of this song player. It switches the playing direction by 
   *setting playingBackward to its opposite value.
   *
   */
  public void switchPlayingDirection() {
    this.playingBackward = !this.playingBackward;
  }
  
  /**
   * 
   *Plays the songs in this song player in the current playing direction. 
   *This method MUST be implemented using an enhanced for-each loop.
   *
   *
   *@return a String representation of the songs in this song player. String representations of 
   *        each song are separated by a newline. If this song player is empty, this method 
   *        returns an empty string.
   */
  public java.lang.String play(){

      String songPlayed = "";
      for (Song node : this) {
       songPlayed += node.toString() + "\n";  
    }
      
      return songPlayed;
  }
  
  }
  

  

