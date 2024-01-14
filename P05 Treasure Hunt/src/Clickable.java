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
public interface Clickable {
  public void draw(); // draws this Clickable object to the screen

  public void mousePressed(); // defines the behavior of this Clickable object
  // each time the mouse is pressed

  public void mouseReleased(); // defines the behavior of this Clickable object
  // each time the mouse is released

  public boolean isMouseOver(); // returns true if the mouse is over this clickable object
}
