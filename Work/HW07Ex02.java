/**
 * Colin Zhou
 * CS 211
 * 2/22/2020
 * To print out the parameter "n" numbers in consecutive order.
 * @author mycol
 *
 */
public class HW07Ex02 {
	public static void main(String[]args) {
		
		System.out.print("WriteNums result: "); //test cases
		writeNums(1); 
		System.out.println();
		System.out.print("WriteNums result: ");
		writeNums(10);
		System.out.println();
		System.out.print("WriteNums result: ");
		writeNums(5);
		System.out.println();
		System.out.print("WriteNums result: ");
		writeNums(-1); // exception cases
		System.out.println();
		System.out.print("WriteNums result: ");
		writeNums(0); //exception
		
	}
	
	
	public static void writeNums (int n) { //prints out n numbers in order with commas
		
		if (n < 1) {
			throw new IllegalArgumentException("Illegal argument!"); //throws exception
		}
		
		if (n == 1) { //base case
			System.out.print("1");
		} else {
			writeNums(n - 1); //recursion
			System.out.print("," + n);			
		}
	}
}
