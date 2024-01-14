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
 * This class contains a few methods related to the initialization of screenshot button.
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (YANCHENG ZHU, KENNETH ZHANG)
 */
public class ScreenshotButton extends Button {

  /**
   * Creates a new ScreenshotButton object labeled "Take a screenshot" at a specific position on the
   * screen.
   * 
   * @param x x-position to be assigned to this screenshot button
   * @param y y-position to be assigned to this screenshot button
   */
  public ScreenshotButton(int x, int y) {
    super("Take a screenshot", x, y);
  }

  /**
   * Defines the behavior of this button when the mouse is pressed. When it is clicked, this button
   * takes a screenshot of the game screen. This method calls the PApplet.save() method to save the
   * screenshot with the filename "screenshot.png".
   */
  @Override
  public void mousePressed() {
    if (super.isMouseOver()) {
      super.processing.save("screenshot.png");
    }
  }
}
