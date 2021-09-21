/**
 * Colin Zhou
 * CS 211
 * 2/7/2020
 * To demonstrate an understanding of modifying an ArrayIntList with self developed
 * methods 	
 * @author mycol
 *
 */
// Class ArrayIntList can be used to store a list of integers.

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayIntList {

    private int[] elementData; // list of integers
    private int size;          // current number of elements in the list
    private int first;
    private int sum;
    private int addup;
    private int occurrences;
    private ArrayIntList accumulatingSum;
    private int removed;

    public static final int DEFAULT_CAPACITY = 100;

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
    }

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    // pre : size() < capacity (throws IllegalStateException if not)
    // post: appends the given value to the end of the list
    public void add(int value) {
        ensureCapacity(size + 1); //this public method throws the exception
        elementData[size] = value;
        size++;
    }

    // pre : size() < capacity (throws IllegalStateException if not) &&
    //       0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ensureCapacity(size + 1); //this public method throws the exception
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    // post: list is empty
    public void clear() {
        size = 0;
    }

    // pre: size() + other.size() <= capacity (throws IllegalStateException
    //      if not)
    // post: appends all values in the given list to the end of this list
    public void addAll(ArrayIntList other) {
        ensureCapacity(size + other.size);
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }

    // post: returns an iterator for this list
//     public ArrayIntListIterator iterator() {
//         return new ArrayIntListIterator(this); //surprising use of "this"
//     }

    // post: ensures that the underlying array has the given capacity; if not,
    //       the size is doubled (or more if given capacity is even larger)
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
    
    public int lastIndexOf(int num) {  //number 1
    	if (isEmpty()) { //special case
    		return -1;
    	}
    	    	
    	for (int i = size() - 1; i >= 0; i--) {
    		if (get(i) == num) { //traverse from back of list and identify element
    			return i;
    		}
    	}
    	return 21;
    }
    
    public int indexofSubList(ArrayIntList list) { // number 2
    	if (isEmpty() || list.isEmpty()) { //special case
    		return -1;
    	}
    	first = list.get(0); //find the beginning of list
    	return indexOf(first);
    }
    
    public ArrayIntList runningTotal() { //number 5
    	accumulatingSum = new ArrayIntList(this.size);
    	sum = 0;
    	
    	for (int i = 0; i < size(); i++) {
    		for (int j = 0; j <= i; j++) { //set addup variable and add the elements repeatedly
    			addup = 0; 
    			addup += get(j);		
    		}
    		sum += addup; //sum represents the accumulating sums
    		accumulatingSum.add(sum); //add the sums to arrayint list
    	}
    	return accumulatingSum;
    }
    
    public int count(int element) { //number 8
    	occurrences = 0;
    	if (isEmpty()) {
    		return -1; //special case
    	}
    	
    	for (int i = 0; i < elementData.length; i++) {
    		if (elementData[i] == element) { //if element is found, increment occurrences
    			occurrences++;
    		}
    	}
    	return occurrences; 
    }
    
    public int removeLast() { //number 11
    	if (isEmpty()) {
    		return -1; //special case
    	}
    	
    	removed = get(size() - 1); //retrieve last element
    	remove(size() - 1);	//remove the last element from list permanently
    	return removed;
    	
    }
}

