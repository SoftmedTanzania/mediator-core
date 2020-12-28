package tz.go.moh.him.mediator.core.validator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class DateValidatorTest {
    @Test
    public void testDateAfterGivenStartDateRange() {
        //Checking if the date is after a month ago
        Assert.assertTrue(DateValidator.isThisDateAfterFieldRange("01/01/2022", "dd/MM/yyyy", Calendar.MONTH, -1));
    }

    @Test
    public void testDateAfterBeforeStartDateRange() {
        //Checking if the date is before a month from now
        Assert.assertTrue(DateValidator.isThisDateBeforeFieldRange("31/01/2012", "dd/MM/yyyy", Calendar.MONTH, 1));

    }

    @Test
    public void testIsValidFutureDate() {
        //Checking if the date is a valid future date
        Assert.assertTrue(DateValidator.isValidFutureDate("01/01/2030", "dd/MM/yyyy"));

    }

    @Test
    public void testIsValidPastDate() {
        //Checking if the date is a valid past date
        Assert.assertTrue(DateValidator.isValidPastDate("01/01/2020", "dd/MM/yyyy"));
    }
}