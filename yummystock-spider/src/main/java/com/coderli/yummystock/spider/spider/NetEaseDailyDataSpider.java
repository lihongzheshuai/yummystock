package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.http.HttpClient;
import com.coderli.yummystock.core.http.impl.SimpleRestHttpClient;
import com.coderli.yummystock.spider.parser.DataParser;
import com.coderli.yummystock.spider.parser.NetEaseDailyDataParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-27 14:45
 */
@Slf4j
@Component
public class NetEaseDailyDataSpider extends NetEaseHistoryDataSpider implements SingleStockHistoryDataSpider {
    
    private HttpClient httpClient = new SimpleRestHttpClient();
    private DataParser<ByteArrayOutputStream, HistoryStockData> dataParser = new NetEaseDailyDataParser();
    
    @Override
    public List<HistoryStockData> crawlHistoryData(String stockCode, Date from, Date to, RestorationType restorationType) {
        log.debug("Get stock {} history data. From {} to {}.", stockCode, from, to);
        String url = generateUrl(stockCode, from, to, restorationType);
        String filePath = getFilePath(stockCode, from, to);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        httpClient.writeToStream(url, outputStream);
        HistoryStockData historyStockData = dataParser.parse(outputStream);
        return Collections.singletonList(historyStockData);
    }
}
