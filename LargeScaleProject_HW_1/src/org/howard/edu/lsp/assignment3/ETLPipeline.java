package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main ETL (Extract, Transform, Load) pipeline orchestrator.
 * This class coordinates the entire data processing workflow by delegating
 * specific responsibilities to specialized components:
 * <ul>
 *   <li>ProductReader: handles input CSV reading and parsing</li>
 *   <li>ProductTransformer: applies business logic transformations</li>
 *   <li>ProductWriter: handles output CSV writing</li>
 *   <li>PipelineStatistics: tracks and reports execution metrics</li>
 * </ul>
 *
 * The pipeline reads product data from a CSV file, applies transformations,
 * writes the results to an output file, and reports execution statistics.
 *
 * @author Generated
 * @reviewer Hamid Kabia
 * @version 1.0
 */
public class ETLPipeline {

    /**
     * Main entry point for the ETL pipeline.
     * Orchestrates the complete Extract-Transform-Load process.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        // Check if input file exists
        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        try {
            // Create pipeline components
            ProductReader reader = new ProductReader();
            ProductTransformer transformer = new ProductTransformer();
            ProductWriter writer = new ProductWriter();

            // Extract: Read products from CSV
            List<Product> products = reader.readProducts(inputPath);

            // Transform: Apply business logic to each product
            List<Product> transformedProducts = new ArrayList<>();
            for (Product product : products) {
                Product transformed = transformer.transform(product);
                transformedProducts.add(transformed);
            }

            // Load: Write transformed products to CSV
            writer.writeProducts(transformedProducts, outputPath);

            // Report statistics
            PipelineStatistics statistics = new PipelineStatistics(
                reader.getRowsRead(),
                writer.getRowsWritten(),
                reader.getRowsSkipped()
            );
            statistics.printSummary(outputPath);

        } catch (IOException e) {
            System.out.println("ERROR: Failed to process files.");
        }
    }
}
