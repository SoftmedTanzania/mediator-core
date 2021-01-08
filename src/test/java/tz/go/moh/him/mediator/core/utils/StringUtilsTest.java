package tz.go.moh.him.mediator.core.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testWritingStackTraceToString() {
        String nullString = null;
        try {
            nullString.equals("");
        } catch (Exception e) {
            Assert.assertTrue(StringUtils.writeStackTraceToString(e).contains("java.lang.NullPointerException"));
        }
    }
}