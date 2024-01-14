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
 * This class contains a few methods related to the Draggable Object.
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (YANCHENG ZHU, KENNETH ZHANG)
 */
public class DraggableObject extends InteractiveObject {
  private boolean isDragging;
  private int oldMouseX;
  private int oldMouseY;

  /**
   * Creates a new Draggable object with a given name, x and y position, and "Drag Me!" as a default
   * message. When created a new draggable object is NOT dragging.
   * 
   * @param name name to be assigned to this draggable object
   * @param x    x-position of this draggable object in the display window
   * @param y    y-position of this draggable object in the display window
   * 
   */
  public DraggableObject(String name, int x, int y) {
    super(name, x, y, "Drag Me!");
    this.isDragging = false;
  }

  /**
   * Creates a new Draggable object with a given name, x and y position, and a specific message.
   * When created a new draggable object is NOT dragging.
   * 
   * @param name    name to be assigned to this draggable object
   * @param x       x-position of this draggable object in the display window
   * @param y       y-position of this draggable object in the display window
   * @param message message to be displayed when this draggable object is clicked. We assume that
   *                message is VALID (meaning it is NOT null and NOT an empty string).
   * 
   */
  public DraggableObject(String name, int x, int y, String message) {
    super(name, x, y, message);
    this.isDragging = false;
  }

  /**
   * Checks whether this draggable object is being dragged.
   * 
   * @return
   */
  public boolean isDragging() {
    return this.isDragging;
  }

  /**
   * Starts dragging this draggable object and updates the oldMouseX and oldMouseY positions to the
   * current position of the mouse.
   */
  public void startDragging() {
    this.isDragging = true;
    this.oldMouseX = super.processing.mouseX;
    this.oldMouseY = super.processing.mouseY;
  }

  /**
   * Stops dragging this draggable object.
   */
  public void stopDragging() {
    this.isDragging = false;
    // this.oldMouseX = super.processing.mouseX;
    // this.oldMouseY = super.processing.mouseY;
  }

  /**
   * Draws this draggable object to the display window. If this object is dragging, this method sets
   * its position to follow the mouse moves. Then, it draws its image to the its current position.
   */
  @Override
  public void draw() {
    if (this.isDragging) {
      super.move​(super.processing.mouseX - this.oldMouseX,
          super.processing.mouseY - this.oldMouseY);
      super.processing.image(image, oldMouseX, oldMouseY);
      this.oldMouseX = super.processing.mouseX;
      this.oldMouseY = super.processing.mouseY;
    } else {
      super.draw();
    }

  }

  /**
   * Starts dragging this object when it is clicked (meaning when the mouse is over it).
   */
  @Override
  public void mousePressed() {
    if (super.isMouseOver()) {
      this.startDragging();
    }
  }

  /**
   * Stops dragging this object if the mouse is released.
   */
  @Override
  public void mouseReleased() {
    if (!super.isMouseOver()) {
      this.stopDragging();
    }
  }
}
