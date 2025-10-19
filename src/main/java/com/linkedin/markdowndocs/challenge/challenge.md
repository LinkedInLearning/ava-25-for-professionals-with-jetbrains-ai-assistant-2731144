# Markdown JavaDoc 

## Your task

Convert the following class from **old-style JavaDoc** to **new-style Markdown JavaDoc**.

### Given code (old style)

```java
/**
 * Represents a simple calculator for basic arithmetic operations.
 * <p>
 * This class provides methods for addition, subtraction, multiplication,
 * and division of two numbers.
 * <p>
 * <b>Example usage:</b>
 * <pre>
 * Calculator calc = new Calculator();
 * int result = calc.add(5, 3);
 * System.out.println(result); // outputs 8
 * </pre>
 * 
 * @author Jane Doe
 * @version 1.0
 * @since 2024
 */
public class Calculator {
    
    /**
     * Adds two integers together.
     * <p>
     * This method performs simple addition.
     * 
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Divides two integers.
     * <p>
     * <b>Note:</b> This method will throw an exception if the divisor is zero.
     * 
     * @param dividend the number to be divided
     * @param divisor the number to divide by (must not be zero)
     * @return the result of dividend divided by divisor
     * @throws ArithmeticException if divisor is zero
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return dividend / divisor;
    }
}
```

---

## Instructions

### Step 1: Convert class level documentation
Replace the class-level JavaDoc with Markdown syntax using `///`:
- Use `#` for the main heading
- Use regular paragraphs (no `<p>` tags)
- Use `**bold**` instead of `<b>bold</b>`
- Use triple backticks for code blocks instead of `<pre>`
- **Keep** `@author`, `@version`, and `@since` tags (these are still needed!)

### Step 2: Convert method level documentation
Replace method JavaDoc with Markdown syntax:
- Use `##` for method descriptions if you want a heading
- Use regular text for descriptions
- **Keep** `@param`, `@return`, and `@throws` tags (these are machine-readable and still required!)
- Use `**bold**` for emphasis instead of HTML tags
