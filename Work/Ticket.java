
public abstract class Ticket {
	
	public int number;
	double price;
	
	public Ticket(int number) {
		this.number = number;
	}
	
	public abstract double getPrice();
	
	public String toString() {
		return "Number: " + number + ", " + "Price: " + price;
	}
	
}

class WalkUpTicket extends Ticket {
	public final double PRICE = 50.0;
	
	public WalkUpTicket(int number) {
		super(number);	
	}

	@Override
	public double getPrice() {
		return PRICE;
	}		
}

class AdvanceTicket extends Ticket {
	
	int days;
	public AdvanceTicket(int number, int days) {
		super(number);	
		this.days = days;
	}
	
	@Override
	public double getPrice() {
		if (days >= 10) {
			return 30;
		} else {
			return 40;
		}
	}
}

/*class StudentAdvanceTicket extends Ticket {
	
}*/
