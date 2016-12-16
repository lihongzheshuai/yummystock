package com.coderli.yummystock.spider.crawler;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.http.HttpClient;
import com.coderli.yummystock.core.util.DateUtil;
import com.coderli.yummystock.core.util.StockCodeUtil;
import com.coderli.yummystock.core.util.UrlUtil;
import com.coderli.yummystock.spider.crawler.handler.CrawlDataHandler;
import com.coderli.yummystock.spider.crawler.parser.RawHistoryDataParser;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Crawl data from tencent.
 *
 * @author li.hzh
 * @date 2016-11-29 13:07
 */
@Slf4j
@Component
public class TencentCrawler extends AbstractSingleStockHistoryDataCrawler {
    
    private static final String PARAM_KEY_VAR = "_var";
    private static final String PARAM_KEY_PARAM = "param";
    
    @Autowired
    private HttpClient httpClient;
    @Autowired
    private CrawlDataHandler crawlDataHandler;
    @Autowired
    private RawHistoryDataParser rawDataParser;
    
    public List<HistoryStockData> crawlHistoryData(@NonNull String stockCode,
                                                   @NonNull Date from, @NonNull Date to, @NonNull RestorationType restorationType) {
        log.info("Crawl history data of [{}].", stockCode);
        String targetUrl = generateUrl(stockCode, from, to, restorationType);
        log.debug("Target URL is: [{}]", targetUrl);
        String responseStr = httpClient.getObject(targetUrl, String.class, null);
        return rawDataParser.parseRawData(responseStr, StockCodeUtil.getFullStockCode(stockCode), restorationType);
    }
    
    private String generateUrl(String stockCode, Date from, Date to, RestorationType restorationType) {
        String baseUrl = getBaseUrl();
        String paramStr = generateParams(stockCode, from, to, restorationType);
        return baseUrl + "?" + paramStr;
    }
    
    private String generateParams(String stockCode, Date from, Date to, RestorationType restorationType) {
        String fullStockCode = StockCodeUtil.getFullStockCode(stockCode);
        String paramVarPair = UrlUtil.generateParamPairStr(PARAM_KEY_VAR, fullStockCode + restorationType.name());
        String paramParamValue = generateParamParamValue(fullStockCode, from, to, restorationType);
        String paramParamPair = UrlUtil.generateParamPairStr(PARAM_KEY_PARAM, paramParamValue);
        return UrlUtil.composedParamPairsString(paramVarPair, paramParamPair);
    }
    
    private String generateParamParamValue(String fullStockCode, Date from, Date to, RestorationType restorationType) {
        return fullStockCode + "," + "day,"
                       + DateUtil.formatDate(from) + ","
                       + DateUtil.formatDate(to) + ","
                       + DateUtil.calcDayCount(from, to) + ","
                       + restorationType.name();
    }
    
    
    @Override
    public CrawlDataHandler getHandler() {
        return crawlDataHandler;
    }
}
