package com.company.myloyal.util;

import com.company.myloyal.exception.DateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jmbataller on 08/12/14.
 */
public class DateUtil {

    private static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
    private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

    public static Date toDate(String date) throws DateFormatException {
        try {
            Date from = sdfDate.parse(date);
            return from;
        }
        catch(ParseException ex) {
            throw new DateFormatException("400", "Invalid date format");
        }
    }

    public static Date toDatetime(String date) throws DateFormatException {
        try {
            Date from = sdfDateTime.parse(date);
            return from;
        }
        catch(ParseException ex) {
            throw new DateFormatException("400", "Invalid date format");
        }
    }
}
