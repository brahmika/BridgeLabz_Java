/*
 Problem Statement 2: Rethrowing Exceptions
 Demonstrates rethrowing ArithmeticException with additional context.
*/
package exceptions;

class DivisionService {

    public int performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        return numerator / denominator;
    }

    public int calculate(int numerator, int denominator) {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error in calculate(): " + e.getMessage());
        }
    }
}
