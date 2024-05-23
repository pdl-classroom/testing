package ch.heigvd.pdl.testing;

/**
 * This class implements the Calculator interface.
 * It is the system under test (SUT).
 */
public class CalculatorImpl implements Calculator {

    private Logger logger;

    @Override
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public int add(int a, int b) {
        // check for overflow
        if (a > 0 && b > Integer.MAX_VALUE - a) {
            if (logger != null && logger.level() == Logger.Level.ERROR) {
                logger.log(String.format("Integer overflow: %d + %d", a, b));
            }
            throw new ArithmeticException("Integer overflow");
        }

        // check for underflow
        if (a < 0 && b < Integer.MIN_VALUE - a) {
            if (logger != null && logger.level() == Logger.Level.ERROR) {
                logger.log(String.format("Integer underflow: %d + %d", a, b));
            }
            throw new ArithmeticException("Integer underflow");
        }

        // compute the result
        int result = a + b;

        // print the operation
        if (logger != null) {
            logger.log(String.format("%d + %d = %d", a, b, result));
        }

        return result;
    }

    @Override
    public int subtract(int a, int b) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int multiply(int a, int b) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int divide(int a, int b) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int modulo(int a, int b) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
