 
/*
 * TimeSpanClient: a simple test client for the TimeSpan class
 * Shows creation of an instance object, displaying that object,
 * adding hours and minutes to that object, and showing the result.
 */
 public class TimeSpanClient {
    public static void main(String[] args) {
        int h1 = 13, m1 = 30;
        TimeSpan t1 = new TimeSpan(h1, m1);
        System.out.println("New object t1: " + t1);
        
        h1 = 3; m1 = 40;
        System.out.println("Adding " + h1 + " hours, " + m1 + " minutes to t1");        
        t1.add(h1, m1);
        System.out.println("New t1 state: " + t1);
    }
}
