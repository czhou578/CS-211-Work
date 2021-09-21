/**
 * Colin Zhou
 * CS 211
 * 1/13/2020
 * To demonstrate conceptual understanding of ArrayLists. 
 * @author mycol
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InClass01 {
	private static int sum;
	private static int average;
	private static int min;
	private static int max;
	private static final int MAX = Integer.MAX_VALUE;
	private static final int MIN = Integer.MIN_VALUE;
	
	public static void main(String[]args) throws FileNotFoundException {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner input = new Scanner(new File("C:\\Users\\mycol\\CS 211\\CS 211 Work\\src\\Numbers.txt"));
		
		while (input.hasNextInt()) {
		    int n = input.nextInt();
		    numbers.add(n);
		}

		System.out.println(numbers);

		//insert additional methods and calls here ...
		System.out.println("Count: " + numbers.size());
		System.out.println("Average: " + calculateAverage(numbers));
		System.out.println("Minimum Value: " + calcMin(numbers));
		System.out.println("Maximum Value: " + calcMax(numbers));
		
		//filters out all even numbers
		filterEvens(numbers);
		System.out.println(numbers);

	}
	// Removes all elements with even values from the given list.
	public static void filterEvens(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			int n = list.get(i);
			if (n % 2 == 0) {
				list.remove(i);
			}
		}
	}
	
	public static int calculateAverage(ArrayList<Integer> list) { //sums up and calculates average
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		average = sum / list.size();
		
		return average;
	}
	
	public static int calcMin(ArrayList<Integer> list) {
		min = MAX; //largest Integer value possible
		for (int i = 0; i < list.size(); i++) {
			if (min > list.get(i)) {
				min = list.get(i);
			}
		}
		return min;
	}
	
	public static int calcMax(ArrayList<Integer> list) {
		max = MIN; //smallest integer value possible
		for (int i = 0; i < list.size() - 1; i++) {
			if (max < list.get(i)) {
				max = list.get(i);
			}
		}
		return max;
	}

}
