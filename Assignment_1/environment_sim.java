/*
 *
 * environment_sim.java
 * 
 * Assignment 1
 * Comp 3711 - Applied Artifical Intelligence, Winter 2026, Law.
 *
 * Student Name: Yanek Keshavjee
 * Student Number: T00678947
 * 
 * A vacuum cleaner example for a Simple Reflex Agent that behaves according to the rules
 * outlined in the Assignment Brief.
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

      Map<Character, Boolean> current_status = new HashMap<>();

      current_status.put('A', A_status);
      current_status.put('B', B_status);
      current_status.put('C', C_status);
      current_status.put('D', D_status);

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

      // Figure out the horizontal, vertical and diagonal squares for the starting
      // square.
      char h = horizontal.get(current_location);
      char v = vertical.get(current_location);
      char d = diagonal.get(current_location);

      // Simple Reflex Agent: if the current square is dirty, stay and clean it.
      // Otherwise check neighbours in priority order, and clean the first dirty
      // one found. If all squares are clean, don't do anything.

      if (isClean(current_location, current_status)) {
         if (!isClean(h, current_status)) {
            current_location = h;
         } else if (!isClean(v, current_status)) {
            current_location = v;
         } else if (!isClean(d, current_status)) {
            current_location = v;
         }
      }
      System.out.println("Action - Next Location = " + current_location);
   }

   // Helper method
   // Takes the current location and checks if that square is clean based
   // on the current_status of all the squares.
   // Returns true if the current location is clean.
   static boolean isClean(char current_location, Map<Character, Boolean> current_status) {
      return current_status.get(current_location);
   }
}