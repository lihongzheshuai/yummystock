package com.coderli.yummystock.test.spider.crawler;

import com.coderli.yummystock.spider.crawler.TencentCrawler;
import org.junit.Test;

/**
 * @author li.hzh
 * @date 2016-12-01 00:20
 */
public class TencentCrawlerTest {
    
    private TencentCrawler tencentCrawler = new TencentCrawler();
    
    @Test
    public void testCrawlHistoryData() {
        tencentCrawler.crawlHistoryData(null);
    }
    
}
