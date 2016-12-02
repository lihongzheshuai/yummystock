package com.coderli.yummystock.spider.crawler;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.http.HttpClient;
import com.coderli.yummystock.spider.config.HistoryDataSpiderConfigBean;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.coderli.yummystock.core.util.StockCodeUtil.getFullStockCode;

/**
 * Crawl data from tencent.
 *
 * @author li.hzh
 * @date 2016-11-29 13:07
 */
@Slf4j
@Component
public class TencentCrawler implements SingleStockHistoryDataCrawler {
    
    @Autowired
    private HttpClient httpClient;
    @Autowired
    private HistoryDataSpiderConfigBean historyDataSpiderConfig;
    
    @NonNull
    public String crawlHistoryData(String stockCode,
                                   Date from, Date to, RestorationType restorationType) {
        log.info("Crawl history data of [{}].", stockCode);
        String targetUrl = generateUrl(stockCode);
        return null;
    }
    
    //TODO
    private String generateUrl(String stockCode) {
        String baseUrl = getBaseUrl();
        String param = null;
        String fullCode = getFullStockCode(stockCode);
        return null;
    }
    
    private String getBaseUrl() {
        return historyDataSpiderConfig.getBaseUrl();
    }
    
    
}
