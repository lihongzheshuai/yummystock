package com.coderli.yummystock.spider.crawler;

import com.coderli.yummystock.spider.crawler.handler.CrawlDataHandler;

/**
 * @author li.hzh
 * @date 2016-12-06 23:35
 */
public interface DataCrawler {
    
    CrawlDataHandler getHandler();
    
}
