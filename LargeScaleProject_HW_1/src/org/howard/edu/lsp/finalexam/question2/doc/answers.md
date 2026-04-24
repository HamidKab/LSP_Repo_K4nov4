Design Explanation

The Template Method suggests that you break an algorithm down to a series of steps. It is applied here through the abstract report class, which defines generateReport() as a final template that enforces the required work flow I.e (loadData → formatHeader → formatBody → formatFooter → generateReport). The driver demonstrates polymorphism by storing both report types in List<Report> and calling generateReport(). 


