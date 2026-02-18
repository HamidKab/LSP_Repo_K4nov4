package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Applies business logic transformations to products.
 * This class handles all data transformation logic including name formatting,
 * price adjustments, category transformations, and price range calculations.
 *
 * @author Generated
 * @reviewer Hamid Kabia
 * @version 1.0
 */
public class ProductTransformer {

    /**
     * Transforms a product by applying all business rules.
     * The transformations applied are:
     * <ul>
     *   <li>Convert product name to uppercase</li>
     *   <li>Apply 10% discount to Electronics category</li>
     *   <li>Round price to 2 decimal places</li>
     *   <li>Transform "Electronics" to "Premium Electronics" if price > $500 after discount</li>
     *   <li>Calculate and assign price range (Low, Medium, High, Premium)</li>
     * </ul>
     *
     * @param input the product to transform
     * @return a new Product instance with all transformations applied
     */
    public Product transform(Product input) {
        // Store original category before any transformations
        String originalCategory = input.getCategory();

        // Convert name to uppercase
        String name = input.getName().toUpperCase();

        // Apply discount if Electronics
        BigDecimal price = input.getPrice();
        if (originalCategory.equals("Electronics")) {
            price = price.multiply(new BigDecimal("0.9"));
        }

        // Round price to 2 decimal places
        price = price.setScale(2, RoundingMode.HALF_UP);

        // Determine category (check for Premium Electronics)
        String category = originalCategory;
        if (originalCategory.equals("Electronics") &&
            price.compareTo(new BigDecimal("500.00")) > 0) {
            category = "Premium Electronics";
        }

        // Calculate price range
        String priceRange = calculatePriceRange(price);

        // Return new transformed product
        return input.withAttributes(name, price, category, priceRange);
    }

    /**
     * Calculates the price range classification based on the product price.
     * The ranges are:
     * <ul>
     *   <li>Low: price ≤ $10.00</li>
     *   <li>Medium: $10.00 < price ≤ $100.00</li>
     *   <li>High: $100.00 < price ≤ $500.00</li>
     *   <li>Premium: price > $500.00</li>
     * </ul>
     *
     * @param price the product price
     * @return the price range classification
     */
    private String calculatePriceRange(BigDecimal price) {
        if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            return "Low";
        } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            return "Medium";
        } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            return "High";
        } else {
            return "Premium";
        }
    }
}
