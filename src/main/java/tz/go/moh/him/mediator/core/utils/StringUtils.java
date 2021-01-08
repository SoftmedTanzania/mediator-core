package tz.go.moh.him.mediator.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringUtils {
    /**
     * A method to write stack trace to a string resource
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
