//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 DNA
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
import java.util.NoSuchElementException;

/**
 * A generic implementation of a linked queue
 * 
 * @author Yancheng Zhu
 *
 * @param <T> The type of data to be contained in the queue
 * 
 */
public class LinkedQueue<T> implements QueueADT<T> {

  protected Node<T> back;
  protected Node<T> front;
  private int n;

  /**
   * Adds the given data to this queue; every addition to a queue is made at the back
   * 
   * @param string the data to add
   */
  public void enqueue(T data) {
    if (this.front == null) {
      this.front = new Node<T>(data);
      this.back = this.front;
    } else {
      Node<T> rear = new Node<T>(data);
      back.setNext(rear);
      back = back.getNext();
    }
    n++;
  }

  /**
   * Removes and returns the item from this queue that was least recently added, throws
   * NoSuchElementException if this queue is empty
   * 
   * @return the item from this queue that was least recently added
   */
  public T dequeue() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("The queue is empty");
    }
    Node<T> ret = this.front;
    this.front = front.getNext();
    n--;
    return ret.getData();
  }

  /**
   * Returns the item least recently added to this queue without removing it, throws
   * NoSuchElementException if this queue is empty
   * 
   * @return the item least recently added to this queue
   */
  public T peek() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("The queue is empty");
    }
    return this.front.getData();
  }

  /**
   * Checks whether the queue contains any elements
   * 
   * @return true if this queue is empty; false otherwise
   */
  public boolean isEmpty() {
    if (front == null) {
      return true;
    }
    return false;
  }

  /**
   * Returns the number of items in this queue
   * 
   * @return the number of items in this queue
   */
  public int size() {
    // TODO Auto-generated method stub
    return this.n;
  }

  /**
   * Returns a string representation of this queue, beginning at the front (least recently added) of
   * the queue and ending at the back (most recently added). An empty queue is represented as an
   * empty string; otherwise items in the queue are represented using their data separated by spaces
   * 
   * @return the sequence of items in FIFO order, separated by spaces
   */
  @Override
  public String toString() {
    String ret = "";
    Node<T> forward = this.front;
    for (int i = 0; i < this.size(); i++) {
      ret += forward.getData() + " ";
      try {
        forward = forward.getNext();
      } catch (NullPointerException e) {
        return ret;
      }
    }
    return ret;
  }

}
