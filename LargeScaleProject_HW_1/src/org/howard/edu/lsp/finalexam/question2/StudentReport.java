package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a student, displaying the student's name and GPA.
 * Implements the variable steps defined as abstract in {@link Report}.
 */
public class StudentReport extends Report {

    private String studentName;
    private double gpa;

    /**
     * Loads student-specific data into {@code studentName} and {@code gpa}.
     * These fields are used by the format steps during report generation.
     */
    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    /**
     * Prints the header for the student report, identifying the report type.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Student Report");
        System.out.println();
    }

    /**
     * Prints the body of the student report, including the student's name and GPA.
     */
    @Override
    protected void formatBody() {
        System.out.println("Student Name: " + studentName);
        System.out.println("GPA: " + gpa);
        System.out.println();
    }

    /**
     * Prints the footer for the student report, signaling the end of the report.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Student Report");
        System.out.println();
    }
}
