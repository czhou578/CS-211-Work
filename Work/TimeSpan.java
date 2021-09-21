/**
 * Colin Zhou
 * CS 211
 * 1/16/2020
 * To demonstrate conceptual understanding of Comparable interface 
 * in comparing objects.  
 * @author mycol
 *
 */

// Represents a time span of elapsed hours and minutes.
// Simple implementation using only total minutes as state.
public class TimeSpan implements Comparable<TimeSpan> {
   private int totalMinutes;

   // Constructs a time span with the given interval.
   // pre: hours >= 0 && minutes >= 0
   public TimeSpan(int hours, int minutes) {
      totalMinutes = 0;
      add(hours, minutes);
   }
   
   // Adds the given interval to this time span.
   // pre: hours >= 0 && minutes >= 0
   public void add(int hours, int minutes) {
      totalMinutes += 60 * hours + minutes;
   }

   // Returns a String for this time span such as "6h15m".
   public String toString() {
      return (totalMinutes / 60) + "h"
             + (totalMinutes % 60) + "m";
   }
   
   @Override
   public int compareTo(TimeSpan span) { //Compares TimeSpan objects
	   if (this.totalMinutes > span.totalMinutes) {
		   return 1;
	   } else if (this.totalMinutes == span.totalMinutes) {
		   return 0;
	   }
	   return -1;
   }

}

