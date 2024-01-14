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
 * This class uses a linked queue to implement DNA transcription.
 * 
 * @author Yancheng Zhu
 *
 */
public class DNA {
  protected LinkedQueue<Character> DNA;
  protected static String[][] mRNAtoProteinMap =
      {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
          {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
          {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
          {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
          {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
          {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
          {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
          {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
          {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
          {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
          {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};

  /**
   * Creates the DNA queue from the provided String. Each Node contains a single Character from the
   * sequence.
   * 
   * @param sequence a String containing the original DNA sequence
   */
  public DNA(String sequence) {
    this.DNA = new LinkedQueue<Character>();
    for (int i = 0; i < sequence.length(); i++) {
      DNA.enqueue(sequence.charAt(i));
    }
  }

  /**
   * Creates and returns a new queue of mRNA characters from the stored DNA. The transcription is
   * done one character at a time, as (A->U, T->A, C->G, G->C).
   * 
   * @return the queue containing the mRNA sequence corresponding to the stored DNA sequence
   */
  public LinkedQueue<Character> transcribeDNA() {
    LinkedQueue<Character> mRNA = new LinkedQueue<Character>();
    for (int i = 0; i < this.DNA.size(); i++) {
      char temp = DNA.dequeue();
      char rNA = 0;
      if (temp == 'A') {
        rNA = 'U';
      }
      if (temp == 'T') {
        rNA = 'A';
      }
      if (temp == 'C') {
        rNA = 'G';
      }
      if (temp == 'G') {
        rNA = 'C';
      }
      mRNA.enqueue(rNA);
      this.DNA.enqueue(temp);
    }
    return mRNA;
  }

  /**
   * Creates and returns a new queue of amino acids from a provided queue of mRNA characters.
   * 
   * @param mRNA a queue containing the mRNA sequence corresponding to the stored DNA sequence
   * @return the queue containing the amino acid sequence corresponding to the provided mRNA
   *         sequence
   */
  public LinkedQueue<String> mRNATranslate​(LinkedQueue<Character> mRNA) {
    LinkedQueue<String> aminoAcid = new LinkedQueue<String>();
    while (!mRNA.isEmpty()) {
      int i = 0;
      String temp = "";
      while (i < 3) {
        try {
          mRNA.peek();

        } catch (NoSuchElementException e) {
          return aminoAcid;
        }
        temp += mRNA.dequeue().toString();
        i++;
      }
      for (int j = 0; j < mRNAtoProteinMap.length; j++) {
        if (temp.equals(mRNAtoProteinMap[j][0])) {
          if (mRNAtoProteinMap[j][1].equals("STOP")) {
            return aminoAcid;
          }
          aminoAcid.enqueue(mRNAtoProteinMap[j][1]);
        }
      }
    }
    return aminoAcid;
  }

  /**
   * A shortcut method that translates the stored DNA sequence to a queue of amino acids using the
   * other two methods in this class
   * 
   * @return the queue containing the amino acid sequence corresponding to the stored DNA sequence,
   *         via its mRNA transcription
   */
  public LinkedQueue<String> translateDNA() {
    LinkedQueue<String> aminoAcid = this.mRNATranslate​(this.transcribeDNA());
    return aminoAcid;
  }

}
