package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles reading and parsing of product data from CSV files.
 * This class is responsible for input validation, error handling,
 * and tracking statistics about the reading process.
 *
 * @author Generated
 * @reviewer Hamid Kabia
 * @version 1.0
 */
public class ProductReader {
    private int rowsRead;
    private int rowsSkipped;

    /**
     * Constructs a new ProductReader with zero statistics.
     */
    public ProductReader() {
        this.rowsRead = 0;
        this.rowsSkipped = 0;
    }

    /**
     * Reads products from a CSV file and returns a list of valid Product objects.
     * This method skips the header row, validates each line, and handles errors gracefully.
     * Invalid rows (empty lines, incorrect number of fields, parsing errors) are skipped
     * and counted in the statistics.
     *
     * @param filePath the path to the CSV file to read
     * @return a list of Product objects parsed from valid CSV rows
     * @throws IOException if an I/O error occurs while reading the file
     */
    public List<Product> readProducts(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Skip header line
            String line = reader.readLine();
            if (line == null) {
                // Empty file
                return products;
            }

            // Read and parse data lines
            while ((line = reader.readLine()) != null) {
                rowsRead++;

                // Skip empty lines
                line = line.trim();
                if (line.isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                // Parse the line
                String[] parts = line.split(",");

                // Validate field count
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    // Parse and create Product
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    BigDecimal price = new BigDecimal(parts[2].trim());
                    String category = parts[3].trim();

                    Product product = new Product(productId, name, price, category);
                    products.add(product);

                } catch (NumberFormatException e) {
                    // Invalid number format - skip this row
                    rowsSkipped++;
                }
            }
        }

        return products;
    }

    /**
     * Returns the number of data rows read from the file (excluding header).
     * This count includes both valid rows and rows that were skipped.
     *
     * @return the total number of rows read
     */
    public int getRowsRead() {
        return rowsRead;
    }

    /**
     * Returns the number of rows that were skipped due to validation errors.
     * This includes empty lines, lines with incorrect field counts,
     * and lines with unparseable data.
     *
     * @return the number of rows skipped
     */
    public int getRowsSkipped() {
        return rowsSkipped;
    }
}
