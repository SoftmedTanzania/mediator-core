package tz.go.moh.him.mediator.core.domain;

/**
 * Represents a result detail.
 */
public class ResultDetail {
    /**
     * Type of result, in this case its going to mostly be "Error"
     * This is always required
     */
    private ResultsDetailsType type;

    /**
     * Error message
     * This is always required
     */
    private String message;

    /**
     * Stack trace to assist in debugging incase of critical failure
     * This field is optional and can be null in case there are no stack traces involved
     */
    private String stackTrace;

    /**
     * Initializes a new instance of the {@link ResultDetail} class.
     */
    public ResultDetail() {
    }

    /**
     * Initializes a new instance of the {@link ResultDetail} class.
     *
     * @param type       The type.
     * @param message    The message.
     * @param stackTrace The stack trace.
     */
    public ResultDetail(ResultsDetailsType type, String message, String stackTrace) {
        this.type = type;
        this.message = message;
        this.stackTrace = stackTrace;
    }

    /**
     * Gets the type.
     *
     * @return Returns the type.
     */
    public ResultsDetailsType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type The type.
     */
    public void setType(ResultsDetailsType type) {
        this.type = type;
    }

    /**
     * Gets the message.
     *
     * @return Returns the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message The message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the stack trace.
     *
     * @return Returns the stack trace.
     */
    public String getStackTrace() {
        return stackTrace;
    }

    /**
     * Sets the stack trace.
     *
     * @param stackTrace The stack trace.
     */
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    /**
     * Results Details Type
     */
    public enum ResultsDetailsType {
        ERROR
    }
}
