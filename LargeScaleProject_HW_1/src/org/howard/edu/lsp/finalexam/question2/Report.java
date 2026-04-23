package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class defining the Template Method for generating reports.
 * Subclasses implement the variable steps; the overall workflow is fixed here.
 */
public abstract class Report {

    /**
     * Loads report-specific data into instance fields.
     * Subclasses set their own fields (e.g., studentName, gpa).
     */
    protected abstract void loadData();

    /**
     * Formats and prints the report header section.
     */
    protected abstract void formatHeader();

    /**
     * Formats and prints the report body section.
     */
    protected abstract void formatBody();

    /**
     * Formats and prints the report footer section.
     */
    protected abstract void formatFooter();

    /**
     * Template method — defines the fixed workflow for all reports.
     * Calls the abstract steps in the required order.
     */
    public final void generateReport() {
        loadData();

        System.out.println("=== HEADER ===");
        formatHeader();

        System.out.println("=== BODY ===");
        formatBody();

        System.out.println("=== FOOTER ===");
        formatFooter();
    }
}
