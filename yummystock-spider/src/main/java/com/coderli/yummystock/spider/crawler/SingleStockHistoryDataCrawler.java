package com.coderli.yummystock.spider.crawler;

/**
 * Request only a single stock history data per time.
 *
 * @author li.hzh
 * @date 2016-11-29 00:09
 */
public interface SingleStockHistoryDataCrawler extends HistoryDataCrawler {
    
    /**
     * Crawl history data by stock code.
     *
     * @param stockCode
     * @return
     */
    String crawl(String stockCode);
    
}
