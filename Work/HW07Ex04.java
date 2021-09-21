/**
 * Colin Zhou
 * CS 211
 * 2/22/2020
 * Method doubleDigits to take in an integer and return an integer with all the 
 * individual digits repeated. Doesn't matter if positive or negative.
 * @author mycol
 *
 */
public class HW07Ex04 {
	
	public static void main(String[]args) {
		System.out.println("DoubleDigits result: " + doubleDigits(348)); //testing
		System.out.println("DoubleDigits result: " + doubleDigits(0));
		System.out.println("DoubleDigits result: " + doubleDigits(1023));
		System.out.println("DoubleDigits result: " + doubleDigits(-1));
		System.out.println("DoubleDigits result: " + doubleDigits(-1234));
		System.out.println("DoubleDigits result: " + doubleDigits(-14441));
		System.out.println("DoubleDigits result: " + doubleDigits(-10345));
	}
	
	public static Integer doubleDigits(int n) { //method
		
		if (n == 0) { //base case
			return 0;
		} else { //recursive
			int digit = n % 10;
			return 100 * doubleDigits(n / 10) + 10 * digit + digit;
		}				
	}
}
