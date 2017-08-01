package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.core.entity.HistoryDataMetadata;
import com.coderli.yummystock.core.service.HistoryDataMetadataService;
import com.coderli.yummystock.core.util.DateUtil;
import com.coderli.yummystock.core.util.FileUtil;
import com.coderli.yummystock.core.util.StockCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * @author li.hzh
 * @date 2017-07-27 21:37
 */
@Slf4j
public abstract class AbstractNetEaseDataSpider extends AbstractSingleStockHistoryDataSpider {
    
    private static final String FIELDS_PARAM_STRING = "fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;TURNOVER;VOTURNOVER;VATURNOVER;TCAP;MCAP";
    private static final String CODE_PARAM_KEY = "code";
    private static final String START_PARAM_KEY = "start";
    private static final String END_PARAM_KEY = "end";
    private static final String SH_CODE_PREFIX = "0";
    private static final String SZ_CODE_PREFIX = "1";
    private static final String FILE_EXT_NAME = ".csv";
    private static final String DATE_FORMAT = "yyyyMMdd";
    
    @Autowired
    protected HistoryDataMetadataService metadataService;
    
    protected void updateMetadata(String stockCode, Date from, Date to) {
        log.debug("Save metadata, start {}, end {}, code {}.", from, to, stockCode);
        HistoryDataMetadata updateMetadata = new HistoryDataMetadata(stockCode, from, to);
        metadataService.updateMetadata(updateMetadata);
    }
    
    protected String getFilePath(String stockCode, Date from, Date to) {
        String tempDir = getTempPath();
        String fileName = generateFileName(stockCode, from, to);
        return FileUtil.directoryPathFormat(tempDir) + fileName;
    }
    
    protected OutputStream createOutputStream(String filePath) {
        try {
            FileUtil.createNewFile(filePath);
            log.info("Create new file {}.", filePath);
            return new FileOutputStream(filePath);
        } catch (IOException e) {
            log.error("Create file " + filePath + " failed.", e);
            throw new SpiderRuntimeException("Create file " + filePath + " failed.");
        }
    }
    
    
    protected String generateFileName(String stockCode, Date from, Date to) {
        return stockCode + "-" + DateUtil.formatDate(from, DATE_FORMAT) + "-" + DateUtil.formatDate(to, DATE_FORMAT) + FILE_EXT_NAME;
    }
    
    protected String generateUrl(String stockCode, Date from, Date to) {
        String baseUrl = getBaseUrl();
        String paramStr = generateParams(stockCode, from, to);
        return baseUrl + "?" + paramStr;
    }
    
    protected String generateParams(String stockCode, Date from, Date to) {
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
