//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P02 Water Fountain
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

import java.util.Random;
import java.io.File;
import processing.core.PImage;

/**
 * This class implements particle system to create the animation of a water fountain.
 * 
 * @author Yancheng Zhu
 */
public class Fountain {
  private static Random randGen;
  private static PImage fountainImage;
  private static int positionX;
  private static int positionY;
  private static Droplet[] droplets;
  private static int startColor;
  private static int endColor;

  /**
   * This method changes the velocity, position, and color of a droplet in the array of droplets.
   *
   * @param index index of a certain droplet in the array of droplets.
   */
  private static void updateDroplet(int index) {
    droplets[index].setVelocityY(droplets[index].getVelocityY() + 0.3f);
    droplets[index].setPositionX(droplets[index].getPositionX() + droplets[index].getVelocityX());
    droplets[index].setPositionY(droplets[index].getPositionY() + droplets[index].getVelocityY());
    Utility.circle(droplets[index].getPositionX(), droplets[index].getPositionY(),
        droplets[index].getSize());
    Utility.fill(droplets[index].getColor(), droplets[index].getTransparency());
  }

  /**
   * This method creates a number of droplets.
   *
   * @param numberOfDroplets the number of droplets need to be created.
   */
  private static void createNewDroplets(int numberOfDroplets) {
    int count = 0;
    int index = 0;
    while (count < numberOfDroplets && index < 800) {
      if (droplets[index] == null) {
        droplets[index] = new Droplet();
        droplets[index].setPositionX(positionX + randGen.nextFloat() * 6 - 3);
        droplets[index].setPositionY(positionY + randGen.nextFloat() * 6 - 3);
        droplets[index].setSize(randGen.nextFloat() * 7 + 4);
        droplets[index].setColor(Utility.lerpColor(startColor, endColor, randGen.nextFloat()));
        droplets[index].setVelocityX(randGen.nextFloat() * 2 - 1);
        droplets[index].setVelocityY(randGen.nextFloat() * 5 - 10);
        droplets[index].setAge(randGen.nextInt(40) + 1);
        droplets[index].setTransparency(randGen.nextInt(96) + 32);
        count++;
      }
      index++;
    }
  }

  /**
   * This method removes droplets that reach their maximum age.
   *
   * @param maxAge the maximum age a droplet can reach.
   */
  private static void removeOldDroplets(int maxAge) {
    for (int i = 0; i < 800; i++) {
      if (droplets[i] != null && droplets[i].getAge() > maxAge) {
        droplets[i] = null;
      }
    }
  }

  /**
   * This method initializes basic instances needed for the class.
   */
  public static void setup() {
    testUpdateDroplet();
    testRemoveOldDroplets();
    randGen = new Random();
    droplets = new Droplet[800];
    startColor = Utility.color(23, 141, 235);
    endColor = Utility.color(23, 200, 255);
    positionX = Utility.width() / 2;
    positionY = Utility.height() / 2;
    fountainImage = Utility.loadImage("images" + File.separator + "fountain.png");
  }

  /**
   * This method generates graphic of the background, the fountain, and droplets.
   */
  public static void draw() {
    Utility.background(Utility.color(253, 245, 230));
    Utility.image(fountainImage, positionX, positionY);
    createNewDroplets(10);
    for (int i = 0; i < 800; i++) {
      if (droplets[i] != null) {
        updateDroplet(i);
        droplets[i].setAge(droplets[i].getAge() + 1);
      }
    }
    removeOldDroplets(80);
  }

  /**
   * This method adjusts the position of the fountain according to the position of the mouse.
   */
  public static void mousePressed() {
    positionX = Utility.mouseX();
    positionY = Utility.mouseY();
  }

  /**
   * This method creates a screenshot after receiving a certain string.
   * 
   * @param key the string input as an instruction.
   */
  public static void keyPressed(char key) {
    if (key == 's' || key == 'S') {
      Utility.save("screenshot.png");
    }
  }

  /**
   * This tester initializes the droplets array to hold at least three droplets. Creates a single
   * droplet at position (3,3) with velocity (-1,-2). Then checks whether calling updateDroplet() on
   * this droplet’s index correctly results in changing its position to (2.0, 1.3).
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testUpdateDroplet() {
    droplets = new Droplet[3];
    float expectedX = 2.0f;
    float expectedY = 1.3f;
    for (int i = 0; i < 3; i++) {
      droplets[i] = new Droplet();
    }
    droplets[0].setPositionX(3);
    droplets[0].setPositionY(3);
    droplets[0].setVelocityX(-1);
    droplets[0].setVelocityY(-2);
    updateDroplet(0);
    if (Math.abs(droplets[0].getPositionX() - expectedX) > 0.001
        || Math.abs(droplets[0].getPositionY() - expectedY) > 0.001) {
      System.out.println("updateDroplet() failed");
      return false;
    }
    return true;
  }

  /**
   * This tester initializes the droplets array to hold at least three droplets. Calls
   * removeOldDroplets(6) on an array with three droplets (two of which have ages over six and
   * another that does not). Then checks whether the old droplets were removed and the young droplet
   * was left alone.
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testRemoveOldDroplets() {

    droplets = new Droplet[800];
    for (int i = 0; i < 3; i++) {
      droplets[i] = new Droplet();
    }
    droplets[0].setAge(8);
    droplets[1].setAge(6);
    droplets[2].setAge(7);
    removeOldDroplets(6);
    if (droplets[0] != null || droplets[2] != null || droplets[1] == null) {
      System.out.println("removeOldDroplets() failed");
      return false;
    }
    return true;
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    Utility.runApplication();
  }

}
