package com.coderli.yummystock.core.util;

import lombok.NonNull;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
    
    public static Date parseDate(String dateString) {
        return parseDate(dateString, DEFAULT_PATTERN);
    }
    
    public static Date parseDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        DateTime dateTime = formatter.parseDateTime(dateString);
        return dateTime.toDate();
    }
    
    public static Date todayDate() {
        return new DateTime().withMillisOfDay(0).toDate();
    }
    
    public static Date tomorrowOfDate(Date date) {
        return new DateTime(date).withMillisOfDay(0).plusDays(1).toDate();
    }
    
    public static Date yesterdayDate() {
        return new DateTime().withMillisOfDay(0).minusDays(1).toDate();
    }
    
    /**
     * 判断日期一是否早于日期二
     *
     * @param one 日期一
     * @param two 日期二
     * @return 如果一早于二，则返回true
     */
    public static boolean isEarlierThan(Date one, Date two) {
        DateTime timeOne = new DateTime(one);
        DateTime timeTwo = new DateTime(two);
        return timeOne.isBefore(timeTwo);
    }
}
