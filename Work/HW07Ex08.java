/**
 * Colin Zhou
 * CS 211
 * 2/22/2020
 * Method multiplyEvens to take in an integer and return its product of the first
 * "n" even integers
 * @author mycol
 *
 */
public class HW07Ex08 {
	
	public static void main(String[]args) {
		System.out.println("MultiplyEvens result: " + multiplyEvens(1)); //testing
		System.out.println("MultiplyEvens result: " + multiplyEvens(4));
		System.out.println("MultiplyEvens result: " + multiplyEvens(7));
		System.out.println("MultiplyEvens result: " + multiplyEvens(0)); //testing exception case
		System.out.println("MultiplyEvens result: " + multiplyEvens(-2)); //testing exception case

	}
	
	public static Integer multiplyEvens(int n) {
		
		if (n <= 0) { //illegal argument
			throw new IllegalArgumentException("Must be greater then 0");
		}
		
		if (n == 1) { //base case
			return 2;
		} else {
			return multiplyEvens(n - 1) * 2 * n; //recursive
		}
	}
}
