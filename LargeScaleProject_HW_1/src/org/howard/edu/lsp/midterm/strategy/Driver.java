package org.howard.edu.lsp.midterm.strategy;
/**
 * @author Hamid Kabia - 2024-06-01 Help with generative AI
 * Driver class for testing the PriceCalculator with different pricing strategies.
 */
public class Driver {
    public static void main(String[] args) {
        double price = 100.0;

        System.out.println("REGULAR: " + new PriceCalculator(Pricing::regular).calculatePrice(price));
        System.out.println("MEMBER: "  + new PriceCalculator(Pricing::member).calculatePrice(price));
        System.out.println("VIP: "     + new PriceCalculator(Pricing::vip).calculatePrice(price));
        System.out.println("HOLIDAY: " + new PriceCalculator(Pricing::holiday).calculatePrice(price));
    }
}
