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
        DateTime dateTime = DateTime.parse(input);
        Date inputDate = dateTime.toDate();
        Assert.assertEquals(input, DateUtil.formatDate(inputDate));
        Assert.assertEquals(input, DateUtil.formatDate(inputDate, "yyyy-MM-dd"));
    }
    
}
