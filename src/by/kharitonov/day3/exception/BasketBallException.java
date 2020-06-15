package by.kharitonov.day3.exception;

public class BasketBallException extends Exception {
    public BasketBallException() {}

    public BasketBallException(String message) {
        super(message);
    }

    public BasketBallException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasketBallException(Throwable cause) {
        super(cause);
    }
}
