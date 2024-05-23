package ch.heigvd.pdl.testing;

import java.io.PrintStream;

/**
 * This interface describes a calculator.
 * Its implementation is the system under test (SUT).
 */
public interface Calculator {

    int add(int a, int b);

    int subtract(int a, int b);

    int multiply(int a, int b);

    int divide(int a, int b);

    int modulo(int a, int b);

    void setLogger(Logger out);

}
