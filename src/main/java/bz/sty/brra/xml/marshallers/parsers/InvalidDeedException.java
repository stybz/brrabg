package bz.sty.brra.xml.marshallers.parsers;

/** Copied from Alfa. Now it's a runtime exception */
public class InvalidDeedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidDeedException() {
    }

    public InvalidDeedException(String message) {
        super(message);
    }

    public InvalidDeedException(Throwable cause) {
        super(cause);
    }

    public InvalidDeedException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDeedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}