package pl.sdacademy.payments;

public class AccountException extends RuntimeException {
    public AccountException() {
        super();
    }

    public AccountException(final String message) {
        super(message);
    }

    public AccountException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AccountException(final Throwable cause) {
        super(cause);
    }

    protected AccountException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
