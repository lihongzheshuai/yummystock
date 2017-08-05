package com.coderli.yummystock.test.spider;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.util.DateUtil;
import com.coderli.yummystock.spider.spider.NetEaseDailyDataSpider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-27 16:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpiderTestConfig.class)
public class NetEaseDailySpiderTest {
    
    @Autowired
    private NetEaseDailyDataSpider netEaseCrawler;
    
    private Date from;
    private Date to;
    
    
    @Before
    public void init() {
        from = DateUtil.parseDate("2017-08-04");
        to = DateUtil.parseDate("2017-08-04");
    }
    
    @Test
    public void testCrawlDailyData() {
        String stockCode = "600111";
        List<HistoryStockData> stockDataList = netEaseCrawler.crawlData(stockCode, from, to);
        System.out.println(stockDataList.size());
        for (HistoryStockData historyStockData : stockDataList) {
            System.out.println(historyStockData.getDate());
        }
        System.out.println(stockDataList);
    }
}
