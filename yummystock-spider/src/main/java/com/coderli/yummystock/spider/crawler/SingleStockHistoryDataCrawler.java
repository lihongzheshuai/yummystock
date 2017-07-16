package com.coderli.yummystock.spider.crawler;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.entity.HistoryStockData;

import java.util.Date;
import java.util.List;

/**
 * 单股票历史数据爬取接口
 *
 * @author li.hzh
 * @date 2016-11-29 00:09
 */
public interface SingleStockHistoryDataCrawler extends HistoryDataCrawler {
    
    /**
     * 爬取给定股票代码的股票的历史数据
     *
     * @param stockCode       stock code
     * @param from            history date range begin
     * @param to              history date range end
     * @param restorationType {@link RestorationType}
     * @return
     */
    List<HistoryStockData> crawlHistoryData(String stockCode, Date from, Date to, RestorationType restorationType);
    
}
