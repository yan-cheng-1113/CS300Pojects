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
import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class contains a few methods related to the Interactive Object.
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (YANCHENG ZHU, KENNETH ZHANG)
 */
public class InteractiveObject implements Clickable {
  protected static TreasureHunt processing;
  private final String NAME;
  protected PImage image;
  private int x;
  private int y;
  private boolean isActive;
  private boolean wasClicked;
  private String message;
  private InteractiveObject nextClue;
  /**
   * Creates a new interactive object with no next clue (nextClue == null) and sets its image, name
   * , x and y positions, its message, and activation status. When created, an interactive object 
   * must be active, and not clicked yet.
   * 
   * @param name     name to be assigned to this interactive object. We assume that name is VALID 
   *                 (not null and not equal to an empty string)
   * @param x        x-position to be assigned to this interactive object
   * @param y        y-position to be assigned to this interactive object
   * @param message  message to be displayed on the console each time this interactive object is 
   *                 clicked. We assume that message is VALID (not null and not equal 
   *                 to an empty string)
   * 
   */
  public InteractiveObject(String name, int x, int y, String message) {
    this.NAME = name;
    this.x = x;
    this.y = y;
    this.message = message;
    this.image = processing.loadImage("images" + File.separator + name + ".png");
    this.isActive = true;
    this.wasClicked = false;
  }
  /**
   * Creates a new interactive object with a next clue (nextClue != null) to be activated when this 
   * interactive object is clicked for the first time. This constructor sets the image of the newly 
   * created interactive object, its name, x and y positions, its message, and activation status. 
   * When created, an interactive object must be active, and not clicked yet. Also, this constructor
   * deactivates the next clue of this interactive object.
   * 
   * @param name     name to be assigned to this interactive object. We assume that name is VALID 
   *                 (not null and not equal to an empty string)
   * @param x        x-position to be assigned to this interactive object
   * @param y        y-position to be assigned to this interactive object
   * @param message  message to be displayed on the console each time this interactive object is 
   *                 clicked. We assume that message is VALID (not null and not equal 
   *                 to an empty string)
   * @param nextClue a reference to a non-null InteractiveObject which represents the next clue 
   *                 associated to this interactive object.
   * 
   */
  public InteractiveObject(String name, int x, int y, String message, InteractiveObject nextClue) {
    this.NAME = name;
    this.x = x;
    this.y = y;
    this.message = message;
    this.nextClue = nextClue;
    this.image = processing.loadImage("images" + File.separator + name + ".png");
    this.isActive = true;
    this.wasClicked = false;
    this.nextClue.deactivate();
  }
  /**
   * Sets the PApplet object of the treasure hunt application where all the interactive objects will
   * be drawn. Note that a graphic application has ONLY one display window of type PApplet where 
   * all graphic objects interact. In p05, the TreasureHunt class is of type PApplet.
   * 
   * @param processing represents the reference to the TreasureHunt PApplet object where all 
   *                   the interactive objects will be drawn.
   */
  public static void setProcessing​(TreasureHunt processing) {
    InteractiveObject.processing = processing;
  }
  /**
   * Gets the x-position of this interactive object
   * 
   * @return the x-position of this interactive object
   */
  public int getX() {
    return this.x;
  }
  /**
   * Gets the y-position of this interactive object
   * 
   * @return the y-position of this interactive object
   */
  public int getY() {
    return this.y;
  }
  /**
   * Moves the current x and y positions of this interactive object with dx and dy, respectively
   * 
   * @param dx  move to be added to the x position of this interactive object
   * @param dy  move to be added to the y position of this interactive object
   * 
   */
  public void move​(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
  /**
   * Checks whether the name of this interactive object equals to the name passed as input parameter
   * . We consider a case-sensitive comparison.
   * 
   * @param name  name to compare to
   * 
   * @return true if the name of this interactive object equals the provided name, false otherwise.
   * 
   */
  public boolean hasName​(String name) {
    if (this.NAME.equals(name)) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * Checks whether this interactive object is active. This should be a getter of the isActive 
   * data field.
   * 
   * @return true if this interactive object is active and false otherwise.
   * 
   */
  public boolean isActive() {
    return this.isActive;
  }
  /**
   * Activates this interactive object, meaning setting its isActive data field to true.
   * 
   * 
   */
  public void activate() {
    this.isActive = true;
  }
  /**
   * Deactivates this interactive object, meaning setting its isActive data field to false.
   */
  public void deactivate() {
    this.isActive = false;
  }
  /**
   * Gets the message of this interactive object.
   * 
   * @return the message to be displayed each time this interactive object is clicked.
   */
  public java.lang.String message() {
    return this.message;
  }
  /**
   * Sets the next clue associated to this interactive object.
   * 
   * @param nextClue  the next clue to be assigned to this interactive object
   * 
   */
  public void setNextClue​(InteractiveObject nextClue) {
    this.nextClue = nextClue;
  }
  /**
   * Activates the next clue of this interactive object and adds it to the treasure 
   * hunt application
   */
  protected void activateNextClue() {
    if (this.nextClue == null) {
      throw new NoSuchElementException("nextClue is null");
    }
    this.nextClue.activate();
    processing.add(this.nextClue);
  }
  /**
   * Draws this interactive object (meaning drawing its image) to the display window at 
   * positions x and y.
   */
  @Override
  public void draw() {
    processing.image(image, x, y);
  }
  /**
   * This method operates each time the mouse is pressed. This interactive object responds to the 
   * mouse clicks as follows. If the mouse is clicked (meaning the mouse is over it) two operations 
   * will be performed as follows: (1) The message of this interactive object must be displayed to
   * the console. (2) If this interactive object has a next clue and was not clicked, its next clue 
   * will be activated and its wasClicked setting will be updated.
   */
  @Override
  public void mousePressed() {
    if (this.isMouseOver()) {
      System.out.println(this.message);
      if (this.nextClue != null && this.wasClicked == false) {
        activateNextClue();
        this.wasClicked = true;
      }
    }
  }
  /**
   * This method operates each time the mouse is released. It implements a default behavior for an 
   * interactive object which is DO NOTHING.
   */
  @Override
  public void mouseReleased() {

  }
  /**
   * Checks whether the mouse is over the image of this interactive object
   * 
   * @return true if the mouse is over the image of this interactive object, and false otherwise
   */
  @Override
  public boolean isMouseOver() {
    if (processing.mouseX <= this.x + image.width && processing.mouseX >= this.x
        && processing.mouseY >= this.y && processing.mouseY <= this.y + image.height) {
      return true;
    } else {
      return false;
    }
  }

}
