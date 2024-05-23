package ch.heigvd.pdl.testing;

/**
 * This interface represents a logger.
 * It is a dependency of the system under test (SUT).
 * We don't need to implement it, as we will use a mock object.
 * A stub can be used to define the behavior of the level() method.
 */
public interface Logger {

    Level level();

    void log(String message);

    enum Level {
        INFO,
        WARNING,
        ERROR
    }

}
