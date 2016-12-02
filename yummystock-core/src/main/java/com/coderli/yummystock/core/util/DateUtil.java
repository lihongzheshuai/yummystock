package com.coderli.yummystock.core.util;

import lombok.NonNull;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * @author li.hzh
 * @date 2016-12-03 00:12
 */
public class DateUtil {
    
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
    
    public static String formatDate(@NonNull Date date, String pattern) {
        return DateTimeFormat.forPattern(pattern).print(new DateTime(date));
    }
    
    public static String formatDate(Date date) {
        return formatDate(date, DEFAULT_PATTERN);
    }
    
}
