package by.kharitonov.day3.exception;

public class BasketBallRuntimeException extends RuntimeException {
    public BasketBallRuntimeException() {
    }

    public BasketBallRuntimeException(String message) {
        super(message);
    }

    public BasketBallRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasketBallRuntimeException(Throwable cause) {
        super(cause);
    }
}
