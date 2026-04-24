Heuristic 1:

Name:
Do not create god classes

Explanation:
God classes are classes that hold large amount of code and methods. This makes classes unreadable because there exist many classes and methods within that god class. By avoiding god classes and splitting the classes up a programmer can make his code more readable because future programmers will not have to read through thousands of lines of code to find a bug within the class. When explained in the lecture we used the example of the home heating system

Heuristic 2:

Name:
The classes have common data but not common operations

Explanation:
When explaining this in class we used many examples one of them being the customer inheritance. With a class customer having customer id and credit card no many of the classes needed this information. Instead of rewriting the value in each class it is ok for that class to transmit that information down to other classes such as web refund but the refund does not need to send anything up to the customer class

Heuristic 3:

Name:
Inheritance should be used only to model a specialization hierarchy.

Explanation:
A child should keep true to the parent. A Dog should be an Animal, A circle Is a shape. In lecture we discussed that with inheritance we want to avoid granting inheritance to classes that have Has-a relationships and focus on Is-a relations.