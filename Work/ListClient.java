/**
 * Colin Zhou
 * CS 211
 * 2/15/2020
 * To demonstrate conceptual understanding of LinkedList concepts
 * and how they work.
 * @author mycol
 * 
 * Note: I assumed that nobody would want to remove something from a list with nothing,
 * so that possibility was omitted. Thanks - Colin
 *
 */
public class ListClient {
    public static void main(String[] args) {
    	
        LinkedIntList list1 = new LinkedIntList();
        System.out.println("list1: " + list1);
        list1.switchPairs();
        System.out.println("After calling switchPairs: " + list1);
        System.out.println("\n");
        
        LinkedIntList list2 = new LinkedIntList(); //create new LinkedIntlist
        processList(list2); //fill up with integers
        System.out.println("list2: " + list2);
        list2.switchPairs(); //testing method 
        System.out.println("Result after calling switchPairs: " + list2);
        list2.removeFront(5); //testing method
        System.out.println("Result after calling removeFront: " + list2);
        System.out.println("\n");
        
        LinkedIntList list3 = new LinkedIntList(); //create new LinkedIntlist for testing w/ size 1
        list3.add(2);
        System.out.println("list3: " + list3);
        list3.switchPairs();	//testing
        System.out.println("Result after calling switchPairs with size 1: " + list3);
        list3.remove(0);	//testing
        System.out.println("List after calling remove with size 1: " + list3);
        System.out.println("\n");
        
        LinkedIntList list4 = new LinkedIntList(); //create new LinkedIntlist
        list4.add(2); //fill up with integers
        list4.add(6);
        list4.add(13);
        list4.add(19);
        System.out.println("list4: " + list4);
        list4.switchPairs(); //testing method 
        System.out.println("Result after calling switchPairs: " + list4);
        list4.removeFront(2); //testing method
        System.out.println("Result after calling removeFront: " + list4);
        System.out.println("\n");

        
    }

    public static void processList(IntList list) { //add numbers to the list
        list.add(18);
        list.add(27);
        list.add(93);
        list.add(45);
        list.add(13);
        list.add(86);	
        list.add(27);
        list.add(21);
        list.add(34);
        list.add(52);
    }
}
