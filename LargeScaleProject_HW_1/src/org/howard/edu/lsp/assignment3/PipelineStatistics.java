package org.howard.edu.lsp.assignment3;

/**
 * Tracks and reports statistics for the ETL pipeline execution.
 * This class aggregates metrics from various pipeline components
 * and provides formatted summary output.
 *
 * @author Generated
 * @reviewer Hamid Kabia
 * @version 1.0
 */
public class PipelineStatistics {
    private final int rowsRead;
    private final int rowsTransformed;
    private final int rowsSkipped;

    /**
     * Constructs a PipelineStatistics object with the specified metrics.
     *
     * @param rowsRead the total number of rows read from the input file
     * @param rowsTransformed the number of rows successfully transformed and written
     * @param rowsSkipped the number of rows skipped due to validation errors
     */
    public PipelineStatistics(int rowsRead, int rowsTransformed, int rowsSkipped) {
        this.rowsRead = rowsRead;
        this.rowsTransformed = rowsTransformed;
        this.rowsSkipped = rowsSkipped;
    }

    /**
     * Prints a formatted summary of the pipeline execution statistics.
     * The output format matches the original implementation:
     * <pre>
     * Rows read: X
     * Rows transformed: X
     * Rows skipped: X
     * Output written to: [outputPath]
     * </pre>
     *
     * @param outputPath the path to the output file
     */
    public void printSummary(String outputPath) {
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }

    /**
     * Returns the number of rows read from the input file.
     *
     * @return the number of rows read
     */
    public int getRowsRead() {
        return rowsRead;
    }

    /**
     * Returns the number of rows successfully transformed.
     *
     * @return the number of rows transformed
     */
    public int getRowsTransformed() {
        return rowsTransformed;
    }

    /**
     * Returns the number of rows skipped due to errors.
     *
     * @return the number of rows skipped
     */
    public int getRowsSkipped() {
        return rowsSkipped;
    }
}
