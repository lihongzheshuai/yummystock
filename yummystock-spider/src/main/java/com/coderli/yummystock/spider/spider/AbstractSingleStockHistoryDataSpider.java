package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.spider.config.HistoryDataSpiderConfigBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author li.hzh
 * @date 2016-12-06 23:26
 */
@Slf4j
public abstract class AbstractSingleStockHistoryDataSpider {
    
    @Autowired
    private HistoryDataSpiderConfigBean historyDataSpiderConfig;
    
    protected String getBaseUrl() {
        return historyDataSpiderConfig.getBaseUrl();
    }
    
    protected String getTempPath() {
        return historyDataSpiderConfig.getTempPath();
    }
    
}
