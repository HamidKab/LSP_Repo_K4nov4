Reflection

In these projects we were tasked with creating a pipeline that could read a csv file and transform the data according to the requirements. However, although the tasks are the same the implementation of them are extremely different.

Assignment 2

This assignment was more an exercise in the language of Java rather than an exercise in Object Oriented programming. The design is very procedural with all the methods being called within the same file. The program first opens the input file and creates a reader and writer. It then checks for empty files and incorrectly formatted lines (i.e too many fields or too few fields) while counting the number of rows read and lines skipped. It then splits the fields into parts and transforms the csv accordingly, writing the new information to the writer while counting the number of lines written. The program then prints out how many rows were read, transformed, or skipped. This design does not follow many OOP design concepts and is procedural.

Assignment 3

Assignment 3 is much more Object oriented and consists of these classes: Product, ProductReader, ProductWriter, ProductTransformer, PipelineStatistics, and ETLPipeline. This design follows OOPrinciples through a modular infrastructure. Each class has a single responsibility:

Product - represents product entity
ProductReader - handles csv parsing
ProductTransformer - applies business logic
ProductWriting - writes to csv
PipelineStatistics - returns the number of rows read, transformed, or skipped
ETLPipeline - compiles the workflow

Each class properly encapsulates all its data and the ETLPipeline uses composition (has-a relationship) to build the entire system with no components having direct inheritance as it is not necessary in this project. These practices are in line with OOP unlike assignment 1 where the code was more procedural.

To test that the results were the same I ran both Assignment2 and 3 and checked the outputs to confirm whether or not they had stayed the same. After confirming that both produced the same output I was confident in my results


