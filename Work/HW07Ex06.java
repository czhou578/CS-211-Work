/**
 * Colin Zhou
 * CS 211
 * 2/22/2020
 * Method writeSquares to take in an integer and prints the first "n" squares with the
 * odd squares printed in descending order before the even squares. 
 * @author mycol
 *
 */

public class HW07Ex06 {
	
	public static void main(String[]args) {
		System.out.print("WriteSquares result: ");
		writeSquares(1); //test cases
		System.out.println();
		System.out.print("WriteSquares result: ");
		writeSquares(4);
		System.out.println();
		System.out.print("WriteSquares result: ");
		writeSquares(14);
		System.out.println();
		System.out.println("WriteSquares result: ");
		writeSquares(0); //throws exception
		System.out.println();
		System.out.println("WriteSquares result: ");
		writeSquares(-1); //throws exception
		
	}
	
	public static void writeSquares(int n) { //testing writeSquares
		
		if (n < 1) { //exception case
			throw new IllegalArgumentException("Input cannot be less then 1");
		} 
		
		if (n == 1) { //base case
			System.out.print(1);
			return;
		} 
		
		if (n % 2 == 0) { //recursion, considering if parameter n is even or not. 
			writeSquares(n - 1);
			int result = (int) Math.pow(n, 2);
			System.out.print("," + result);
		} else {
			System.out.print((int)Math.pow(n, 2) + ",");
			writeSquares(n - 1);
		}
	}	
}
