package com.coderli.yummystock.core.util;

import lombok.NonNull;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
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
    
    /**
     * Calculate how many days from the {@param from} to the
     * {@param to} time.
     * eg. from 2016-07-08 to 2016-07-10 is 3 days.
     *
     * @param from
     * @param to
     * @return
     */
    public static int calcDayCount(Date from, Date to) {
        Interval interval = new Interval(from.getTime(), to.getTime());
        Period period = interval.toPeriod(PeriodType.days());
        return period.getDays() + 1;
    }
}
