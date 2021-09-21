public class ArrayIntListDriver { //to test out ArrayIntList

	public static void main(String[] args) {
		ArrayIntList list1 = new ArrayIntList(); //creating new lists
		ArrayIntList list2 = new ArrayIntList();
		ArrayIntList list3 = new ArrayIntList();// sublist
		
		list1.add(3);
		list1.add(8);
		list1.add(1);
		list1.add(5);
		list1.add(8);
		list1.add(9);
		list1.add(13);
		list1.add(20);
		
		list3.add(5);
		list3.add(8);
		list3.add(9);
		
		System.out.println("Original List 1: " + list1.toString()); //printing lists to begin
		System.out.println("Original List 2: " + list2.toString());
		System.out.println("\n");
		
		System.out.println("Last Index of 8 in list 1: " + list1.lastIndexOf(8)); //Testing #1
		System.out.println("Last Index of 5 in list 1: " + list1.lastIndexOf(5));
		System.out.println("Last Index of 15 in list 1: " + list1.lastIndexOf(15));
		System.out.println("Last Index of 1 in list 2: " + list2.lastIndexOf(1));
		System.out.println("\n");
		
		System.out.println("Sublist: " + list3.toString()); //printing list3 to show.
		System.out.println("Starting Index of Sublist: " + list1.indexofSubList(list3)); //Testing #2
		System.out.println("Starting Index of empty Sublist 2: " + list3.indexofSubList(list2));
		System.out.println("Starting index of list 3 in empty list 2: " + list2.indexofSubList(list3));
		System.out.println("\n");
		
		System.out.println("Running total of list 1: " + list1.runningTotal().toString()); //Testing #5
		System.out.println("Running total of list 2: " + list2.runningTotal().toString());
		System.out.println("\n");
		
		System.out.println("Occurrences of 8 in list 1: " + list1.count(8));//Testing #8
		System.out.println("Occurrences of 7 in list 1: " + list1.count(7));
		System.out.println("Occurrences of 10 in empty list 2: " + list2.count(10));
		System.out.println("\n");
		
		System.out.println("Remove element from empty list 2: " + list2.removeLast()); //Testing #11
		System.out.println("First removed element from list 1: " + list1.removeLast());
		System.out.println("Second removed element from list 1: " + list1.removeLast());
		System.out.println("Third removed element from list 1: " + list1.removeLast());

	}

}
