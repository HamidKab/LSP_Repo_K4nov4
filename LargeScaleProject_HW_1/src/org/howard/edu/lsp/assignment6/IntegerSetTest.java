package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Instructor-level JUnit 5 test suite for IntegerSet.
 * Covers normal behavior, edge cases, and immutability contracts
 * for every public method.
 */
@DisplayName("IntegerSet Test Suite")
public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    // -------------------------------------------------------------------------
    // clear()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("clear() on populated set results in empty set")
    void testClearPopulatedSet() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
        assertEquals(0, set1.length());
    }

    @Test
    @DisplayName("clear() on already-empty set does not throw")
    void testClearEmptySet() {
        assertDoesNotThrow(() -> set1.clear());
        assertTrue(set1.isEmpty());
    }

    // -------------------------------------------------------------------------
    // isEmpty()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("isEmpty() returns true for new set")
    void testIsEmptyOnNewSet() {
        assertTrue(set1.isEmpty());
    }

    @Test
    @DisplayName("isEmpty() returns false after add")
    void testIsEmptyAfterAdd() {
        set1.add(5);
        assertFalse(set1.isEmpty());
    }

    @Test
    @DisplayName("isEmpty() returns true after clear")
    void testIsEmptyAfterClear() {
        set1.add(5);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    // -------------------------------------------------------------------------
    // length()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("length() returns 0 for empty set")
    void testLengthEmptySet() {
        assertEquals(0, set1.length());
    }

    @Test
    @DisplayName("length() returns correct count after adds")
    void testLengthAfterAdds() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length());
    }

    @Test
    @DisplayName("length() does not increase on duplicate add")
    void testLengthDuplicateAdd() {
        set1.add(7);
        set1.add(7);
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("length() decrements after remove")
    void testLengthAfterRemove() {
        set1.add(1);
        set1.add(2);
        set1.remove(1);
        assertEquals(1, set1.length());
    }

    // -------------------------------------------------------------------------
    // add()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("add() inserts element into empty set")
    void testAddToEmptySet() {
        set1.add(10);
        assertTrue(set1.contains(10));
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("add() ignores duplicate values")
    void testAddDuplicate() {
        set1.add(3);
        set1.add(3);
        assertEquals(1, set1.length());
        assertTrue(set1.contains(3));
    }

    @Test
    @DisplayName("add() supports negative integers")
    void testAddNegativeValue() {
        set1.add(-5);
        assertTrue(set1.contains(-5));
    }

    @Test
    @DisplayName("add() supports zero")
    void testAddZero() {
        set1.add(0);
        assertTrue(set1.contains(0));
    }

    // -------------------------------------------------------------------------
    // remove()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("remove() deletes an existing element")
    void testRemoveExistingElement() {
        set1.add(1);
        set1.add(2);
        set1.remove(1);
        assertFalse(set1.contains(1));
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("remove() on non-existent element does not throw or change size")
    void testRemoveNonExistentElement() {
        set1.add(1);
        assertDoesNotThrow(() -> set1.remove(99));
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("remove() on empty set does not throw")
    void testRemoveFromEmptySet() {
        assertDoesNotThrow(() -> set1.remove(5));
        assertTrue(set1.isEmpty());
    }

    // -------------------------------------------------------------------------
    // contains()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("contains() returns true for existing element")
    void testContainsExistingElement() {
        set1.add(42);
        assertTrue(set1.contains(42));
    }

    @Test
    @DisplayName("contains() returns false for absent element")
    void testContainsAbsentElement() {
        set1.add(1);
        assertFalse(set1.contains(99));
    }

    @Test
    @DisplayName("contains() returns false on empty set")
    void testContainsOnEmptySet() {
        assertFalse(set1.contains(0));
    }

    @Test
    @DisplayName("contains() works for negative integers")
    void testContainsNegative() {
        set1.add(-10);
        assertTrue(set1.contains(-10));
        assertFalse(set1.contains(10));
    }

    // -------------------------------------------------------------------------
    // largest()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("largest() throws IntegerSetException on empty set")
    void testLargestEmptySet() {
        assertThrows(IllegalStateException.class, () -> set1.largest());
    }

    @Test
    @DisplayName("largest() returns the only element in a singleton set")
    void testLargestSingleElement() {
        set1.add(7);
        assertEquals(7, set1.largest());
    }

    @Test
    @DisplayName("largest() returns the maximum from multiple elements")
    void testLargestMultipleElements() {
        set1.add(3);
        set1.add(1);
        set1.add(9);
        set1.add(5);
        assertEquals(9, set1.largest());
    }

    @Test
    @DisplayName("largest() works correctly with all negative values")
    void testLargestAllNegative() {
        set1.add(-1);
        set1.add(-5);
        set1.add(-3);
        assertEquals(-1, set1.largest());
    }

    @Test
    @DisplayName("largest() works correctly with mixed negative and positive values")
    void testLargestMixedValues() {
        set1.add(-10);
        set1.add(0);
        set1.add(10);
        assertEquals(10, set1.largest());
    }

    // -------------------------------------------------------------------------
    // smallest()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("smallest() throws IntegerSetException on empty set")
    void testSmallestEmptySet() {
        assertThrows(IllegalStateException.class, () -> set1.smallest());
    }

    @Test
    @DisplayName("smallest() returns the only element in a singleton set")
    void testSmallestSingleElement() {
        set1.add(7);
        assertEquals(7, set1.smallest());
    }

    @Test
    @DisplayName("smallest() returns the minimum from multiple elements")
    void testSmallestMultipleElements() {
        set1.add(3);
        set1.add(1);
        set1.add(9);
        set1.add(5);
        assertEquals(1, set1.smallest());
    }

    @Test
    @DisplayName("smallest() works correctly with all negative values")
    void testSmallestAllNegative() {
        set1.add(-1);
        set1.add(-5);
        set1.add(-3);
        assertEquals(-5, set1.smallest());
    }

    @Test
    @DisplayName("smallest() works correctly with mixed negative and positive values")
    void testSmallestMixedValues() {
        set1.add(-10);
        set1.add(0);
        set1.add(10);
        assertEquals(-10, set1.smallest());
    }

    // -------------------------------------------------------------------------
    // equals()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("equals() returns true for identical sets")
    void testEqualsIdenticalSets() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(1); set2.add(2); set2.add(3);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("equals() returns true regardless of insertion order")
    void testEqualsOrderIndependent() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(3); set2.add(1); set2.add(2);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("equals() returns false when sets differ in size")
    void testEqualsDifferentSize() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(2); set2.add(3);
        assertFalse(set1.equals(set2));
    }

    @Test
    @DisplayName("equals() returns false when sets share size but differ in content")
    void testEqualsDifferentContent() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(3);
        assertFalse(set1.equals(set2));
    }

    @Test
    @DisplayName("equals() returns true for two empty sets")
    void testEqualsBothEmpty() {
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("equals() returns false when one set is empty")
    void testEqualsOneEmpty() {
        set1.add(1);
        assertFalse(set1.equals(set2));
        assertFalse(set2.equals(set1));
    }

    // -------------------------------------------------------------------------
    // union()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("union() combines overlapping sets without duplicates")
    void testUnionOverlapping() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.union(set2);
        assertEquals("[1, 2, 3, 4]", result.toString());
    }

    @Test
    @DisplayName("union() of disjoint sets contains all elements")
    void testUnionDisjoint() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        IntegerSet result = set1.union(set2);
        assertEquals("[1, 2, 3, 4]", result.toString());
    }

    @Test
    @DisplayName("union() with one empty set returns a copy of the other")
    void testUnionOneEmpty() {
        set1.add(1); set1.add(2);
        IntegerSet result = set1.union(set2);
        assertEquals("[1, 2]", result.toString());
    }

    @Test
    @DisplayName("union() of two empty sets is empty")
    void testUnionBothEmpty() {
        IntegerSet result = set1.union(set2);
        assertEquals("[]", result.toString());
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("union() does not modify the original sets")
    void testUnionDoesNotMutateOriginals() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.union(set2);
        assertEquals("[1, 2]", set1.toString());
        assertEquals("[3, 4]", set2.toString());
    }

    // -------------------------------------------------------------------------
    // intersect()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("intersect() returns only common elements")
    void testIntersectOverlapping() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.intersect(set2);
        assertEquals("[2, 3]", result.toString());
    }

    @Test
    @DisplayName("intersect() of disjoint sets is empty")
    void testIntersectDisjoint() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        IntegerSet result = set1.intersect(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("intersect() with one empty set is empty")
    void testIntersectOneEmpty() {
        set1.add(1); set1.add(2);
        IntegerSet result = set1.intersect(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("intersect() of two empty sets is empty")
    void testIntersectBothEmpty() {
        IntegerSet result = set1.intersect(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("intersect() of identical sets returns same elements")
    void testIntersectIdentical() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(1); set2.add(2); set2.add(3);
        IntegerSet result = set1.intersect(set2);
        assertEquals("[1, 2, 3]", result.toString());
    }

    @Test
    @DisplayName("intersect() does not modify the original sets")
    void testIntersectDoesNotMutateOriginals() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        set1.intersect(set2);
        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[2, 3, 4]", set2.toString());
    }

    // -------------------------------------------------------------------------
    // diff()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("diff() returns elements in set1 not in set2")
    void testDiffOverlapping() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.diff(set2);
        assertEquals("[1]", result.toString());
    }

    @Test
    @DisplayName("diff() against disjoint set returns all of set1")
    void testDiffDisjoint() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        IntegerSet result = set1.diff(set2);
        assertEquals("[1, 2]", result.toString());
    }

    @Test
    @DisplayName("diff() when set2 is a superset of set1 returns empty")
    void testDiffSet2Superset() {
        set1.add(2); set1.add(3);
        set2.add(1); set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.diff(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("diff() against empty set2 returns all of set1")
    void testDiffSet2Empty() {
        set1.add(1); set1.add(2);
        IntegerSet result = set1.diff(set2);
        assertEquals("[1, 2]", result.toString());
    }

    @Test
    @DisplayName("diff() of two empty sets is empty")
    void testDiffBothEmpty() {
        IntegerSet result = set1.diff(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("diff() does not modify the original sets")
    void testDiffDoesNotMutateOriginals() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        set1.diff(set2);
        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[2, 3, 4]", set2.toString());
    }

    // -------------------------------------------------------------------------
    // complement()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("complement() returns elements in set2 not in set1")
    void testComplementOverlapping() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.complement(set2);
        assertEquals("[4]", result.toString());
    }

    @Test
    @DisplayName("complement() when sets are disjoint returns all of set2")
    void testComplementDisjoint() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        IntegerSet result = set1.complement(set2);
        assertEquals("[3, 4]", result.toString());
    }

    @Test
    @DisplayName("complement() when set2 is subset of set1 returns empty")
    void testComplementSet2Subset() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3);
        IntegerSet result = set1.complement(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("complement() with empty set2 returns empty")
    void testComplementSet2Empty() {
        set1.add(1); set1.add(2);
        IntegerSet result = set1.complement(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("complement() of two empty sets is empty")
    void testComplementBothEmpty() {
        IntegerSet result = set1.complement(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("complement() does not modify the original sets")
    void testComplementDoesNotMutateOriginals() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        set1.complement(set2);
        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[2, 3, 4]", set2.toString());
    }

    // -------------------------------------------------------------------------
    // toString()
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("toString() returns [] for empty set")
    void testToStringEmpty() {
        assertEquals("[]", set1.toString());
    }

    @Test
    @DisplayName("toString() returns correct format for single element")
    void testToStringSingleElement() {
        set1.add(5);
        assertEquals("[5]", set1.toString());
    }

    @Test
    @DisplayName("toString() returns elements in ascending order regardless of insertion order")
    void testToStringAscendingOrder() {
        set1.add(3);
        set1.add(1);
        set1.add(2);
        assertEquals("[1, 2, 3]", set1.toString());
    }

    @Test
    @DisplayName("toString() formats negative numbers in ascending order")
    void testToStringNegativeNumbers() {
        set1.add(-1);
        set1.add(-5);
        set1.add(-3);
        assertEquals("[-5, -3, -1]", set1.toString());
    }

    @Test
    @DisplayName("toString() formats mixed negative and positive in ascending order")
    void testToStringMixedNumbers() {
        set1.add(5);
        set1.add(-2);
        set1.add(0);
        assertEquals("[-2, 0, 5]", set1.toString());
    }
}
