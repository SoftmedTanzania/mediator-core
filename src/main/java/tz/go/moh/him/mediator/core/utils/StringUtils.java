package tz.go.moh.him.mediator.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Represents a string validation utility.
 */
public class StringUtils {

    /**
     * Checks if a string is null or empty.
     * @param value The string value.
     * @return Returns true if the string is null or empty.
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().length() == 0;
    }

    /**
     * A method to write stack trace to a string resource
     *
     * @param exception exception with stack trace
     * @return string with the stacktrace message
     */
    public static String writeStackTraceToString(Exception exception) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);

        return stringWriter.toString();
    }
}
