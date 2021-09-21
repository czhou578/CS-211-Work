
/*
 * Colin Zhou
 * CS 211
 * 1/23/2020
 * To show a conceptual understanding of how to use maps and keys to 
 * retrieve information.
 *
 * WordCount uses a map to implement a word count, so that the user can see 
 * which words occur the most frequently in the book "Moby Dick". Note the use
 * of a class constant to govern the output size.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {
    // minimum number of occurrences needed to be printed
    public static final int OCCURRENCES = 1000;
    
    public static void main(String[] args) 
            throws FileNotFoundException {
        System.out.println("This program displays the most");
        System.out.println("frequently occurring words from");
        System.out.println("the book Moby Dick in ascending order.");
        System.out.println();
        
        // read the book into a map
        Scanner in = new Scanner(new File("C:\\Users\\mycol\\CS 211\\CS 211 Work\\src\\mobydick.txt"));
        in.useDelimiter("[^a-zA-Z']+"); //gets rid of punctuation
        Map<String, Integer> wordCountMap = getCountMap(in);
        Map<String, Integer>treemap = new TreeMap<String,Integer>();
        ArrayList<Integer>numList = new ArrayList<Integer>();
        
        for (String word : wordCountMap.keySet()) { //iterate through treemap and add to new treemap
            int count = wordCountMap.get(word);
            if (count > OCCURRENCES) {
            	treemap.put(word, count);          	
            	numList.add(count); //add values to arraylist
            }
        }
        Collections.sort(numList); //sort arraylist in ascending order
        
        
        for (Integer number: numList) {
        	for(Entry<String, Integer> entry : treemap.entrySet()) { //iterate and match the keys/values
        		if (number.equals(entry.getValue())) {
        			String key = entry.getKey();
        			System.out.println(key + ": " + entry.getValue()); //prints out key and values.   			
        		}
        	}      
        	
        }
    }
    
    public static Map<String, Integer> getCountMap(Scanner in) {
        Map<String, Integer> wordCountMap = new TreeMap<String, Integer>();

        while (in.hasNext()) {
            String word = in.next().toLowerCase();
            if (!wordCountMap.containsKey(word)) {
                // never seen this word before
                wordCountMap.put(word, 1);
            } else {
                // seen this word before; increment count
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            }
        }
        
        return wordCountMap;
    }
}

