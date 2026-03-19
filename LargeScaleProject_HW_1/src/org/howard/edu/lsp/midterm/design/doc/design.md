Class: 
    Order
Responsibilities:
    Store customer name, email, item, and price; Enforce field-level validation
Collaborators:

Class:
    TaxCalculator
Responsibilities:
	Tax calc, discount logic, final total
Collaborators:
    Order

Class:
    ReceiptPrinter
Responsbilities:
    Format & print receipt
Collaborators:
    Order, TaxCalculator

Class:
	OrderRepository
Responsibilities:
	Persist order record to file using try-with-resources; Handle file I/O exceptions at the appropriate level
Collaborators:	
    Order, TaxCalculator

Class:
	EmailService
Responsibilities:
	Send confirmation email to customer
Collaborators:
	Order

Class:
	OrderProcessor
Responsibilities:
	Coordinate the full order workflow: calculate totals → print receipt → save to file → send email →  log events with timestamp
Collaborators:
	Order, TaxCalculator, ReceiptPrinter, OrderRepository, EmailService