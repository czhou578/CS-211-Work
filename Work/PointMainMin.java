/**
 * Colin Zhou
 * CS 211
 * 1/16/2020
 * To demonstrate conceptual understanding of Comparable interface 
 * in comparing objects.  
 * @author mycol
 *
 */

// A client program that deals with simple points.
// Minimal version, to accompany immutable Point class.

public class PointMainMin {
   public static void main(String[] args) {
      // create two Point objects
      Point p1 = new Point(7, 2);
      Point p2 = new Point(4, 3);
   
      // print each point and its distance from the origin
      System.out.println("p1 is " + p1);
      System.out.printf("distance from origin = %3.2f\n",
                            p1.distanceFromOrigin());
   
      System.out.println("p2 is " + p2);
      System.out.printf("distance from origin = %3.2f\n",
                            p2.distanceFromOrigin());
   }
}

