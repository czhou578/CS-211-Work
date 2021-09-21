
public class SequentialIncrementer implements Incrementable {
	private int startValue;
	
	public SequentialIncrementer() { //initializes to 0
		startValue = 0;
	}

	@Override
	public void increment() { //increments by one 
		startValue++;
	}

	@Override
	public int getValue() { //return value		
		return startValue;
	}
	
}
