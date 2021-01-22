package tz.go.moh.him.mediator.core.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Represents a date validation utility.
 */
public class DateValidatorUtils {

    /**
     * Checks is a date is before a field range.
     *
     * @param dateToValidate the date to be validated
     * @param dateFormat     date format of the date to be validated
     * @param field          the calendar field to be added to obtain the start date.
     * @param amount         the amount of date or time to be added to obtain the start date.
     * @return validation status
     * @throws ParseException if a parse exception occurs
     */
    public static boolean isThisDateBeforeFieldRange(String dateToValidate,
                                                     String dateFormat, int field, int amount) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        // if not valid, it will throw ParseException
        Date date = sdf.parse(dateToValidate);

        // start date before the given date
        Calendar startDate = Calendar.getInstance();
        startDate.add(field, amount);

        return date.before(startDate.getTime());
    }


    /**
     * Checks if a date is after a field range.
     *
     * @param dateToValidate the date to be validated
     * @param dateFormat     date format of the date to be validated
     * @param field          the calendar field to be added to obtain the start date.
     * @param amount         the amount of date or time to be added to obtain the start date.
     * @return validation status
     * @throws ParseException if a parse exception occurs
     */
    public static boolean isThisDateAfterFieldRange(String dateToValidate,
                                                    String dateFormat, int field, int amount) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        // if not valid, it will throw ParseException
        Date date = sdf.parse(dateToValidate);

        Calendar startDate = Calendar.getInstance();
        startDate.add(field, amount);

        return date.after(startDate.getTime());

    }


    /**
     * Checks if a date is a valid future date.
     *
     * @param dateToValidate the date to be validated
     * @param dateFormat     date format of the date to be validated
     * @return true if it is a valid future date false otherwise
     * @throws ParseException if a parse exception occurs
     */
    public static boolean isValidFutureDate(String dateToValidate,
                                            String dateFormat) throws ParseException {
        return isThisDateAfterFieldRange(dateToValidate, dateFormat, Calendar.SECOND, 0);
    }

    /**
     * Checks if a date is a valid past date.
     *
     * @param dateToValidate the date to be validated
     * @param dateFormat     date format of the date to be validated
     * @return true if it is a valid past date false otherwise
     * @throws ParseException if a parse exception occurs
     */
    public static boolean isValidPastDate(String dateToValidate,
                                          String dateFormat) throws ParseException {
        return isThisDateBeforeFieldRange(dateToValidate, dateFormat, Calendar.SECOND, 0);
    }
}
