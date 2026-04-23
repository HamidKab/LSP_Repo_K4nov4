Design Explanation

The Template method suggest that you break an algorithm down to a series of steps. it is a applied here through the abstract report class, which defiens generateReport() As a final template that enforces the required work flow I.e (loadData → formatHeader → formatBody → formatFooter → generateReport). The driver demonstrates polymorphism by storing both report types in List<Report> and calling generateReport(). 

The printing the section labels and calling the abstract methods in correct other live in generateReport() and cannot be overridden by subclasses.

The variable steps (loadData, formatHeader, formatBody, formatFooter) are declared abstract, forcing each subclass (StudentReport, CourseReport) to supply its own report-specific content without being able to alter the overall sequence.
