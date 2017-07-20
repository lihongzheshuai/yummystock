package com.coderli.yummystock.spider;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.http.HttpClient;
import com.coderli.yummystock.core.http.impl.SimpleRestHttpClient;
import com.coderli.yummystock.core.util.DateUtil;
import com.coderli.yummystock.core.util.FileUtil;
import com.coderli.yummystock.core.util.StockCodeUtil;
import com.coderli.yummystock.spider.handler.SpiderDataHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-06-15 23:10
 */
@Slf4j
@Component
public class NetEaseSpider extends AbstractSingleStockHistoryDataSpider {
    
    private static final String FIELDS_PARAM_STRING = "fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;TURNOVER;VOTURNOVER;VATURNOVER;TCAP;MCAP";
    private static final String CODE_PARAM_KEY = "code";
    private static final String START_PARAM_KEY = "start";
    private static final String END_PARAM_KEY = "end";
    private static final String SH_CODE_PREFIX = "0";
    private static final String SZ_CODE_PREFIX = "1";
    private static final String FILE_EXT_NAME = ".csv";
    private static final String DATE_FORMAT = "yyyyMMdd";
    
    private HttpClient httpClient = new SimpleRestHttpClient();
    
    @Override
    public SpiderDataHandler getHandler() {
        return null;
    }
    
    @Override
    public List<HistoryStockData> crawlHistoryData(String stockCode, Date from, Date to, RestorationType restorationType) {
        log.debug("Get stock {} history data. From {} to {}.", stockCode, from, to);
        String url = generateUrl(stockCode, from, to, restorationType);
        httpClient.writeToStream(url, createOutputStream(stockCode, from, to));
        return null;
    }
    
    private OutputStream createOutputStream(String stockCode, Date from, Date to) {
        String tempDir = getTempPath();
        String fileName = generateFileName(stockCode, from, to);
        String fullPath = FileUtil.directoryPathFormat(tempDir) + fileName;
        try {
            FileUtil.createNewFile(fullPath);
            log.info("Create new file {}.", fullPath);
            return new FileOutputStream(fullPath);
        } catch (IOException e) {
            log.error("Create file " + fullPath + " failed.", e);
            throw new SpiderRuntimeException("Create file " + fullPath + " failed.");
        }
    }
    
    private String generateFileName(String stockCode, Date from, Date to) {
        return stockCode + "-" + DateUtil.formatDate(from, DATE_FORMAT) + "-" + DateUtil.formatDate(to, DATE_FORMAT) + FILE_EXT_NAME;
    }
    
    private String generateUrl(String stockCode, Date from, Date to, RestorationType restorationType) {
        String baseUrl = getBaseUrl();
        String paramStr = generateParams(stockCode, from, to);
        return baseUrl + "?" + paramStr;
    }
    
    private String generateParams(String stockCode, Date from, Date to) {
        String fullCode = StockCodeUtil.isSH(stockCode) ? SH_CODE_PREFIX + stockCode
                                  : SZ_CODE_PREFIX + stockCode;
        StringBuilder builder = new StringBuilder();
        builder.append(CODE_PARAM_KEY).append("=").append(fullCode)
                .append("&")
                .append(START_PARAM_KEY).append("=").append(DateUtil.formatDate(from, DATE_FORMAT))
                .append("&")
                .append(END_PARAM_KEY).append("=").append(DateUtil.formatDate(to, DATE_FORMAT))
                .append("&")
                .append(FIELDS_PARAM_STRING);
        return builder.toString();
    }
}
