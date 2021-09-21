/**
 * Colin Zhou
 * CS 211
 * 2/1/2020
 * To demonstrate conceptual understanding of stack and queue based methods
 * @author mycol
 *
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HW04 {
	public static void main(String[]args) {
		Queue<Integer>q = new LinkedList<Integer>(); //create demo queue
		for (int i = 0; i <= 9; i++) {
			q.add(i);
		}
		System.out.println("Before: " + Arrays.deepToString(q.toArray())); //print
		rearrange(q);
		
		Stack<Integer> demo = new Stack<Integer>(); //create demo		
		demo.push(7);
		demo.push(12);
		demo.push(3);
		demo.push(10);
		demo.push(5);
		demo.push(1);
		System.out.println("Before: " + Arrays.deepToString(demo.toArray())); //print
		expunge(demo);
		
	}
	
	public static void rearrange(Queue<Integer>queue) { //Ch 14 Ex 6
		Stack<Integer> stack = new Stack<Integer>(); //use push, pop, peek
		Stack<Integer>stack2 = new Stack<Integer>();
		Queue<Integer>queue2 = new LinkedList<Integer>();		
		Queue<Integer>finalQueue = new LinkedList<Integer>();
		while(!queue.isEmpty()) {
			if (queue.peek() % 2 == 0) {
				stack.push(queue.remove()); //add evens to stack
			} else {
				queue2.add(queue.remove()); //add odds to queue2
			}
		}
		
		while(!stack.isEmpty()) { //add evens to second stack to change order
			stack2.push(stack.pop());
		}
		
		while(!stack2.isEmpty()) { //add to final queue
			finalQueue.add(stack2.pop());
		}
		
		while(!queue2.isEmpty()) { //add to final queue from queue2
			finalQueue.add(queue2.remove());
		}
		System.out.println("Sorted queue: " + Arrays.deepToString(finalQueue.toArray()));
	}
	
	public static void expunge(Stack<Integer>stack) {//Ch 14 Ex13
		Stack<Integer> stack2 = new Stack<Integer>();  //auxiliary stack
		while(!stack.isEmpty()) {
			int element = stack.pop();
			if (stack.peek() < element) { //compare with the head of stack
				stack.pop();
			}
			stack2.add(element); //add briefly stored element to stack2
		}
		
		while(!stack2.isEmpty()) { //add back into the parameter array
			stack.push(stack2.pop());
		}
		System.out.println("Final Stack: " + stack);
	}
	
}
