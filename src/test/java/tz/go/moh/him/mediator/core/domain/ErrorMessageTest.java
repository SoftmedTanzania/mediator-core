package tz.go.moh.him.mediator.core.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ErrorMessageTest {

    @Test
    public void testErrorMessage() {
        ResultDetail resultDetail = new ResultDetail();
        resultDetail.setType("error");
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

}