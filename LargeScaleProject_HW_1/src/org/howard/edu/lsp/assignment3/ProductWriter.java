package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.List;

/**
 * Handles writing transformed product data to CSV files.
 * This class formats products as CSV output and tracks writing statistics.
 *
 * @author Generated
 * @reviewer Hamid Kabia
 * @version 1.0
 */
public class ProductWriter {
    private int rowsWritten;

    /**
     * Constructs a new ProductWriter with zero statistics.
     */
    public ProductWriter() {
        this.rowsWritten = 0;
    }

    /**
     * Writes a list of products to a CSV file.
     * The output file will have a header row followed by one row per product.
     * The CSV format is: ProductID,Name,Price,Category,PriceRange
     *
     * @param products the list of products to write
     * @param filePath the path to the output CSV file
     * @throws IOException if an I/O error occurs while writing the file
     */
    public void writeProducts(List<Product> products, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            // Write each product
            for (Product product : products) {
                String line = formatProductAsCSV(product);
                writer.write(line);
                writer.newLine();
                rowsWritten++;
            }
        }
    }

    /**
     * Formats a product as a CSV line.
     * The format is: ProductID,Name,Price,Category,PriceRange
     *
     * @param product the product to format
     * @return the CSV-formatted string representation of the product
     */
    private String formatProductAsCSV(Product product) {
        return product.getProductId() + "," +
               product.getName() + "," +
               product.getPrice().toString() + "," +
               product.getCategory() + "," +
               product.getPriceRange();
    }

    /**
     * Returns the number of product rows written to the output file.
     * This count does not include the header row.
     *
     * @return the number of rows written
     */
    public int getRowsWritten() {
        return rowsWritten;
    }
}
