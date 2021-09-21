/**
 * Colin Zhou
 * CS 211
 * 3/8/2020
 * Serves to implement kthSmallest method(which finds "k"th smallest integer in heap and 
 * removeDuplicates method, which removes all duplicate elements from the current heap.
 * @author mycol
 *
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

// Implements a priority queue of integers using a
// min-heap represented as an array.
public class HeapIntPriorityQueue {
    int[] elementData;
    private int size;
    private int count;
    private int div;
    private int i;
    
    // Constructs an empty queue.
    public HeapIntPriorityQueue() {
        elementData = new int[10];
        size = 0;
    }
    
    // Adds the given element to this queue.
    public void add(int value) {
        // resize if necessary
        if (size + 1 >= elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        
        // insert as new rightmost leaf
        elementData[size + 1] = value;
        
        // "bubble up" toward root as necessary to fix ordering
        int index = size + 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasParent(index)) {
            int parent = parent(index);
            if (elementData[index] < elementData[parent]) {
                swap(elementData, index, parent(index));
                index = parent(index);
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        size++;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementData[1];
    }
    
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public int remove() {
        int result = peek();

        // move rightmost leaf to become new root
        elementData[1] = elementData[size];
        size--;
        
        // "bubble down" root as necessary to fix ordering
        int index = 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if (hasRightChild(index) &&
                    elementData[right] < elementData[left]) {
                child = right;
            }
            
            if (elementData[index] > elementData[child]) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        return result;
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    
    // helpers for navigating indexes up/down the tree
    private int parent(int index) {
        return index / 2;
    }
    
    // returns index of left child of given index
    private int leftChild(int index) {
        return index * 2;
    }
    
    // returns index of right child of given index
    private int rightChild(int index) {
        return index * 2 + 1;
    }
    
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
        return index > 1;
    }
    
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }
    
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }
    
    // switches the values at the two given indexes of the given array
    private void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    
    public Integer kthSmallest(HeapIntPriorityQueue heap, int k) { //find kthsmallest element in heap
    	Queue<Integer> queue = new LinkedList(); //declare new queue.
    	count = -1;
    	
    	if (k <= 0 || k > heap.size()) {
    		throw new IllegalArgumentException("Illegal arguments!");
    	}
    	
    	for (int i = 0; i < k; i++) { //add elements back into queue
    		count = heap.remove();
    		queue.add(count);
    	}    	
    	
    	//System.out.println(heap.toString());
    	//System.out.println(queue.toString());
    	
    	while (!queue.isEmpty()) { //remove from queue until empty.
    		heap.add(queue.remove());
    	}
    	   	
    	return count;
    }
    
    public void removeDuplicates(HeapIntPriorityQueue heap) { //removes duplicates
    	Queue<Integer> queue = new LinkedList(); //declare queue for auxiliary storage
    	div = heap.size() - 2;
    	i = 0;
    	
    	queue.add(heap.remove()); //add one element to queue to prevent null exception
    	while (i < div) { //add half of heap elements to queue.
    		int removed = heap.remove(); 
    		queue.add(removed); 
    		i++;
    	}
    	
    	while (!queue.isEmpty()) { //compare and add queue elements back into heap if not duplicate
    		for (int j = 1; j <= heap.size(); j++) {    			
    			if (queue.peek() == heap.elementData[j]) {
    				queue.remove();
    			}   			
    		}
    		    		
    		if (heap.size() == 1 && queue.peek() == heap.elementData[1]) { //if heap size is 1
    			queue.remove();
    			break; 
    		}
    		
    		if (queue.size() == 1) {
    			
    			if (queue.peek() == heap.elementData[1]) { //if queue size is 1
    				queue.remove();
    				break; 
    			}
    			
    			for (int k = 2; k <= heap.size(); k++) { //compare with heap elements
    				if (heap.elementData[k] == queue.peek()) {
    					queue.remove();
    				} 
    			}
    		}
    		
    		if (queue.size() == 0) { //check to see if queue is empty, to avoid no element exception;
    			break;
    		}
    		
    		heap.add(queue.remove());   		
    	}
    	    		
    }
  }
    
    
