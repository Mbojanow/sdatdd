package pl.sdacademy.payments;

public class OwnerException extends RuntimeException {
    public OwnerException() {
        super();
    }

    public OwnerException(final String message) {
        super(message);
    }

    public OwnerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public OwnerException(final Throwable cause) {
        super(cause);
    }

    protected OwnerException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
