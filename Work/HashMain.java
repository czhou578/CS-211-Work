/**
 * Colin Zhou
 * CS 211
 * 3/8/2020
 * Serves to test HashIntSet with corresponding objects and method demonstrations.
 * @author mycol
 *
 */

import java.util.Arrays;
import java.util.Collections;

public class HashMain {
    public static void main(String[] args) {
        HashIntSet set1 = new HashIntSet();
        set1.add(7);
        set1.add(5);
        set1.add(1);
        set1.add(9);
        set1.add(14);
        
        HashIntSet set2 = new HashIntSet(); //creation of new hashset.
        set2.add(0);
        set2.add(5);
        set2.add(16);
        set2.add(-19);
        set2.add(12);
        set2.add(124);
        set2.add(23);
        
        HashIntSet set3 = new HashIntSet(); //creation of new hashset that is empty.
                        
        System.out.println("First HashSet: " + set1.toString()); //print before any manipulation     
        System.out.println("Second HashSet: " + set2.toString());
        System.out.println("Third HashSet: " + set3.toString());
        
        System.out.println("Does set 1 contain all set 2 integers? " + set1.containsAll(set2)); //testing out containsAll
        System.out.println("Does set 1 equal set 2? " + set1.equals(set2)); //testing out equals method.
        System.out.println(); //create line break
        
        System.out.println("Does set 1 contain all set 3 integers? " + set1.containsAll(set3));
        System.out.println("Does set 1 equal set 3? " + set1.equals(set3)); //testing out equals method.
        System.out.println();
        
        
        set1.addAll(set2); //add all elements from set 2 into set 1
        System.out.println("Set 1 after adding all integers in set 2: " + set1.toString());
        System.out.println("Set 2 after adding to Set 1: " + set2.toString());
        System.out.println("Does set 1 equal set 2? " + set1.equals(set2)); //testing out equals method.         
        System.out.println("Does set 1 contain all set 2 integers? " + set1.containsAll(set2)); //testing out containsAll.
        System.out.println();
        
        set3.addAll(set1); //add all elements from set 1 into set 3
        System.out.println("Set 3 after adding all integers in set 1: " + set3.toString());
        System.out.println("Set 1 after adding to Set 3: " + set1.toString());
        System.out.println("Does set 3 equal set 1? " + set3.equals(set1)); //testing out equals method.         
        System.out.println("Does set 3 contain all set 1 integers? " + set3.containsAll(set1)); //testing out containsAll.
        System.out.println();
        System.out.println();
        
        System.out.println("Additional tests from original unedited test client.");
        
        // test adding duplicates
        set1.add(7);
        set1.add(7);
        set1.add(5);
        
        // test collisions and linked lists
        set1.add(45);
        set1.add(91);
        set1.add(71);
        
        // test rehashing
        set1.add(810);   // re-hash should occur here (8/10, load = 0.8)
        set1.add(62);
        set1.add(1238);
        set1.add(-99);
        set1.add(-30);
        set1.add(42);
        set1.add(49857);
        set1.add(1520);  // re-hash should occur here (15/20, load = 0.75)
        set1.add(2);
        set1.add(31);
        set1.add(11);
        set1.add(21);
        
        // test removal
        set1.remove(7);
        set1.remove(9);
        set1.remove(1);
        set1.remove(1);
        set1.remove(21);
        set1.remove(71);
        
        for (int n : new int[] {1520, 99, 2, 55, 42, 11, 45, 0, 5, -10, 810}) {
			System.out.println("contains " + n + "? " + set1.contains(n));
		}
        
        System.out.println(set1 + ", size " + set1.size());
    }
}
