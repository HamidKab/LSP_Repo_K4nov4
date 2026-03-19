package org.howard.edu.lsp.midterm.strategy;
/**
 * @author Hamid Kabia - 2024-06-01 Help with generative AI
 * Pricing class provides static methods for different pricing strategies.
 */
public class Pricing {
    public static double regular(double price)  { return price; }
    public static double member(double price)   { return price * 0.90; }
    public static double vip(double price)      { return price * 0.80; }
    public static double holiday(double price)  { return price * 0.85; }
}
