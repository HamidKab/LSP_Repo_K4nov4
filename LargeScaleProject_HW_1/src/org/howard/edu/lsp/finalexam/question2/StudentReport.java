package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a student, displaying name and GPA.
 */
public class StudentReport extends Report {

    private String studentName;
    private double gpa;

    /** Sets student data used by the format steps. */
    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    @Override
    protected void formatHeader() {
        System.out.println("Student Report");
        System.out.println();
    }

    @Override
    protected void formatBody() {
        System.out.println("Student Name: " + studentName);
        System.out.println("GPA: " + gpa);
        System.out.println();
    }

    @Override
    protected void formatFooter() {
        System.out.println("End of Student Report");
        System.out.println();
    }
}
