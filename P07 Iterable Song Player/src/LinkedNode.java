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
/**
 * An instance of this class represents a single node within a doubly linked list.
 * 
 * @author Yancheng Zhu
 * @author Kenneth Zhang
 *
 */
public class LinkedNode<T> {
  private T data;
  private LinkedNode<T> prev;
  private LinkedNode<T> next;

  /**
   * Initializes a new node with the provided information. Throws IllegalArgumentException if data
   * is null.
   * 
   * @param prev node, which comes before this node in a doubly linked list
   * @param data data to be stored within this node
   * @param next node, which comes after this node in a doubly linked list
   */
  public LinkedNode(LinkedNode<T> prev, T data, LinkedNode<T> next) {
    if (data == null) {
      throw new IllegalArgumentException("data cannot be null");
    }
    this.prev = prev;
    this.data = data;
    this.next = next;
  }

  /**
   * Accessor method for this node's previous node reference.
   * 
   * @return the reference to the node that comes before this one in the list or null when this is
   *         the first node in that list
   */
  public LinkedNode<T> getPrev() {
    return this.prev;
  }

  /**
   * Mutator method for this node's previous node reference.
   * 
   * @param prev node, which comes before this node in a doubly linked list
   */
  public void setPrev​(LinkedNode<T> prev) {
    this.prev = prev;
  }

  /**
   * Accessor method for this node's next node reference.
   * 
   * @return the next reference to the node that comes after this one in the list, or null when this
   *         is the last node in that list
   */
  public LinkedNode<T> getNext() {
    return this.next;
  }

  /**
   * Mutator method for this node's next node reference.
   * 
   * @param next node, which comes after this node in a doubly linked list
   */
  public void setNext​(LinkedNode<T> next) {
    this.next = next;
  }

  /**
   * Accessor method for this node's data.
   * 
   * @return the data stored within this node.
   */
  public T getData() {
    return this.data;
  }

}
