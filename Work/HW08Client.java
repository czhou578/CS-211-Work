/**
 * Colin Zhou
 * CS 211
 * 3/1/2020
 * Serves to test the three methods that were constructed in IntTree.java. 
 * @author mycol
 *
 */
public class HW08Client {
    public static void main(String[] args) {
        IntTree t = new IntTree(15);  //testing out cases with new tree of 15 nodes
        System.out.println("Tree structure:");
        t.printSideways(); //prints with indentation
        System.out.println();
        System.out.println("Number of Left Nodes: " + t.countLeftNodes()); //count left nodes
        System.out.println("Numbers at Level 3: ");
        t.printLevel(3); //print level 3
        System.out.println("Numbers at Level 10: ");
        t.printLevel(10); //print level 10
        System.out.println("Tree printed out:" + t.toString()); //prints the tree
        System.out.println();
        System.out.println();
        
        IntTree t2 = new IntTree(4); //tree with 4 nodes
        System.out.println("Tree structure: "); //prints with indentation
        t2.printSideways();
        System.out.println();
        System.out.println("Number of Left Nodes: " + t2.countLeftNodes()); //count left nodes
        System.out.println("Numbers at Level 3: "); //prints level 3
        t2.printLevel(3);
        System.out.println("Numbers at Level 1: "); //prints level 1
        t2.printLevel(1);
        System.out.println("Tree printed out:" + t2.toString()); //prints the tree
        System.out.println();
        System.out.println();
        
        IntTree t3 = new IntTree(2); //tree with 2 nodes
        System.out.println("Tree structure: "); //prints with indentation
        t3.printSideways();
        System.out.println();
        System.out.println("Number of Left Nodes: " + t3.countLeftNodes()); //count left nodes
        System.out.println("Numbers at Level 4: "); //prints level 4
        t3.printLevel(4);       
        System.out.println("Numbers at Level 2: "); //prints level 2
        t3.printLevel(2);       
        System.out.println("Tree printed out:" + t3.toString()); //prints the tree
        System.out.println();
        System.out.println();
        
        IntTree t4 = new IntTree(1); //tree with one node
        System.out.println("Tree structure: ");
        t4.printSideways();
        System.out.println();
        System.out.println("Number of Left Nodes: " + t4.countLeftNodes()); //count left nodes
        System.out.println("Numbers at Level 4: "); //prints level 4
        t4.printLevel(4);       
        System.out.println("Numbers at Level 1: "); //prints level 1
        t4.printLevel(1);       
        //System.out.println("Numbers at Level 0: "); //throws exception correctly
        //t4.printLevel(0);       
        System.out.println("Tree printed out:" + t4.toString()); //prints the tree
    }
}
