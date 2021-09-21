/**
 * Colin Zhou
 * CS 211
 * 2/22/2020
 * Method permut to take in an integer and return its product of the first
 * "n" even integers. 
 * @author mycol
 *
 */

public class HW07Ex15 {
	
	public static void main(String[]args) {
		System.out.println("Permut result: " + permut(7,4)); //test cases
		System.out.println("Permut result: " + permut(7,2));
		System.out.println("Permut result: " + permut(4,1));
		System.out.println("Permut result: " + permut(2,2));
		System.out.println("Permut result: " + permut(1,2));
		System.out.println("Permut result: " + permut(1,0));
		System.out.println("Permut result: " + permut(0,0));
		System.out.println("Permut result: " + permut(2,-1)); //exception cases
		System.out.println("Permut result: " + permut(-1,2));
		System.out.println("Permut result: " + permut(-2,-2));

	}
	
	public static Integer permut(int n, int r) { //method
		
		if (n < 0 || r < 0) {
			throw new IllegalArgumentException("Parameters must be positive!");
		}
		
		if (r == 0 || n < r) { //base case
			return 0;
		}
		
		if (n == r) { //recursion
			return r;
		} else {
			return n * permut(n - 1, r);
		}
	}
}
