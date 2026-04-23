Tools: Claude Code, https://refactoring.guru/design-patterns/template-method

- Write clean Java code with javadocs.
- Focus on maintainable design.
- Follow Template Method pattern correctly.
Template Method Overview
You must design a report system using Template Method with a fixed workflow and variable steps.
Required Workflow
loadData → formatHeader → formatBody → formatFooter → generateReport
Data Requirements
StudentReport: studentName (String), gpa (double)
CourseReport: courseName (String), enrollment (int)
Values must be set in loadData() and used in output.
Output Format
=== HEADER ===
<report-specific header>

=== BODY ===
<report-specific body>

=== FOOTER ===
<report-specific footer>
Driver Requirements
- Use List<Report>
- Add StudentReport and CourseReport
- Loop through list
- Call generateReport()
- Demonstrate polymorphism

response:
# Plan: Complete Question 2 Submission

## Context
The user is completing a final exam question requiring a Template Method pattern implementation in Java. Three source files (Report.java, StudentReport.java, CourseReport.java) are already written. Two files remain:
1. `Driver.java` — runs the demo using `List<Report>` and polymorphism


## Files to Write

### 1. Driver.java
Path: `LargeScaleProject_HW_1/src/org/howard/edu/lsp/finalexam/question2/Driver.java`
- Creates a `List<Report>`, adds `StudentReport` and `CourseReport`
- Loops and calls `generateReport()` on each — demonstrates polymorphism

## No IDE diagnostic fix
The compiler warning about preview features is a language server config issue unrelated to the code; ignore it.

Explanation

I used refactoring.guru to better understand the Template method. I did this to better meter the response of the AI. I did not want to have blind faith in its implementation. 

Reflection:
I better understand the template method and its implementation using abstraction to breakdown algorithms into series of steps.