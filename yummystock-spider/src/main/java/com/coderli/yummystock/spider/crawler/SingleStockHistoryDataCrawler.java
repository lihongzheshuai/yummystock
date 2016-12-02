package com.coderli.yummystock.spider.crawler;

import com.coderli.yummystock.core.constant.RestorationType;

import java.util.Date;

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
     * @param stockCode       stock code
     * @param from            history date range begin
     * @param to              history date range end
     * @param restorationType {@link RestorationType}
     * @return
     */
    String crawlHistoryData(String stockCode, Date from, Date to, RestorationType restorationType);
    
}
