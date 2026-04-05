This design may lead to extensibility issues because everything is hard coded.For example if a new tier of customer to come you'd have to change the source code to add the functionality. Additional price calculator has to many reasons to change like modifying discounts rates or calculation logic.

package org.howard.edu.lsp.midterm.strategy;

public class PriceCalculator {

    public double calculatePrice(String customerType, double price) {

        double finalPrice = price;

        if (customerType.equals("REGULAR")) {
            finalPrice = price;
        }

        if (customerType.equals("MEMBER")) {
            finalPrice = price * 0.90;
        }

        if (customerType.equals("VIP")) {
            finalPrice = price * 0.80;
        }

        if (customerType.equals("HOLIDAY")) {
            finalPrice = price * 0.85;
        }

        return finalPrice;
    }
}
