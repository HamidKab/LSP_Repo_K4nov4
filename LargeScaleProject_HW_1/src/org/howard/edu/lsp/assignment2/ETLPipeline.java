package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsWritten = 0;
        int rowsSkipped = 0;

        // Handle missing file
        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {
            // Writing file header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            String line = reader.readLine(); 
            if (line == null) {
                // empty file
                printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);
                return;
            }

            while ((line = reader.readLine()) != null) {
                rowsRead++;

                line = line.trim();
                if (line.isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim().toUpperCase();
                    BigDecimal price = new BigDecimal(parts[2].trim());
                    String category = parts[3].trim();

                    String originalCategory = category;

                    // Apply 10% discount
                    if (category.equals("Electronics")) {
                        price = price.multiply(new BigDecimal("0.9"));
                    }

                    // Round price
                    price = price.setScale(2, RoundingMode.HALF_UP);

                    // Premium electronics check
                    if (
                        originalCategory.equals("Electronics") &&
                        price.compareTo(new BigDecimal("500.00")) > 0
                    ) {
                        category = "Premium Electronics";
                    }

                    // Price range
                    String priceRange;
                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    // Write output
                    writer.write(
                        productId + "," +
                        name + "," +
                        price.toString() + "," +
                        category + "," +
                        priceRange
                    );
                    writer.newLine();

                    rowsWritten++;

                } catch (Exception e) {
                    rowsSkipped++;
                }
            }

            printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);

        } catch (IOException e) {
            System.out.println("ERROR: Failed to process files.");
        }
    }

    private static void printSummary(
        int read, int written, int skipped, String outputPath
    ) {
        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + written);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output written to: " + outputPath);
    }
}
