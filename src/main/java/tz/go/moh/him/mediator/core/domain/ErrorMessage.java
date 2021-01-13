package tz.go.moh.him.mediator.core.domain;

import java.util.List;

/**
 * Represents an error message.
 */
public class ErrorMessage {

    /**
     * Represents the raw data of the record.
     */
    private String source;

    /**
     * Represents a list of result details containing error messages.
     */
    private List<ResultDetail> resultsDetails;

    /**
     * Initializes a new instance of the {@link ErrorMessage} class.
     */
    public ErrorMessage() {
    }

    /**
     * Initializes a new instance of the {@link ErrorMessage} class.
     *
     * @param source         The source.
     * @param resultsDetails The result details.
     */
    public ErrorMessage(String source, List<ResultDetail> resultsDetails) {
        this.source = source;
        this.resultsDetails = resultsDetails;
    }

    /**
     * Gets the source.
     *
     * @return Returns the source.
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the source.
     *
     * @param source The source.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets the result details.
     *
     * @return Returns the result details.
     */
    public List<ResultDetail> getResultsDetails() {
        return resultsDetails;
    }

    /**
     * Sets the result details.
     *
     * @param resultsDetails The result details.
     */
    public void setResultsDetails(List<ResultDetail> resultsDetails) {
        this.resultsDetails = resultsDetails;
    }
}
