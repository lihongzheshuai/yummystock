package com.coderli.yummystock.test.spider;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.spider.spider.NetEaseHistoryDataSpider;
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
    private NetEaseHistoryDataSpider netEaseCrawler;
    
    private Date from;
    private Date to;
    
    
    @Before
    public void init() {
        from = DateTime.parse("2000-01-01").toDate();
        to = DateTime.parse("2016-07-12").toDate();
    }
    
    @Test
    public void testCrawlHistoryData() {
        String stockCode = "600887";
        List<HistoryStockData> stockDataList = netEaseCrawler.crawlData(stockCode, from, to);
//        System.out.println(stockDataList.size());
//        for (HistoryStockData historyStockData : stockDataList) {
//            System.out.println(historyStockData.getDate());
//        }
//        System.out.println(stockDataList);
    }
    
}
