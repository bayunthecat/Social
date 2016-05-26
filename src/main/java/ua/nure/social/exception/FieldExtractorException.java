package ua.nure.social.exception;

public class FieldExtractorException extends RuntimeException {

    public FieldExtractorException() {
    }

    public FieldExtractorException(String message) {
        super(message);
    }

    public FieldExtractorException(String message, Throwable cause) {
        super(message, cause);
    }
}
