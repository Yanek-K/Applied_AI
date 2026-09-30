/*
 *
 * environment_sim.java
 * 
 * Assignment 1
 * Comp 3411 - Operating Systems, Winter 2023, O'Neil
 *
 * Student Name: Yanek Keshavjee
 * Student Number: T00678947
 * 
 * 
 * A vacuum cleaner example for a Simple Reflex Agent that behaves according to the following rules: 
 * 
 * Example Input : A true true true true
 * Example Output: A
 * 
 * a) If all squares are clean, the vacuum cleaner stays in its current location.
 * b) If the current location is not clean, the vacuum cleaner stays in its current 
 * location to clean it up.
 * c) The vacuum cleaner can only move horizontally or vertically (cannot move diagonally).
 * d) The vacuum cleaner moves only one square at a time.
 * e) Horizontal moves have the highest priority over vertical moves. For example, if the 
 * current location is A,  the status of A, B, C, D are "clean", "not clean", "clean" 
 * and "not clean" respectively, the Action is "move to B" (see example below).
 * f) The vacuum cleaner moves to another square only when it needs to be cleaned up. If a 
 * diagonal square needs to be cleaned up, the vacuum cleaner moves to its neighbour vertical 
 * square first. For example, if the current location is A,  the status of A, B, C, D are 
 * "clean", "clean", "clean" and "not clean" respectively, the Action is "move to C" (see 
 * example below).
 * g) The vacuum cleaner action is evaluated based on the current location and the status of all 
 * squares.
 * h) The program evaluates only one action (one move) at each run. 
 * 
 * **** That is, the program figures out the next Action and then terminates. ****
 * 
 * 
*/

import java.util.HashMap;
import java.util.Map;

public class environment_sim {
   public static void main(String args[]) {
      char current_location = args[0].charAt(0);
      // state true -> clean, false -> not clean
      boolean A_status = Boolean.parseBoolean(args[1]);
      boolean B_status = Boolean.parseBoolean(args[2]);
      boolean C_status = Boolean.parseBoolean(args[3]);
      boolean D_status = Boolean.parseBoolean(args[4]);
      System.out.println("Current Location = " + current_location + "\n" +
            "Square A_status = " + A_status + "\n" +
            "Square B_status = " + B_status + "\n" +
            "Square C_status = " + C_status + "\n" +
            "Square D_status = " + D_status + "\n");

      Map<Character, Boolean> clean = new HashMap<>();

      clean.put('A', A_status);
      clean.put('B', B_status);
      clean.put('C', C_status);
      clean.put('D', D_status);

      Map<Character, Character> horizontal = new HashMap<>();
      horizontal.put('A', 'B');
      horizontal.put('B', 'A');
      horizontal.put('C', 'D');
      horizontal.put('D', 'C');

      Map<Character, Character> vertical = new HashMap<>();
      vertical.put('A', 'C');
      vertical.put('B', 'D');
      vertical.put('C', 'A');
      vertical.put('D', 'B');

      Map<Character, Character> diagonal = new HashMap<>();
      diagonal.put('A', 'D');
      diagonal.put('B', 'C');
      diagonal.put('C', 'B');
      diagonal.put('D', 'A');

      char h = horizontal.get(current_location);
      char v = vertical.get(current_location);
      char d = diagonal.get(current_location);

      // Simple Reflex Agent: if the current square is dirty, stay and clean it.
      // Otherwise check neighbours in priority order, and clean the first dirty
      // one found. If all are clean, don't do anything.
      if (isClean(current_location, clean)) {

         if (!isClean(h, clean)) {
            current_location = h;
         } else if (!isClean(v, clean)) {
            current_location = v;
         } else if (!isClean(d, clean)) {
            current_location = v;
         }
      }
      System.out.println("\nAction - Next Location =" + current_location);
   }

   static boolean isClean(char square, Map<Character, Boolean> clean) {
      return clean.get(square);
   }
}