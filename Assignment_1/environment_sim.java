/*
Example Input : A true true true true
Example Output: A

a) If all squares are clean, the vacuum cleaner stays in its current location.

b) If the current location is not clean, the vacuum cleaner stays in its current 
   location to clean it up.

c) The vacuum cleaner can only move horizontally or vertically (cannot move diagonally).

d) The vacuum cleaner moves only one square at a time.

e) Horizontal moves have the highest priority over vertical moves. For example, if the 
   current location is A,  the status of A, B, C, D are "clean", "not clean", "clean" 
   and "not clean" respectively, the Action is "move to B" (see example below).

f) The vacuum cleaner moves to another square only when it needs to be cleaned up. If a 
   diagonal square needs to be cleaned up, the vacuum cleaner moves to its neighbour vertical 
   square first. For example, if the current location is A,  the status of A, B, C, D are 
   "clean", "clean", "clean" and "not clean" respectively, the Action is "move to C" (see 
   example below).

g) The vacuum cleaner action is evaluated based on the current location and the status of all 
   squares.

h) The program evaluates only one action (one move) at each run. 

**** That is, the program figures out the next Action and then terminates. ****

*/

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

      System.out.println("\nAction - Next Location =" + current_location);

   }
}
