package tz.go.moh.him.mediator.core.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateValidatorUtils {

    /**
     * @param dateToValidate the date to be validated
     * @param dateFormat     date format of the date to be validated
     * @param field          the calendar field to be added to obtain the start date.
     * @param amount         the amount of date or time to be added to obtain the start date.
     * @return validation status
     */
    public static boolean isThisDateBeforeFieldRange(String dateToValidate,
                                                     String dateFormat, int field, int amount) {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {

            // if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);

            // start date before the given date
            Calendar startDate = Calendar.getInstance();
            startDate.add(field, amount);

            return date.before(startDate.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

    }


    /**
     * @param dateToValidate the date to be validated
     * @param dateFormat     date format of the date to be validated
     * @param field          the calendar field to be added to obtain the start date.
     * @param amount         the amount of date or time to be added to obtain the start date.
     * @return validation status
     */
    public static boolean isThisDateAfterFieldRange(String dateToValidate,
                                             String dateFormat, int field, int amount) {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            // if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);

            Calendar startDate = Calendar.getInstance();
            startDate.add(field, amount);

            return date.after(startDate.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

    }


    /**
     * @param dateToValidate the date to be validated
     * @param dateFormat     date format of the date to be validated
     * @return true if it is a valid future date false otherwise
     */
    public static boolean isValidFutureDate(String dateToValidate,
                                          String dateFormat){
        return isThisDateAfterFieldRange(dateToValidate,dateFormat,Calendar.SECOND,0);
    }

    /**
     * @param dateToValidate the date to be validated
     * @param dateFormat     date format of the date to be validated
     * @return true if it is a valid past date false otherwise
     */
    public static boolean isValidPastDate(String dateToValidate,
                                          String dateFormat){
        return isThisDateBeforeFieldRange(dateToValidate,dateFormat,Calendar.SECOND,0);
    }
}
