package tz.go.moh.him.mediator.core.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ErrorMessageTest {

    @Test
    public void testGettersAndSettersErrorMessage() {
        ResultDetail resultDetail = new ResultDetail();
        resultDetail.setType(ResultDetail.ResultsDetailsType.ERROR);
        resultDetail.setMessage("Record with id %s failed validation, Id must not exceed 255 characters in length");
        resultDetail.setStackTrace("sample stack trace");

        Assert.assertEquals("error", resultDetail.getType());
        Assert.assertEquals("Record with id %s failed validation, Id must not exceed 255 characters in length", resultDetail.getMessage());
        Assert.assertEquals("sample stack trace", resultDetail.getStackTrace());


        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setSource("sample payload");
        errorMessage.setResultsDetails(Arrays.asList(resultDetail));

        Assert.assertEquals("sample payload", errorMessage.getSource());
        Assert.assertEquals(1, errorMessage.getResultsDetails().size());
    }

    @Test
    public void testErrorMessageConstructors() {
        ResultDetail detail = new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, "Record with id 2 failed validation", "Sample stack trace");
        Assert.assertEquals("ERROR 2", detail.getType());
        Assert.assertEquals("Record with id 2 failed validation", detail.getMessage());
        Assert.assertEquals("Sample stack trace", detail.getStackTrace());


        ErrorMessage errorMessage2 = new ErrorMessage("Sample payload", Arrays.asList(detail));

        Assert.assertEquals("Sample payload", errorMessage2.getSource());
        Assert.assertEquals(1, errorMessage2.getResultsDetails().size());
    }

}