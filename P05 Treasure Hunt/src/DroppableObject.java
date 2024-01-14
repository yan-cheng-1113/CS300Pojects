//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Treasure Hunt
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
 * This class contains a few methods related to the Droppable Object.
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (YANCHENG ZHU, KENNETH ZHANG)
 */
public class DroppableObject extends DraggableObject {
  private InteractiveObject target;

  /**
   * Creates a new Droppable object with specific name, x and y positions, message, target, 
   * and sets its next clue.
   * 
   * @param name     name to be assigned to this droppable object
   * @param x        x-position of this droppable object
   * @param y        y-position this droppable object
   * @param message  message to be assigned to this droppable object
   * @param target   target where this droppable object should be dropped
   * @param nextClue reference to an interactive object which will be activated when this 
   *                 droppable object is dropped on its target.
   * 
   * 
   */
  public DroppableObject(String name, int x, int y, String message, InteractiveObject target,
      InteractiveObject nextClue) {
    super(name, x, y, message);
    this.target = target;
    this.setNextClue​(nextClue);
  }

  /**
   * Stops dragging this droppable object. Also, if this droppable object is over its target and 
   * the target is activated, this method (1) deactivates both this object and its target, (2) 
   * activates the next clue, and (3) prints the message of this draggable object to the console.
   * 
   */
  @Override
  public void mouseReleased() {
    super.stopDragging();
    if (this.isOver​(this.target) && this.target.isActive()) {
      this.deactivate();
      this.target.deactivate();
      this.activateNextClue();
      System.out.println(this.message());
    }

  }

  /**
   * Checks whether this object is over another interactive object.
   * 
   * @param  other reference to another iteractive object. We assume that other is NOT null.
   * 
   * @return true if this droppable object and other overlap and false otherwise.
   */
  public boolean isOver​(InteractiveObject other) {
    if (this.getX() + this.image.width < other.getX()
        || this.getX() > other.getX() + other.image.width
        || this.getY() + this.image.height < other.getY()
        || this.getY() > other.getY() + other.image.height) {
      return false;
    }
    return true;
  }

}
