package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a course, displaying the course name and enrollment count.
 * Implements the variable steps defined as abstract in {@link Report}.
 */
public class CourseReport extends Report {

    private String courseName;
    private int enrollment;

    /**
     * Loads course-specific data into {@code courseName} and {@code enrollment}.
     * These fields are used by the format steps during report generation.
     */
    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    /**
     * Prints the header for the course report, identifying the report type.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Course Report");
        System.out.println();
    }

    /**
     * Prints the body of the course report, including the course name and enrollment count.
     */
    @Override
    protected void formatBody() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
        System.out.println();
    }

    /**
     * Prints the footer for the course report, signaling the end of the report.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Course Report");
        System.out.println();
    }
}
