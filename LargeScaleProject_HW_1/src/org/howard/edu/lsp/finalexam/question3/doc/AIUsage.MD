tools: Claude code

Prompt
I want to write JUnit Test
- Write JUnit 5 test cases only
- Do NOT write a Driver
- Do NOT include a written explanation
- Use clear test method names
- Focus on correctness and boundary cases
Base the test on the following code Snippet 
package org.howard.edu.lsp.finalexam.question3;

public class GradeCalculator {

    public double average(int score1, int score2, int score3) {
        validateScore(score1);
        validateScore(score2);
        validateScore(score3);
        return (score1 + score2 + score3) / 3.0;
    }

    public String letterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    public boolean isPassing(double average) {
        return average >= 60;
    }

    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }
}
Please include
1. One test for average()
2. One test for letterGrade()
3. One test for isPassing()
4. Two boundary-value tests
5. Two exception tests using assertThrows()
Generate tests including the ones stated above and place them in
GradeCalculatorTest.java
package org.howard.edu.lsp.finalexam.question3

Response
GradeCalculatorTest.java is ready. Here's what's covered:

Test	Method	Purpose
testAverageOfThreeScores	average()	Correct mean calculation
testLetterGradeForBRange	letterGrade()	Correct letter assignment
testIsPassingAboveThreshold	isPassing()	Returns true above 60
testBoundaryAverageExactly60	all three	Boundary: exactly 60 is D and passing
testBoundaryAverageExactly90	average() + letterGrade()	Boundary: exactly 90 is an A
testNegativeScoreThrowsException	average()	Score < 0 throws IllegalArgumentException
testScoreAbove100ThrowsException	average()	Score > 100 throws IllegalArgumentException

Reflection:
The tool as effectively able to spin out working testcases for the gradeCalculator. I had to meter it some and give it some suggestions but it ultimately created working testcases.