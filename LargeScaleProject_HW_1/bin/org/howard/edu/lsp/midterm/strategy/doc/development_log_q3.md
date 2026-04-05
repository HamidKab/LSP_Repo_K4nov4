https://www.sanity.io/glossary/extensibility: Helped me understand extensibilty rules
AI:
why might the design in the code not be extendable or maintainable according to object oriented design rules
response:
The PriceCalculator design violates several key object-oriented design principles:

Open/Closed Principle (OCP) Violation
The class is closed to extension but open to modification—the opposite of what OCP requires. Every new customer type requires modifying the existing code and adding another if statement. This means:

You must change the source code to add functionality
Risk of breaking existing code when making changes
Violates the principle that classes should be "open for extension, closed for modification"
Single Responsibility Principle (SRP) Violation
The PriceCalculator has too many reasons to change:

Adding a new customer type changes it
Modifying a discount rate changes it
Changing the discount calculation logic changes it
It should have one reason to change—ideally just the core price calculation approach.

Additional Issues
Hard-coded magic values: Discount rates (0.90, 0.80, 0.85) are embedded in the code, making them difficult to maintain or configure.

Stringly-typed (String customerType): Using strings for type classification is error-prone, not type-safe, and prone to typos or case-sensitivity issues.

Poor testability: Adding new customer types requires recompiling and modifying source code.

Better Approaches
This is in a "strategy" folder—the Strategy Pattern would be ideal:

Create a PricingStrategy interface with implementations like RegularCustomerStrategy, MemberStrategy, etc.
Each strategy encapsulates its discount logic
Adding new customer types requires creating new strategy classes, not modifying existing code
This achieves true extensibility while satisfying OCP and SRP

prompt:
come up with a plan to refactor the design in this file. show me the crcs before attempting to implement so we can discuss cutting fluff class
response:
CRC Cards
PricingStrategy (interface)
Responsibilities	Collaborators
Define contract: calculate(double price): double	—
RegularPricing
Responsibilities	Collaborators
Return price unchanged (no discount)	PricingStrategy
MemberPricing
Responsibilities	Collaborators
Apply 10% discount (price * 0.90)	PricingStrategy
VIPPricing
Responsibilities	Collaborators
Apply 20% discount (price * 0.80)	PricingStrategy
HolidayPricing
Responsibilities	Collaborators
Apply 15% discount (price * 0.85)	PricingStrategy
PriceCalculator
Responsibilities	Collaborators
Accept a PricingStrategy at construction	PricingStrategy
Delegate calculatePrice(double) to the strategy	all concrete strategies
Discussion
The concrete strategy classes (RegularPricing, MemberPricing, VIPPricing, HolidayPricing) each contain a single line of logic. They could be considered fluff — particularly RegularPricing, which does nothing but return the original price.

Options:

Keep all 4 — cleanest extensibility, every tier is explicit
Drop RegularPricing — treat no-discount as the default in PriceCalculator (e.g., return price if no strategy set)
Collapse all into lambdas — skip the concrete classes entirely, pass price -> price * 0.90 directly
Which do you want to go with before I implement?

prompt:
Can we create a pricing Class with private or public methods that does the same thing as all the pricing classes you have right now
response:

The user wants to consolidate all the concrete pricing classes into a single class with methods for each pricing type, rather than having separate classes for each. This would be a simpler approach - one class with methods like regularPrice(), memberPrice(), vipPrice(), holidayPrice().

Let me think about the revised CRC cards:

PricingStrategy (interface)
Responsibilities	Collaborators
Define contract: calculate(double price): double	—
Pricing
Responsibilities	Collaborators
regularPrice(double price) - return price unchanged	PricingStrategy
| memberPrice(double price) - apply 10% discount | PricingStrategy |
| vipPrice(double price) - apply 20% discount | PricingStrategy |
| holidayPrice(double price) - apply 15% discount | PricingStrategy |

PriceCalculator
Responsibilities	Collaborators
Accept a PricingStrategy at construction	PricingStrategy, Pricing
Delegate calculatePrice(double) to the strategy	Pricing
Now I'm realizing there's a tension here - if Pricing has all these concrete methods, how does it actually use the PricingStrategy interface? The strategy pattern expects the concrete implementations to be separate classes, not methods on a single class.

