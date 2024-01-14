//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Exam Scheduler
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
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * This class contains a few methods related to finding a single possible schedule or an arrayList
 * of all possible schedules.
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (Kenneth ZHANG,Yancheng Zhu )
 */
public class ExamScheduler {
  /**
   * This method aims at finding a possible schedule based on the given rooms and courses.
   * 
   * @param rooms   An array of rooms
   * @param courses An array of courses
   * @return A possible schedule based on the given rooms and courses.
   */
  public static Schedule findSchedule(Room[] rooms, Course[] courses) {
    Schedule possibleSchedule = new Schedule(rooms, courses);
    try {
      possibleSchedule = findScheduleHelper(possibleSchedule, 0);
      return possibleSchedule;
    } catch (IllegalStateException e) {
      throw new IllegalStateException("No such schedule");
    }

  }

  /**
   * 
   * This method is a private helper method of findSchedule method.
   * 
   * @param schedule The object of the Schedule class contains the information of rooms, courses and
   *                 assignments.
   * @param index    The index from which this method starts finding possible schedule.
   * @return A possible schedule.
   */
  private static Schedule findScheduleHelper(Schedule schedule, int index) {
    if (index == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        return schedule;
      } else {
        throw new IllegalStateException("Invalid Schedule");
      }
    }

    if (schedule.isAssigned(index)) {
      return findScheduleHelper(schedule, index + 1);
    } else {

      for (int i = 0; i < schedule.getNumRooms(); i++) {
        try {
          Schedule temp = schedule.assignCourse(index, i);
          return findScheduleHelper(temp, index + 1);
        } catch (IllegalArgumentException e) {


        } catch (IndexOutOfBoundsException e) {

        }

        catch (IllegalStateException e) {

        }
      }
      return findScheduleHelper(schedule, index + 1);

    }
  }

  /**
   * This method aims at finding all possible schedules based on the given rooms and courses.
   * 
   * @param rooms   An array of rooms
   * @param courses An array of courses
   * @return An arrayList contains all possible schedules.
   */
  public static ArrayList<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {
    Schedule possibleSchedule = new Schedule(rooms, courses);
    return findAllSchedulesHelper(possibleSchedule, 0);

  }

  /**
   * This method is a private helper method of findAllSchedules.
   * 
   * @param schedule The object of the Schedule class contains the information of rooms, courses and
   *                 assignments.
   * @param index    The index from which this method starts finding possible schedule.
   * @return An arrayList of all possible schedules.
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int index) {
    ArrayList<Schedule> possibleSchedules = new ArrayList<Schedule>();

    if (index == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        possibleSchedules.add(schedule);
        return possibleSchedules;

      } else {
        return possibleSchedules;
      }
    }
    if (schedule.isAssigned(index)) {
      possibleSchedules.addAll(findAllSchedulesHelper(schedule, index + 1));
    } else {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        try {
          Schedule temp = schedule.assignCourse(index, i);
          possibleSchedules.addAll(findAllSchedulesHelper(temp, index + 1));
        } catch (IndexOutOfBoundsException e) {
          break;
        } catch (IllegalArgumentException e) {

        }
      }

    }
    return possibleSchedules;
  }

}
