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
 * Test methods to verify your implementation of the methods for P08.
 * 
 * @author Yancheng Zhu
 */
public class DNATester {
  /**
   * Tests the Enqueue() and Dequeue method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testEnqueueDequeue() {
    try {
      DNA testDna = new DNA("GGAG");
      testDna.DNA.enqueue('A');
      testDna.DNA.enqueue('C');
      if (!testDna.DNA.toString().replaceAll(" ", "").equals("GGAGAC") && testDna.DNA.size() != 6) {
        return false;
      }
      if (!testDna.DNA.dequeue().equals('G') && testDna.DNA.size() != 5) {
        return false;
      }
      if (!testDna.DNA.toString().replaceAll(" ", "").equals("GAGAC")) {
        return false;
      }
    } catch (NullPointerException e) {
      return false;
    } catch (Exception e) {
      return false;
    }
    try {
      DNA testDNa = new DNA("");
      testDNa.DNA.dequeue();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }


    return true;
  }

  public static boolean testQueueSize() {
    try {
      LinkedQueue<String> testQue = new LinkedQueue<String>();
      testQue.enqueue("first");
      testQue.enqueue("second");
      if (testQue.size() != 2) {
        return false;
      }
      testQue.dequeue();
      testQue.dequeue();
      if (testQue.size() != 0) {
        return false;
      }
    } catch (NullPointerException e) {
      return false;

    }
    return true;
  }

  /**
   * Tests the transcribeDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    System.out.println(testDNA.transcribeDNA().toString());
    if (testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA)) {
      return true;
    }
    return false;
  }

  /**
   * Tests the translateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    System.out.println(testDNA.translateDNA().toString());
    if (testDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {
      return true;
    }
    return false;
  }

  public static boolean testMRNATranslate() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String[][] testMap = {{"UUU", "F"}, {"UUC", "F"}};
    LinkedQueue<Character> testMRNA = new LinkedQueue<Character>();
    testMRNA.enqueue('U');
    testMRNA.enqueue('U');
    testMRNA.enqueue('U');
    testMRNA.enqueue('U');
    testMRNA.enqueue('U');
    testMRNA.enqueue('C');
    LinkedQueue<String> result = testDNA.mRNATranslate​(testMRNA);
    if (!result.toString().equals("F F ")) {
      return false;
    }
    return true;
  }

  public static boolean runAllTest() {
    if (testEnqueueDequeue() && testQueueSize() && testTranscribeDNA() && testTranslateDNA()
        && testMRNATranslate()) {
      return true;
    }
    return false;
  }

  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * 
   * @param args unused
   */
  public static void main(String[] args) {

    System.out.println(runAllTest());
  }

}
