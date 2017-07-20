package com.coderli.yummystock.test.spider.crawler;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.spider.NetEaseSpider;
import com.coderli.yummystock.test.spider.SpiderTestConfig;
import org.joda.time.DateTime;
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
 * @date 2016-12-01 00:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpiderTestConfig.class)
public class NetEaseSpiderTest {
    
    @Autowired
    private NetEaseSpider netEaseCrawler;
    
    private Date from;
    private Date to;
    
    
    @Before
    public void init() {
        from = DateTime.parse("2016-07-08").toDate();
        to = DateTime.parse("2016-07-12").toDate();
    }
    
    @Test
    public void testCrawlHistoryData() {
        String stockCode = "600887";
        List<HistoryStockData> stockDataList = netEaseCrawler.crawlHistoryData(stockCode, from, to, RestorationType.qfq);
//        System.out.println(stockDataList.size());
//        for (HistoryStockData historyStockData : stockDataList) {
//            System.out.println(historyStockData.getDate());
//        }
//        System.out.println(stockDataList);
    }
    
}
