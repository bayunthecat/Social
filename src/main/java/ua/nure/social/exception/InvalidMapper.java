package ua.nure.social.exception;

public class InvalidMapper extends RuntimeException {

    public InvalidMapper() {
    }

    public InvalidMapper(String message) {
        super(message);
    }

    public InvalidMapper(String message, Throwable cause) {
        super(message, cause);
    }
}
