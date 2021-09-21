/**
 * Colin Zhou
 * CS 211
 * 1/24/2020
 * To demonstrate solid understanding of operations relating to sets and maps. 	
 * @author mycol
 *
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HW03 {

	public static void main(String[] args) { //test individual methods
		int[]list = new int[] {7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9};
		SortAndRemoveDuplicates(list);
		
		Set<Integer>list1 = new HashSet<Integer>(); //add numbers to first hashset
		list1.add(1);
		list1.add(4);
		list1.add(7);
		list1.add(9);
		Set<Integer>list2 = new HashSet<Integer>(); //add second batch of numbers to second hashset
		list2.add(2);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(7);
		System.out.println("Symmetric set difference:" + symmetricSetDifferences(list1, list2));
		
		HashMap<String, String> map = new HashMap<String, String>(); //hashmap 1 to demo true case
		map.put("Marty", "Stepp");
		map.put("Stuart","Reges");
		map.put("Jessica", "Miller");
		map.put("Amanda", "Camp");
		map.put("Hal", "Perkins");
		System.out.println("Are each key mapped to only one value? " + isUnique(map));
		
		HashMap<String, String> map2 = new HashMap<String, String>();//hashmap 2 to demo false case
		map2.put("Marty", "Camp");
		map2.put("Stuart","Reges");
		map2.put("Jessica", "Miller");
		map2.put("Amanda", "Camp");
		map2.put("Hal", "Perkins");
		System.out.println("Are each key mapped to only one value? " + isUnique(map2));
	}
	
	public static void SortAndRemoveDuplicates(int[] list) {
		Set<Integer>set = new TreeSet<Integer>();
		for (int i = 0; i < list.length; i++) { //adds to Treeset to get rid of duplicates
			set.add(list[i]);
		}
		
		System.out.print("[ "); // printing the array
		for (Integer integer: set) {
			System.out.print(integer + ", ");
		}
		System.out.println("]");
	}
	
	public static Set symmetricSetDifferences(Set<Integer> set1, Set<Integer>set2) {
		Set<Integer> result = new TreeSet<Integer>();
		
		for (Integer integer1: set1) { //add all elements to treeset and print
			result.add(integer1);
		}
		
		for (Integer integer2: set2) {
			result.add(integer2);
		}
		
		return result;
	}

	public static boolean isUnique(HashMap<String,String> map) {
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> duplicates = new ArrayList<String>();		
		
		for (String value: map.values()) { //add values to first arraylist
			
			if(!list.contains(value)) { //if element already present in first arraylist, add to duplicates.
				list.add(value);
			} else {
				duplicates.add(value); 
			}
		}
		
		if(duplicates.size() == 0) { //check size of duplicates array
			return true;
		}
		
		return false;	
		
	}
}
