package com.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    // Runs before each test to set up the Calculator instance
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result, "5 - 3 should equal 2");
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(4, 3);
        assertEquals(12, result, "4 * 3 should equal 12");
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(6, 3);
        assertEquals(2, result, "6 / 3 should equal 2");
    }

    @Test
    public void testDivideByZero() {
        // Test to make sure it throws the IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0), "Division by zero should throw IllegalArgumentException");
    }
}
