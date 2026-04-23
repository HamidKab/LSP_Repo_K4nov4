package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GradeCalculator Test Suite")
public class GradeCalculatorTest {

    private GradeCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new GradeCalculator();
    }

    // ── average() ────────────────────────────────────────────────────────────

    @Test
    @DisplayName("average() returns correct mean of three scores")
    void testAverageOfThreeScores() {
        assertEquals(85.0, calc.average(80, 90, 85), 0.001);
    }

    // ── letterGrade() ────────────────────────────────────────────────────────

    @Test
    @DisplayName("letterGrade() returns correct letter for a given average")
    void testLetterGradeForBRange() {
        assertEquals("B", calc.letterGrade(83.5));
    }

    // ── isPassing() ──────────────────────────────────────────────────────────

    @Test
    @DisplayName("isPassing() returns true when average is at or above 60")
    void testIsPassingAboveThreshold() {
        assertTrue(calc.isPassing(75.0));
    }

    // ── Boundary-value tests ─────────────────────────────────────────────────

    @Test
    @DisplayName("Boundary: average of exactly 60 is passing and earns a D")
    void testBoundaryAverageExactly60() {
        double avg = calc.average(60, 60, 60);
        assertEquals(60.0, avg, 0.001);
        assertEquals("D", calc.letterGrade(avg));
        assertTrue(calc.isPassing(avg));
    }

    @Test
    @DisplayName("Boundary: average of exactly 90 earns an A")
    void testBoundaryAverageExactly90() {
        double avg = calc.average(90, 90, 90);
        assertEquals(90.0, avg, 0.001);
        assertEquals("A", calc.letterGrade(avg));
    }

    // ── Exception tests ──────────────────────────────────────────────────────

    @Test
    @DisplayName("Exception: score below 0 throws IllegalArgumentException")
    void testNegativeScoreThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(-1, 50, 50));
    }

    @Test
    @DisplayName("Exception: score above 100 throws IllegalArgumentException")
    void testScoreAbove100ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(50, 101, 50));
    }
}
