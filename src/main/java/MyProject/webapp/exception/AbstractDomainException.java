package MyProject.webapp.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractDomainException extends Exception{
    public AbstractDomainException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public AbstractDomainException(String message) {
        super(message);
    }

    /**
     * Httpstatus of exception
     * @return
     */
    public abstract HttpStatus getHttpStatus();

    /**
     * Httpstatus of exception
     * @return
     */
    public abstract HttpStatus getCode();

    /**
     * get default message
     */
    public abstract String defaultMessage();

    public String getMessage() {
        String message = super.getMessage();
        if(message == null || message.isBlank() ) {
            return this.defaultMessage();
        }
        return message;
    }
}