Actually, I think the user wants to consolidate everything into one Pricing class with static methods that return PricingStrategy instances. So instead of separate concrete classes, Pricing would have static factory methods like regular(), member(), vip(), and holiday() that each return a strategy implementation. Then PriceCalculator just takes whichever strategy is passed to it and delegates the calculation.

Let me sketch out the CRC cards to show how this would work.

Good call — that cuts 4 classes down to 1. Here are the revised CRC cards:

Revised CRC Cards
PricingStrategy (interface)
Responsibilities	Collaborators
Define contract: calculate(double price): double	—
Pricing
Responsibilities	Collaborators
regular(double price) — return price unchanged	PricingStrategy
member(double price) — apply 10% discount	PricingStrategy
vip(double price) — apply 20% discount	PricingStrategy
holiday(double price) — apply 15% discount	PricingStrategy
Methods are static — no instantiation needed. Passed to PriceCalculator as method references (Pricing::member, etc.)

PriceCalculator
Responsibilities	Collaborators
Accept a PricingStrategy at construction	PricingStrategy
Delegate calculatePrice(double) to the stored strategy	Pricing
Class count: 3 total (was 6)
Usage would look like:


PriceCalculator calc = new PriceCalculator(Pricing::vip);
calc.calculatePrice(100.0); // → 80.0
Should the methods in Pricing be static (no object needed, used as method references) or instance (you'd create a new Pricing() and call methods on it)? Static is cleaner here since there's no state to hold. Confirm and I'll implement.

prompt:
Implement this plan in the package org.howard.edu.lsp.midterm.strategy
Each class must be placed in its own .java file. Your implementation should demonstrate the use of the Strategy design pattern to support different discount behaviors.

Create a Driver class that demonstrates that your Strategy Pattern implementation works correctly.
Your Driver class must be placed in the package:
org.howard.edu.lsp.midterm.strategy
Your driver must demonstrate the following cases using a purchase price of 100.0:
• REGULAR customer
• MEMBER customer
• VIP customer
• HOLIDAY customer
Your driver must produce output in the following format:
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0
he output must be produced by executing your Strategy-based implementation, not by hardcoding the results.
response:
# Plan: Strategy Pattern Refactor — PriceCalculator

## Context
The original `PriceCalculator` uses hardcoded `if` chains on a `customerType` string. Adding a new tier requires modifying the source. The refactor applies the **Strategy pattern**: each discount rule becomes a strategy, and `PriceCalculator` delegates to whichever strategy it is given. All concrete strategies are consolidated into one `Pricing` class (static methods) to avoid class proliferation.

## Package
`org.howard.edu.lsp.midterm.strategy`

## Files to Create

### 1. `PricingStrategy.java` — functional interface
```java
package org.howard.edu.lsp.midterm.strategy;

public interface PricingStrategy {
    double calculate(double price);
}
```

### 2. `Pricing.java` — all discount logic in one class, static methods
```java
package org.howard.edu.lsp.midterm.strategy;

public class Pricing {
    public static double regular(double price)  { return price; }
    public static double member(double price)   { return price * 0.90; }
    public static double vip(double price)      { return price * 0.80; }
    public static double holiday(double price)  { return price * 0.85; }
}
```

### 3. `PriceCalculator.java` — accepts strategy, delegates calculation
```java
package org.howard.edu.lsp.midterm.strategy;

public class PriceCalculator {
    private final PricingStrategy strategy;

    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(double price) {
        return strategy.calculate(price);
    }
}
```

### 4. `Driver.java` — demonstrates all 4 cases with price 100.0
```java
package org.howard.edu.lsp.midterm.strategy;

public class Driver {
    public static void main(String[] args) {
        double price = 100.0;

        System.out.println("REGULAR: " + new PriceCalculator(Pricing::regular).calculatePrice(price));
        System.out.println("MEMBER: "  + new PriceCalculator(Pricing::member).calculatePrice(price));
        System.out.println("VIP: "     + new PriceCalculator(Pricing::vip).calculatePrice(price));
        System.out.println("HOLIDAY: " + new PriceCalculator(Pricing::holiday).calculatePrice(price));
    }
}
```

## Expected Output
```
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0
```

## Verification
Run `Driver.main()` — output must match the four lines above exactly. No hardcoded values in Driver; all prices flow through `PriceCalculator` → `PricingStrategy` → `Pricing` static method.
