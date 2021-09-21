/**
 * Colin Zhou
 * CS 211
 * 1/7/2020
 * To demonstrate conceptual understanding of inheritance concepts. 
 * @author mycol
 *
 */
public class DiscountBill extends GroceryBill {
	
	private boolean preferred;
	private double discount;
	private int discountAmount;
	
	public DiscountBill(Employee clerk, boolean preferred) {
		super(clerk);
		this.preferred = preferred;
		discount = 0.0;
		discountAmount = 0;
	}
	
	public void add(Item i) { //adds items to discount bill.
		super.add(i);
		if (preferred && i.getDiscount() > 0) {
			discountAmount++;
			discount+= i.getDiscount();
		}
	}
		
	public int getDiscountCount() { //calculates amount of discounted items;
		
		return discountAmount;		
	}
	
	public double getDiscountAmount() { //calculates total discounted amount
		
		return discount;
		
	}
	
	public double getDiscountPercent() { //computes percentage of total bill that is discounted.
		
		return ((getTotal() - discount) / getTotal());
	}

}
