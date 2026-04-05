This class appears to be a god class with all the different classes and methods in it. This a bad design because it does not allow for abstraction, polymorphism, or encapsulation. All the data to run the code is in the same class which does not align with encapsulation principles of Object Oriented Design. It doesnt abide by polymorphism because all the methods are in the same class making the design procedural for example calculating and transforming price could be a different class as well as code writing to the file. The code also lacks abstraction due to the fact that it fails to hide the complexity of the code

import java.io.FileWriter;
import java.util.Date;

public class OrderProcessor{

    // Order data (poor encapsulation)
    public String customerName;
    public String email;
    public String item;
    public double price;

    public void processOrder() {

        // calculate tax
        double tax = price * 0.07;
        double total = price + tax;

        // print receipt
        System.out.println("Customer: " + customerName);
        System.out.println("Item: " + item);
        System.out.println("Total: " + total);

        // save order to file
        try {
            FileWriter writer = new FileWriter("orders.txt", true);
            writer.write(customerName + "," + item + "," + total + "\n");
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        // send confirmation email
        System.out.println("Sending confirmation email to " + email);

        // apply discount
        if(price > 500) {
            total = total * 0.9;
        }

        // log activity
        System.out.println("Order processed at " + new Date());
    }
}