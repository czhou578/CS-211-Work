/**
 * Colin Zhou
 * CS 211
 * 1/7/2020
 * To demonstrate conceptual understanding of inheritance concepts. 
 * @author mycol
 *
 */
public class DiscountBillClient {
	
	public static void main (String[]args) {
		Employee employee = new Employee("Colin");
		DiscountBill bill = new DiscountBill(employee, true);
		
		Item item1 = new Item("Potatoes", 3.20, 0); //items purchased at store
		Item item2 = new Item("Cereal", 4.20, 2);
		Item item3 = new Item("Milk", 3.20, 0);		
		Item item4 = new Item("Sauce", 4, 1.50);
				
		bill.add(item1); //adding the items to the bill object.
		bill.add(item2);
		bill.add(item3);
		bill.add(item4);
		
		//testing the methods of DiscountBill. 
		System.out.println("Total price: " + bill.getTotal());				
		System.out.println("Total Discount: " + bill.getDiscountAmount());		
		System.out.println("Discounted items: " + bill.getDiscountCount());
		
	}
}
