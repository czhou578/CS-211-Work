/**
 * Colin Zhou
 * CS 211
 * 2/22/2020
 * Constructs a simple binary tree recursively and also implements three methods
 * that print the tree, counts left nodes, and prints only one level of the tree specified.
 * @author mycol
 *
 */

import java.util.*;

public class IntTree {
    private IntTreeNode overallRoot;
    private int countNode;
    private int level;
    private String string;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
    
    private int countLeftNodes(IntTreeNode root) { //preorder traversal
    	if (root == null) { //base case
    		return -1;
    	}
    	
    	countLeftNodes(root.left);
    	   	
    	if (root.left != null) {
    		countNode++;
    	} 
    	
    	countLeftNodes(root.right);
    	
    	return countNode;
    	
    }
    
    public int countLeftNodes() { //runs private method
    	
    	return countLeftNodes(overallRoot);
    }
       
    private void printLevel(IntTreeNode root, int n) { //keep recursively shifting the current root
    	if (root == null) {
    		return;
    	}
    	
    	if (n == 1) { //base case
    		System.out.println(root.data);
    		return;
    	}
    	   	
    	printLevel(root.left, n - 1);
    	printLevel(root.right, n - 1);   	
    }
    
     
    
    public void printLevel(int n) { //runs private method
    	if (n < 1) {
    		throw new IllegalArgumentException();
    	}
    	
    	printLevel(overallRoot, n);
    }
    
    private String toString(IntTreeNode root) { //prints tree as String
    	if (root == null) { //empty tree
    		return "empty";
    	}
    	
    	if (root.right == null && root.left == null) { //root only case
    		return "" + root.data;
    	} 
    	
    	return "(" + root.data + ", " + toString(root.left) + ", " + toString(root.right) + ")";
    	
    }
    
    public String toString() { //runs private method
    	
    	return toString(overallRoot);
    }
}