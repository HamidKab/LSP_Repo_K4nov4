package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * @description 
 * The code below defines the class IntegerSet the performs the following operations on two integer sets
 * Union, Intersect, Diff, Complement.
 * The set is created using Javas ArrayList Util and well as the linkedHashSet to deal with duplicates
 * @author Hamid Kabia
 * 
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

    /**
     * 
     * @param IntegerSet
     * @description Check whether two sets are equal I.E [1, 2, 3] == [3, 1, 2]
     * @return Bool True or False
     */
    public boolean equals(IntegerSet b) {
        return set.containsAll(b.set) && b.set.containsAll(set);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.max(set);
    }

    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
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

    /**
    @param IntegerSet the other IntegerSet to be combined with this set
    @return IntegerSet result
    *@description Returns the union of this set and another set.
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

    /**
    * @param IntegerSet the other IntegerSet to be intersected with this set
    * @description the intersection of this set and another set using addAll and retainAll methods to find common elements
    * @return result
    */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(set);
        result.set.retainAll(intSetb.set);
        return result;
    }
    /**
    * @param IntegerSet
    * @description the difference of this set and another set using addAll and removeAll methods to find elements that are in this set but not in the other.
    * @return result
    */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(set);
        result.set.removeAll(intSetb.set);
        return result;
    }
    /**
    * @param IntegerSet
    * @description the complement of this set with respect to another set using addAll and removeAll methods.
    * @return result
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
