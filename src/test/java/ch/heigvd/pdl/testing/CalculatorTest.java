package ch.heigvd.pdl.testing;

import ch.heigvd.pdl.testing.Logger.Level;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CalculatorTest {

    @Test
    void addPositive() {
        // Arrange
        Calculator calculator = new CalculatorImpl();

        // Act
        int result = calculator.add(1, 2);

        // Assert
        assertEquals(3, result);
    }

    @Test
    void addNegative() {
        // Arrange
        Calculator calculator = new CalculatorImpl();

        // Act
        int result = calculator.add(-1, -2);

        // Assert
        assertEquals(-3, result);
    }

    @Test
    void addZero() {
        // Arrange
        Calculator calculator = new CalculatorImpl();

        // Act
        int result = calculator.add(0, 0);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void addNegativePositive() {
        // Arrange
        Calculator calculator = new CalculatorImpl();

        // Act
        int result = calculator.add(-1, 2);

        // Assert
        assertEquals(1, result);
    }

    @Test
    void addPositiveNegative() {
        // Arrange
        Calculator calculator = new CalculatorImpl();

        // Act
        int result = calculator.add(1, -2);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    void addOverflow() {
        // Arrange
        Calculator calculator = new CalculatorImpl();

        // Act
        Executable executable = () -> {
            calculator.add(Integer.MAX_VALUE, 1);
        };

        // Assert
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void addUnderflow() {
        // Arrange
        Calculator calculator = new CalculatorImpl();

        // Act
        Executable executable = () -> {
            calculator.add(Integer.MIN_VALUE, -1);
        };

        // Assert
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void mockLogger() {
        // Arrange
        Calculator calculator = new CalculatorImpl();
        Logger logger = mock(Logger.class);

        // Act
        calculator.setLogger(logger);
        calculator.add(1, 2);

        // Assert
        verify(logger).log("1 + 2 = 3");
    }

    @Test
    void mockLoggerAndStubLevel() {
        // Arrange
        Calculator calculator = new CalculatorImpl();
        Logger logger = mock(Logger.class);
        when(logger.level()).thenReturn(Level.ERROR);

        // Act
        Executable executable = () -> {
            calculator.setLogger(logger);
            calculator.add(Integer.MAX_VALUE, 1);
        };

        // Assert
        assertThrows(ArithmeticException.class, executable);
        verify(logger).log("Integer overflow: 2147483647 + 1");
    }
}