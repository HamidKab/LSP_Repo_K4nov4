package org.howard.edu.lsp.assignment6;
/**
 * The IntegerSetException class is a custom exception that extends the RuntimeException class.
 * It is used to handle specific error conditions related to the IntegerSet class, such as when attempting to find the largest or smallest integer in an empty set. 
 * The constructor takes a message parameter that provides details about the exception, which can be used for debugging and error handling purposes.
 * @author Generated
 * @Reviewer Hamid Kabia
 */
public class IntegerSetException extends RuntimeException {
    public IntegerSetException(String message) {
        super(message);
    }
}
