package org.howard.edu.lsp.midterm.strategy;
/**
 * @author Hamid Kabia - 2024-06-01 Help with generative AI
 * PriceCalculator class calculates the price of an item based on a pricing strategy.
 */
public class PriceCalculator {
    private final PricingStrategy strategy;

    
    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the price of an item based on the assigned pricing strategy.
     * @param price the original price of the item
     * @return the calculated price
     */
    public double calculatePrice(double price) {
        return strategy.calculate(price);
    }
}
