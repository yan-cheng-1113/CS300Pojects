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
 * This class contains a few methods related to the initialization of restart-game button.
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (YANCHENG ZHU, KENNETH ZHANG)
 */
public class RestartGameButton extends Button {

  /**
   * Creates a new RestartGameButton object labeled "Restart Game" at a specific position on the
   * screen.
   * 
   * @param x x-position to be assigned to this restart game button.
   * @param y y-position to be assigned to this restart game button.
   */
  public RestartGameButton(int x, int y) {
    super("Restart Game", x, y);
  }

  /**
   * Defines the behavior of this button when the mouse is pressed. This button initializes the game
   * if it is clicked (meaning if the mouse is over it).
   */
  @Override
  public void mousePressed() {
    if (super.isMouseOver() && processing instanceof TreasureHunt) {
      ((TreasureHunt) processing).initGame();
    }
  }
}
