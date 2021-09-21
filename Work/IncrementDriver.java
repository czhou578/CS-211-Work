
public class IncrementDriver {

	public static void main(String[] args) {
		RandomIncrementer incrementer = new RandomIncrementer();
		incrementer.increment();
		System.out.println("New increment value: " + incrementer.getValue());
		
		SequentialIncrementer incrementer2 = new SequentialIncrementer();
		System.out.println("Starting value: " + incrementer2.getValue());
		incrementer2.increment();
		incrementer2.increment();
		incrementer2.increment();
		System.out.println("New increment value: " + incrementer2.getValue());
	}

}
