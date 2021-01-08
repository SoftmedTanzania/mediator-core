package tz.go.moh.him.mediator.core.domain;

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

    public ResultDetail() {
    }

    public ResultDetail(ResultsDetailsType type, String message, String stackTrace) {
        this.type = type;
        this.message = message;
        this.stackTrace = stackTrace;
    }

    public ResultsDetailsType getType() {
        return type;
    }

    public void setType(ResultsDetailsType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

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
