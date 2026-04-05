package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * The following code represents an implementation of an IntegerSet class that provides various set operations 
 * such as union, intersection, difference, and complement. 
 * The class uses an ArrayList to store the unique integers in the set and includes methods for adding, removing, and checking for the presence of integers.
 * It also includes methods to find the largest and smallest integers in the set, as well as a method to clear the set and check if it is empty. 
 * The toString method provides a sorted representation of the set for easy visualization.
 * @author Generated
 * @Reviewer Hamid Kabia
 */

public class IntegerSet {
    private ArrayList<Integer> set = new ArrayList<Integer>();

    public IntegerSet() {
    }

    public void clear() {
        set.clear();
    }

    public int length() {
        return set.size();
    }

    public boolean equals(IntegerSet b) {
        return set.containsAll(b.set) && b.set.containsAll(set);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        return Collections.max(set);
    }

    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        return Collections.min(set);
    }

    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /*
    * Returns the union of this set and another set.
    *creates a temporary LinkedHashSet to store the unique elements from both sets
    * It then adds elements from the temporary set to the result IntegerSet before returning it.
    * this is for duplication handling    
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        LinkedHashSet<Integer> temp = new LinkedHashSet<>();
        temp.addAll(set);
        temp.addAll(intSetb.set);
        result.set.addAll(temp);
        return result;
    }

    /* Returns the intersection of this set and another set using addAll and retainAll methods to find common elements
    */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(set);
        result.set.retainAll(intSetb.set);
        return result;
    }
    /*
    * Returns the difference of this set and another set using addAll and removeAll methods to find elements that are in this set but not in the other.
    */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(set);
        result.set.removeAll(intSetb.set);
        return result;
    }
    /*
    * Returns the complement of this set with respect to another set using addAll and removeAll methods.
    */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(intSetb.set);
        result.set.removeAll(set);
        return result;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<Integer>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
