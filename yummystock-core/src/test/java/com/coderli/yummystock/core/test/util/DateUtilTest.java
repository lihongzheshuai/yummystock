package com.coderli.yummystock.core.test.util;

import com.coderli.yummystock.core.util.DateUtil;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author li.hzh
 * @date 2016-12-03 00:18
 */
public class DateUtilTest {
    
    @Test
    public void testFormatDate() {
        String input = "2014-07-08";
        Date inputDate = getDate(input);
        Assert.assertEquals(input, DateUtil.formatDate(inputDate));
        Assert.assertEquals(input, DateUtil.formatDate(inputDate, "yyyy-MM-dd"));
    }
    
    @Test
    public void testCalcDayCount() {
        Date fromOne = getDate("2014-01-01");
        Date endOne = getDate("2014-12-31");
        Date endTwo = getDate("2015-12-31");
        Assert.assertEquals(365, DateUtil.calcDayCount(fromOne, endOne));
        Assert.assertEquals(730, DateUtil.calcDayCount(fromOne, endTwo));
    }
    
    private Date getDate(String dateStr) {
        DateTime dateTime = DateTime.parse(dateStr);
        return dateTime.toDate();
    }
    
    @Test
    public void testToday() {
        Date today = DateUtil.todayDate();
        System.out.println(today);
        System.out.println(today.getTimezoneOffset());
    }
}
