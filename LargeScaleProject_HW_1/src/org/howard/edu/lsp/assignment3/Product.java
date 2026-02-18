package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a product with its associated attributes.
 * This is an immutable value object used throughout the ETL pipeline.
 * Once created, the product's attributes cannot be modified, ensuring
 * data integrity across the pipeline stages.
 *
 * @author Generated
 * @reviewer Hamid Kabia
 * @version 1.0
 */
public class Product {
    private final int productId;
    private final String name;
    private final BigDecimal price;
    private final String category;
    private final String priceRange;

    /**
     * Constructs a Product with the specified attributes.
     *
     * @param productId the unique identifier for this product
     * @param name the product name
     * @param price the product price
     * @param category the product category
     * @param priceRange the price range classification (Low, Medium, High, Premium)
     */
    public Product(int productId, String name, BigDecimal price, String category, String priceRange) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = priceRange;
    }

    /**
     * Constructs a Product without a price range (used for input parsing).
     * The price range will be null and should be set during transformation.
     *
     * @param productId the unique identifier for this product
     * @param name the product name
     * @param price the product price
     * @param category the product category
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this(productId, name, price, category, null);
    }

    /**
     * Returns the product ID.
     *
     * @return the unique identifier for this product
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product price.
     *
     * @return the product price as a BigDecimal
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Returns the product category.
     *
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the price range classification.
     *
     * @return the price range (Low, Medium, High, or Premium), or null if not set
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Creates a new Product instance with the same attributes but with a specified price range.
     * This method is used during transformation to add the price range.
     *
     * @param priceRange the price range to set
     * @return a new Product instance with the specified price range
     */
    public Product withPriceRange(String priceRange) {
        return new Product(this.productId, this.name, this.price, this.category, priceRange);
    }

    /**
     * Creates a new Product instance with updated attributes.
     * This method is used during transformation to apply changes while maintaining immutability.
     *
     * @param name the new product name
     * @param price the new product price
     * @param category the new product category
     * @param priceRange the price range classification
     * @return a new Product instance with the specified attributes
     */
    public Product withAttributes(String name, BigDecimal price, String category, String priceRange) {
        return new Product(this.productId, name, price, category, priceRange);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", priceRange='" + priceRange + '\'' +
                '}';
    }
}
