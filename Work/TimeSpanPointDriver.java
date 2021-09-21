/**
 * Colin Zhou
 * CS 211
 * 1/16/2020
 * To demonstrate conceptual understanding of Comparable interface 
 * in comparing objects. This is the client class. 
 * @author mycol
 *
 */
public class TimeSpanPointDriver {

	public static void main(String[] args) {
        int h1 = 13, m1 = 30;
        int h2 = 14, m2 = 13;
        int h3 = 14, m3 = 13;
        
        TimeSpan t1 = new TimeSpan(h1, m1); //Creating new Time Objects
        System.out.println("New object t1: " + t1);
               
        TimeSpan t2 = new TimeSpan(h2, m2);
        System.out.println("New object t2: " + t2);
        TimeSpan t3 = new TimeSpan(h3, m3);
        System.out.println("New object t3: " + t3);
                
        System.out.println("Time 1 compared to Time 2: " + t1.compareTo(t2));  //Comparing Time Objects
        System.out.println("Time 2 compared to Time 3: " + t2.compareTo(t3));
        System.out.println("Time 3 compared to Time 1: " + t3.compareTo(t1));
        
        // create two Point objects
        Point p1 = new Point(7, 2);
        Point p2 = new Point(4, 3);
        Point p3 = new Point(5, 2);
        Point p4 = new Point(6, 7);
     
        //comparing Point Objects
        System.out.println("Point 1 compared to Point 2: " + p1.compareTo(p2));
        System.out.println("Point 2 compared to Point 3: " + p2.compareTo(p3));
        System.out.println("Point 3 compared to Point 4: " + p3.compareTo(p4));
        System.out.println("Point 1 compared to Point 4: " + p1.compareTo(p4));

	}
}
