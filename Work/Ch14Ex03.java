/**
 * Colin Zhou
 * CS 211
 * 1/31/2020
 * To demonstrate conceptual understanding of stack/queue concepts
 * @author mycol
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ch14Ex03 {

	public static void main(String[] args) {
		Stack<Integer>demo = new Stack<Integer>(); //creating test stack
		for (int i = 0; i < 15; i++) {
			demo.push(i);
		}
		System.out.println("Before: " + Arrays.deepToString(demo.toArray())); //printing
		System.out.println("After: " + Arrays.deepToString(copyStack(demo).toArray()));
		
	}
	
	public static Stack copyStack(Stack<Integer>stack) { 
		Queue<Integer>queue = new LinkedList<Integer>(); //initialize queue/stack
		Stack<Integer>stack2 = new Stack<Integer>();
		while (!stack.isEmpty()) {
			stack2.push(stack.pop()); //transfer elements to stack
		}
		 
		while (!stack2.isEmpty()) { //transfer elements to queue
			queue.add(stack2.pop());
		}
		
		while (!queue.isEmpty()) {
			stack.push(queue.remove()); //transfer elements to original stack
		}
		
		return stack;
	}

}
