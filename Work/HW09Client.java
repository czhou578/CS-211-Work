import java.util.LinkedList;
import java.util.Queue;

/**
 * Colin Zhou
 * CS 211
 * 3/8/2020
 * Problems 9 and 11 with regards to heap concepts are written here.
 * Serves to test HeapIntPriorityQueue class with corresponding objects and method demonstrations.
 * Also serves to test HashIntSet with corresponding objects and method printouts.
 * Thank you for making this quarter memorable! - Colin
 * @author mycol
 *
 */

public class HW09Client {
    private int count;
    private int div;
    private int i;
    private int[] elementData;

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


    public static void main(String[] args) {
        HashIntSet set1 = new HashIntSet(); //creating new hashset.
        set1.add(7);
        set1.add(5);
        set1.add(1);
        set1.add(9);
        set1.add(14);
        
        HashIntSet set2 = new HashIntSet(); //creation of new hashset.
        set2.add(0);
        set2.add(5);
        set2.add(16);
        set2.add(-19);
        set2.add(12);
        set2.add(124);
        set2.add(23);
        
        HashIntSet set3 = new HashIntSet(); //creation of new hashset that is empty.

        HeapIntPriorityQueue pq = new HeapIntPriorityQueue(); //creating priority queues.
        HeapIntPriorityQueue heap = new HeapIntPriorityQueue();       
        HeapIntPriorityQueue heap2 = new HeapIntPriorityQueue();       
        HeapIntPriorityQueue heap3 = new HeapIntPriorityQueue();       
        HeapIntPriorityQueue heap4 = new HeapIntPriorityQueue();       
        HeapIntPriorityQueue heap5 = new HeapIntPriorityQueue();       
        int[] elements = {65, 50, 20, 90, 44, 60, 80, 70, 99, 10}; //creating arrays to feed into queues.
        int[] elements2 = {60, 50, 20, 44, 44, 60, 80, 70, 99, 10};
        int[] elements3 = {};
        int[] elements4 = {11, 11, 11};
        int[] elements5 = {11, 11, 11, 13};
        int[] elements6 = {13, 13, 15, 15};
        
        System.out.println("Adding all elements to respective arrays.");
        
        for (int n : elements) { //add all elements to heap pq.
            pq.add(n);
            System.out.println(pq);
        }
        
        for (int n : elements2) { //add all elements to heap
           heap.add(n);
            System.out.println(heap);
        }
        
        for (int n : elements3) { //add all elements to heap 2
            heap2.add(n);
             System.out.println(heap2);
         }

        for (int n : elements4) { //add all elements to heap 3
            heap3.add(n);
             System.out.println(heap3);
         }
      
        for (int n : elements5) { //add all elements to heap 4
            heap4.add(n);
             System.out.println(heap4);
         }
        
        for (int n : elements6) { //add all elements to heap 4
            heap5.add(n);
             System.out.println(heap5);
         }
        
        System.out.println("Testing of Problem # 1, 2, 3 starts below");
        System.out.println();
                        
        System.out.println("First HashSet: " + set1.toString()); //print before any manipulation     
        System.out.println("Second HashSet: " + set2.toString());
        System.out.println("Third HashSet: " + set3.toString());
        
        System.out.println("Does set 1 contain all set 2 integers? " + set1.containsAll(set2)); //testing out containsAll
        System.out.println("Does set 1 equal set 2? " + set1.equals(set2)); //testing out equals method.
        System.out.println(); //create line break
        
        System.out.println("Does set 1 contain all set 3 integers? " + set1.containsAll(set3));
        System.out.println("Does set 1 equal set 3? " + set1.equals(set3)); //testing out equals method.
        System.out.println();
        
        
        set1.addAll(set2); //add all elements from set 2 into set 1
        System.out.println("Set 1 after adding all integers in set 2: " + set1.toString());
        System.out.println("Set 2 after adding to Set 1: " + set2.toString());
        System.out.println("Does set 1 equal set 2? " + set1.equals(set2)); //testing out equals method.         
        System.out.println("Does set 1 contain all set 2 integers? " + set1.containsAll(set2)); //testing out containsAll.
        System.out.println();
        
        set3.addAll(set1); //add all elements from set 1 into set 3
        System.out.println("Set 3 after adding all integers in set 1: " + set3.toString());
        System.out.println("Set 1 after adding to Set 3: " + set1.toString());
        System.out.println("Does set 3 equal set 1? " + set3.equals(set1)); //testing out equals method.         
        System.out.println("Does set 3 contain all set 1 integers? " + set3.containsAll(set1)); //testing out containsAll.
        System.out.println();
        System.out.println();
        
        System.out.println("Additional tests from original unedited test client.");
        
        // test adding duplicates
        set1.add(7);
        set1.add(7);
        set1.add(5);
        
        // test collisions and linked lists
        set1.add(45);
        set1.add(91);
        set1.add(71);
        
        // test rehashing
        set1.add(810);   // re-hash should occur here (8/10, load = 0.8)
        set1.add(62);
        set1.add(1238);
        set1.add(-99);
        set1.add(-30);
        set1.add(42);
        set1.add(49857);
        set1.add(1520);  // re-hash should occur here (15/20, load = 0.75)
        set1.add(2);
        set1.add(31);
        set1.add(11);
        set1.add(21);
        
        // test removal
        set1.remove(7);
        set1.remove(9);
        set1.remove(1);
        set1.remove(1);
        set1.remove(21);
        set1.remove(71);
        
        for (int n : new int[] {1520, 99, 2, 55, 42, 11, 45, 0, 5, -10, 810}) {
			System.out.println("contains " + n + "? " + set1.contains(n));
		}
        
        System.out.println(set1 + ", size " + set1.size());
        
        System.out.println();
        System.out.println("Testing Problem # 9 and 11 starts below.");
        System.out.println();
               
        System.out.println("Starting heap pq: " + pq.toString()); //testing kthSmallest method.
        System.out.println("The 3rd smallest element in pq is: " + pq.kthSmallest(pq, 3));
        System.out.println("Heap pq after operation: " + pq.toString());
        System.out.println();
        
        System.out.println("Starting heap2: " + heap2.toString()); //testing kthSmallest method, throws exception in this case.
        //System.out.println("The kth smallest element in heap2 is: " + heap2.kthSmallest(heap2, 3));
        System.out.println("Heap heap2 after operation: " + heap2.toString());
        System.out.println();
        
        System.out.println("Starting heap3: " + heap3.toString()); //testing kthSmallest method
        System.out.println("The 1st smallest element in heap3 is: " + heap3.kthSmallest(heap3, 1));
        System.out.println("Heap heap3 after operation: " + heap3.toString());
        System.out.println();
        
        System.out.println("Starting heap4: " + heap4.toString()); //testing kthSmallest method
        System.out.println("The 3rd smallest element in heap4 is: " + heap4.kthSmallest(heap4, 3));
        System.out.println("Heap heap4 after operation: " + heap4.toString());
        System.out.println();
        
        System.out.println("Before removing duplicates: " + pq.toString()); //testing removeDuplicates method
        pq.removeDuplicates(pq);
        System.out.println("After removing duplicates: " + pq.toString());
        
        System.out.println("Before removing duplicates: " + heap.toString()); //testing removeDuplicates method
        heap.removeDuplicates(heap);
        System.out.println("After removing duplicates: " + heap.toString());

        System.out.println("Before removing duplicates: " + heap2.toString()); //testing removeDuplicates method
        //heap2.removeDuplicates(heap2);//throws exception correctly
        System.out.println("After removing duplicates: " + heap2.toString());
        
        System.out.println("Before removing duplicates: " + heap3.toString()); //testing removeDuplicates method
        heap3.removeDuplicates(heap3);
        System.out.println("After removing duplicates: " + heap3.toString());
        
        System.out.println("Before removing duplicates: " + heap4.toString()); //testing removeDuplicates method
        heap4.removeDuplicates(heap4);
        System.out.println("After removing duplicates: " + heap4.toString());
        
        System.out.println("Before removing duplicates: " + heap5.toString()); //testing removeDuplicates method
        heap5.removeDuplicates(heap5);
        System.out.println("After removing duplicates: " + heap5.toString());
        System.out.println();
    }

}

