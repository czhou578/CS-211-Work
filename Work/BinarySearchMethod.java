/**
 * Colin Zhou
 * CS 211
 * 1/28/2020
 * To demonstrate conceptual understanding of how to manipulate binarySearch algorithm. 
 * @author mycol
 *
 */
public class BinarySearchMethod {
	public static void main(String[]args) {
		String[]array = {"answer", "bye", "castle", "dog", "graphs"}; //test array
		System.out.println(binarySearch(array, "bye"));
		System.out.println(binarySearch(array, "castle"));  //testing cases
		System.out.println(binarySearch(array, "graphs"));
	}
	
	// Returns the index of an occurrence of target in a,
	// or a negative number if the target is not found.
	// Precondition: elements of a are in sorted order
	public static int binarySearch(String[] a, String target) {
	    int min = 0;
	    int max = a.length - 1;

	    while (min <= max) {
	        int mid = (min + max) / 2;
	        if (a[mid].compareTo(target) < 0) {
	            min = mid + 1;
	        } else if (a[mid].compareTo(target) > 0) {
	            max = mid - 1;
	        } else {
	            return mid;   // target found
	        }
	    }

	    return -(min + 1);    // target not found
	}

}
