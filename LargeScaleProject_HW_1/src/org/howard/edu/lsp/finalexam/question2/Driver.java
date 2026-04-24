package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver demonstrating the Template Method pattern through polymorphism.
 * Each Report subtype is treated uniformly via the Report reference.
 */
public class Driver {

    /**
     * Entry point. Adds a {@link StudentReport} and a {@link CourseReport} to a
     * {@code List<Report>} and calls {@code generateReport()} on each, demonstrating
     * polymorphism through the Template Method pattern.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        for (Report report : reports) {
            report.generateReport();
        }
    }
}
