package tz.go.moh.him.mediator.core.domain;

import java.util.List;

public class ErrorMessage {
    /**
     * raw data of the record
     */
    private String source;

    /**
     * A list of result details containing error messages
     */
    private List<ResultDetail> resultsDetails;

    public ErrorMessage() {
    }

    public ErrorMessage(String source, List<ResultDetail> resultsDetails) {
        this.source = source;
        this.resultsDetails = resultsDetails;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<ResultDetail> getResultsDetails() {
        return resultsDetails;
    }

    public void setResultsDetails(List<ResultDetail> resultsDetails) {
        this.resultsDetails = resultsDetails;
    }
}
