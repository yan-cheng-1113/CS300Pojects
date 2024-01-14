//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Open Position
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
 * Array-based heap implementation of a priority queue containing Applications. Guarantees the
 * min-heap invariant, so that the Application at the root should have the lowest score, and
 * children always have a higher or equal score as their parent. The root of a non-empty queue is
 * always at index 0 of this array-heap.
 */
public class ApplicationQueue implements PriorityQueueADT<Application>, Iterable<Application> {
  private Application[] queue; // array min-heap of applications representing this priority queue
  private int size; // size of this priority queue

  /**
   * Creates a new empty ApplicationQueue with the given capacity
   * 
   * @param capacity Capacity of this ApplicationQueue
   * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
   *                                  positive integer
   */
  public ApplicationQueue(int capacity) {
    // TODO verify the capacity
    if (capacity <= 0) {
      throw new IllegalArgumentException("Invalid capacity");
    }

    // TODO initialize fields appropriately
    this.queue = new Application[capacity];
    this.size = 0;

  }

  /**
   * Checks whether this ApplicationQueue is empty
   * 
   * @return {@code true} if this ApplicationQueue is empty
   */
  @Override
  public boolean isEmpty() {
    if (this.size == 0) {
      return true;
    }
    return false;
  }

  /**
   * Returns the size of this ApplicationQueue
   * 
   * @return the size of this ApplicationQueue
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * Adds the given Application to this ApplicationQueue and use the percolateUp() method to
   * maintain min-heap invariant of ApplicationQueue. Application should be compared using the
   * Application.compareTo() method.
   * 
   * 
   * @param o Application to add to this ApplicationQueue
   * @throws NullPointerException  if the given Application is null
   * @throws IllegalStateException with a descriptive error message if this ApplicationQueue is full
   */
  @Override
  public void enqueue(Application o) {
    // TODO verify the application
    if (o == null) {
      throw new NullPointerException("Application is null");
    }
    // TODO verify that the queue is not full
    if (this.size == this.queue.length) {
      throw new IllegalStateException("The queue is full");
    }
    // TODO if allowed, add the application to the queue and percolate to restore the heap condition
    this.queue[size] = o;
    percolateUp(size);
    this.size++;
  }

  /**
   * Removes and returns the Application at the root of this ApplicationQueue, i.e. the Application
   * with the lowest score.
   * 
   * @return the Application in this ApplicationQueue with the smallest score
   * @throws NoSuchElementException with a descriptive error message if this ApplicationQueue is
   *                                empty
   */
  @Override
  public Application dequeue() {
    // TODO verify that the queue is not empty
    if (this.isEmpty()) {
      throw new NoSuchElementException("The queue is empty");
    }
    // TODO save the lowest-scoring application
    Application lowestScoring = this.queue[0];
    // TODO replace the root of the heap and percolate to restore the heap condition
    this.queue[0] = this.queue[size - 1];

    percolateDown(0); // TODO fix this argument

    this.size--;
    // TODO return the lowest-scoring application
    return lowestScoring; // TODO fix
  }

  /**
   * An implementation of percolateDown() method. Restores the min-heap invariant of a given subtree
   * by percolating its root down the tree. If the element at the given index does not violate the
   * min-heap invariant (it is due before its children), then this method does not modify the heap.
   * Otherwise, if there is a heap violation, then swap the element with the correct child and
   * continue percolating the element down the heap.
   * 
   * This method may be implemented recursively OR iteratively.
   * 
   * @param i index of the element in the heap to percolate downwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  private void percolateDown(int i) {
    // TODO implement the min-heap percolate down algorithm to modify the heap in place
    if (i < 0 || i >= queue.length) {
      throw new IndexOutOfBoundsException();
    }
    int leftIndex = 2 * i + 1;
    int rightIndex = 2 * i + 2;
    while (this.queue[leftIndex] != null) {
      int smallestIndex = leftIndex;
      if (this.queue[rightIndex] != null) {
        if (this.queue[leftIndex].compareTo(this.queue[rightIndex]) < 0) {
          smallestIndex = leftIndex;
        }
      }
      if (this.queue[smallestIndex].compareTo(this.queue[i]) < 0) {
        Application temp = this.queue[i];
        this.queue[i] = this.queue[smallestIndex];
        this.queue[smallestIndex] = temp;
      } else {
        break;
      }
    }
  }

  /**
   * An implementation of percolateUp() method. Restores the min-heap invariant of the tree by
   * percolating a leaf up the tree. If the element at the given index does not violate the min-heap
   * invariant (it occurs after its parent), then this method does not modify the heap. Otherwise,
   * if there is a heap violation, swap the element with its parent and continue percolating the
   * element up the heap.
   * 
   * This method may be implemented recursively OR iteratively.
   * 
   * Feel free to add private helper methods if you need them.
   * 
   * @param i index of the element in the heap to percolate upwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  private void percolateUp(int i) {
    // TODO implement the min-heap percolate up algorithm to modify the heap in place
    if (i < 0 || i >= queue.length) {
      throw new IndexOutOfBoundsException();
    }
    int parentIndex = (i - 1) / 2;
    while (this.queue[parentIndex] != null) {
      if (this.queue[parentIndex].compareTo(this.queue[i]) > 0) {
        Application temp = this.queue[parentIndex];
        this.queue[parentIndex] = this.queue[i];
        this.queue[i] = temp;
      } else {
        break;
      }
    }
  }

  /**
   * Returns the Application at the root of this ApplicationQueue, i.e. the Application with the
   * lowest score.
   * 
   * @return the Application in this ApplicationQueue with the smallest score
   * @throws NoSuchElementException if this ApplicationQueue is empty
   */
  @Override
  public Application peek() {
    // TODO verify that the queue is not empty
    if (this.isEmpty()) {
      throw new NoSuchElementException("The queue is empty");
    }

    Application tempApplication = this.queue[0];
    // TODO return the lowest-scoring application
    return tempApplication; // TODO fix
  }

  /**
   * Returns a deep copy of this ApplicationQueue containing all of its elements in the same order.
   * This method does not return the deepest copy, meaning that you do not need to duplicate
   * applications. Only the instance of the heap (including the array and its size) will be
   * duplicated.
   * 
   * @return a deep copy of this ApplicationQueue. The returned new application queue has the same
   *         length and size as this queue.
   */
  public ApplicationQueue deepCopy() {
    ApplicationQueue tempQueue = new ApplicationQueue(this.queue.length);
    for (int i = 0; i < this.size; ++i) {
      tempQueue.enqueue(this.queue[i]);
    }
    return tempQueue;
  }

  /**
   * Returns a String representing this ApplicationQueue, where each element (application) of the
   * queue is listed on a separate line, in order from the lowest score to the highest score.
   * 
   * This implementation is provided.
   * 
   * @see Application#toString()
   * @see ApplicationIterator
   * @return a String representing this ApplicationQueue
   */
  @Override
  public String toString() {
    StringBuilder val = new StringBuilder();

    for (Application a : this) {
      val.append(a).append("\n");
    }

    return val.toString();
  }

  /**
   * Returns an Iterator for this ApplicationQueue which proceeds from the lowest-scored to the
   * highest-scored Application in the queue.
   * 
   * This implementation is provided.
   * 
   * @see ApplicationIterator
   * @return an Iterator for this ApplicationQueue
   */
  @Override
  public Iterator<Application> iterator() {
    return new ApplicationIterator(this);
  }
}
