package com.linkedin.markdowndocs.solution;

/// # Calculator
///
/// Represents a simple calculator for basic arithmetic operations.
///
/// This class provides methods for addition, subtraction, multiplication,
/// and division of two numbers.
///
/// **Example usage:**
/// ```java
/// Calculator calc = new Calculator();
/// int result = calc.add(5, 3);
/// System.out.println(result); // outputs 8
/// ```
///
/// @author Jane Doe
/// @version 1.0
/// @since 2024
public class Calculator {

    /// Adds two integers together.
    ///
    /// This method performs simple addition.
    ///
    /// @param a the first number
    /// @param b the second number
    /// @return the sum of a and b
    public int add(int a, int b) {
        return a + b;
    }

    /// Divides two integers.
    ///
    /// **Note:** This method will throw an exception if the divisor is zero.
    ///
    /// @param dividend the number to be divided
    /// @param divisor the number to divide by (must not be zero)
    /// @return the result of dividend divided by divisor
    /// @throws ArithmeticException if divisor is zero
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return dividend / divisor;
    }

}