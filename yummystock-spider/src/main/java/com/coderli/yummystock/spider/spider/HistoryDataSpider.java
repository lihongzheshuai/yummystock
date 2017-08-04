package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.core.constant.RestorationType;

import java.util.Date;

/**
 * @author li.hzh
 * @date 2016-11-29 00:08
 */
public interface HistoryDataSpider<T> extends DataSpider {
    
    /**
     * 爬取给定股票代码的股票的历史数据
     *
     * @param stockCode       stock code
     * @param from            history date range begin
     * @param to              history date range end
     * @return
     */
    T crawlData(String stockCode, Date from, Date to);
    
    
}
