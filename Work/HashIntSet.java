/**
 * Colin Zhou
 * CS 211
 * 3/8/2020
 * Serves to implement methods addAll(add all elements of passed in set to current set), determine whether
 * current set containsAll elements from passed in set, and whether both sets are equal.
 * @author mycol
 *
 */

// Implements a set of integers using a hash table.
// The hash table uses separate chaining to resolve collisions.
public class HashIntSet {
    private static final double MAX_LOAD_FACTOR = 0.75;
    public HashEntry[] elementData;
    private int size;
    
    // Constructs an empty set.
    public HashIntSet() {
        elementData = new HashEntry[10];
        size = 0;
    }
    
    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(int value) {
        if (!contains(value)) {
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }
            
            // insert new value at front of list
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry(value, elementData[bucket]);
            size++;
        }
    }
    
    // Removes all elements from the set.
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }
    
    // Returns true if the given value is found in this set.
    public boolean contains(int value) {
        int bucket = hashFunction(value);
        HashEntry current = elementData[bucket];
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(int value) {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data == value) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry current = elementData[bucket];
                while (current.next != null && current.next.data != value) {
                    current = current.next;
                }
                
                // if the element is found, remove it
                if (current.next != null && current.next.data == value) {
					current.next = current.next.next;
					size--;
				}
            }
        }
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }
    
    
    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(int value) {
        return Math.abs(value) % elementData.length;
    }
    
    private double loadFactor() {
        return (double) size / elementData.length;
    }
    
    // Resizes the hash table to twice its former size.
    private void rehash() {
        // replace element data array with a larger empty version
        HashEntry[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;

        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry current = oldElementData[i];
            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }
    
    public void addAll(HashIntSet set) { //adds all elements from passed in set to current set.  	
    	for (int j = 0; j < set.elementData.length; j++) {
    		HashEntry value = set.elementData[j];
    		
    		while (value != null) { //loops through and adds elements to current set object.
    			if (!this.contains(value.data)) {
    				this.add(value.data);
    			}
    			value = value.next;
    		}
    		
      	}
    	
    }
    
    public boolean containsAll(HashIntSet set) { //contains all elements from passed in set.
    	for (int i = 0; i < set.elementData.length; i++) {
    		
    		while (set.elementData[i] != null) {
    			if (!this.contains(set.elementData[i].data)) { //if doesn't contain, return null.
    				return false;
    			}
    			break;
    		}
    	} 
    	return true;
    }
    
    public boolean equals(HashIntSet set) { //whether set completely equals passed in set.
    	if (!this.containsAll(set)) {
    		return false;
    	}
    	
    	for (int i = 0; i < this.elementData.length; i++) { //identifies equal elements
    		while (this.elementData[i] != null) {
    			if (!set.contains(this.elementData[i].data)) {
    				return false;
    			}
    			break;
    		}
    	}
    	return true;
    }
    
    // Represents a single value in a chain stored in one hash bucket.
    public class HashEntry {
        public int data;
        public HashEntry next;

        public HashEntry(int data) {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }
    
}
