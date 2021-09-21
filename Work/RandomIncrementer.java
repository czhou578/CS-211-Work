/**
 * Colin Zhou
 * CS 211
 * 1/9/2020
 * To demonstrate knowledge of interfaces.
 * @author mycol
 *
 */
import java.util.Random;

public class RandomIncrementer implements Incrementable {
	private int startValue;
	private int newValue;
	
	Random r = new Random();
	
	public RandomIncrementer() { // initializes startValue with a random number.
		startValue = r.nextInt();
		System.out.println("Starting Value: " + startValue); //to show starting value.
	}

	@Override
	public void increment() { // increments using random numbers every time method is called
		newValue = r.nextInt();
		
		if (newValue == startValue) {
			increment();
		}
	}

	@Override
	public int getValue() { // returns the value
		return newValue;
	}

}
