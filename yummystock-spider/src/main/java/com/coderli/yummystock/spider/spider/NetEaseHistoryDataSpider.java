package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.http.HttpClient;
import com.coderli.yummystock.core.http.impl.SimpleRestHttpClient;
import com.coderli.yummystock.spider.parser.DataParser;
import com.coderli.yummystock.spider.parser.NetEaseHistoryDataParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-06-15 23:10
 */
@Slf4j
@Component
public class NetEaseHistoryDataSpider extends AbstractNetEaseDataSpider implements SingleStockHistoryDataSpider {
    
    private HttpClient httpClient = new SimpleRestHttpClient();
    private DataParser<File, List<HistoryStockData>> dataParser = new NetEaseHistoryDataParser();
    
    @Override
    public List<HistoryStockData> crawlHistoryData(String stockCode, Date from, Date to, RestorationType restorationType) {
        log.debug("Get stock {} history data. From {} to {}.", stockCode, from, to);
        String url = generateUrl(stockCode, from, to, restorationType);
        String filePath = getFilePath(stockCode, from, to);
        File historyFile = new File(filePath);
        List<HistoryStockData> historyStockData = null;
        if (!historyFile.exists()) {
            httpClient.writeToStream(url, createOutputStream(filePath));
        } else {
            log.debug("History data file {} exists, just parse it.", filePath);
        }
        historyStockData = dataParser.parse(new File(filePath));
        return historyStockData;
    }
    
}
