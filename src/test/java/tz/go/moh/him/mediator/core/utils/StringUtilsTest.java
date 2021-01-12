package tz.go.moh.him.mediator.core.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Contains tests for the {@link StringUtils} class.
 */
public class StringUtilsTest {

    /**
     * Tests an empty string.
     */
    @Test
    public void testStringIsNullOrEmptyEmpty() {
        Assert.assertTrue(StringUtils.isNullOrEmpty(""));
    }

    /**
     * Tests a null string.
     */
    @Test
    public void testStringIsNullOrEmptyNull() {
        Assert.assertTrue(StringUtils.isNullOrEmpty(null));
    }

    /**
     * Tests a space string.
     */
    @Test
    public void testStringIsNullOrEmptySpace() {
        Assert.assertTrue(StringUtils.isNullOrEmpty(" "));
    }

    /**
     * Tests a non-null value string.
     */
    @Test
    public void testStringIsNullOrEmptyValue() {
        Assert.assertFalse(StringUtils.isNullOrEmpty("hello"));
    }

    /**
     * Tests writing a stack trace.
     */
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