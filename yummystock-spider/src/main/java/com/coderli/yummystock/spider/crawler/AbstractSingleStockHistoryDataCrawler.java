package com.coderli.yummystock.spider.crawler;

import com.coderli.yummystock.spider.config.HistoryDataSpiderConfigBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author li.hzh
 * @date 2016-12-06 23:26
 */
public abstract class AbstractSingleStockHistoryDataCrawler implements SingleStockHistoryDataCrawler {
    
    @Autowired
    private HistoryDataSpiderConfigBean historyDataSpiderConfig;
    
    protected String getBaseUrl() {
        return historyDataSpiderConfig.getBaseUrl();
    }
}
