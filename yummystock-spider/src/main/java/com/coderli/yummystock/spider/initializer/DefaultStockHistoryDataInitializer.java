package com.coderli.yummystock.spider.initializer;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.entity.Stock;
import com.coderli.yummystock.core.service.HistoryDataMetadataService;
import com.coderli.yummystock.core.service.HistoryDataService;
import com.coderli.yummystock.core.service.StockService;
import com.coderli.yummystock.core.util.BeanUtil;
import com.coderli.yummystock.core.util.DateUtil;
import com.coderli.yummystock.spider.spider.SingleStockHistoryDataSpider;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-22 22:11
 */
@Slf4j
public class DefaultStockHistoryDataInitializer implements StockHistoryDataInitializer {
    
    private static final String START_DATE = "2000-01-01";
    private static final Date YESTERDAY = DateUtil.yesterdayDate();
    
    private SingleStockHistoryDataSpider historyDataSpider;
    private StockService stockService;
    private HistoryDataService historyDataService;
    private HistoryDataMetadataService metadataService;
    
    public DefaultStockHistoryDataInitializer() {
        historyDataSpider = BeanUtil.getBean(SingleStockHistoryDataSpider.class);
        stockService = BeanUtil.getBean(StockService.class);
        historyDataService = BeanUtil.getBean(HistoryDataService.class);
        metadataService = BeanUtil.getBean(HistoryDataMetadataService.class);
    }
    
    @Override
    public void init(boolean clean) {
        if (clean) {
            clean();
        }
        new Thread(() -> {
            List<Stock> allStocks = stockService.getAllStocks();
            Date start = DateUtil.parseDate(START_DATE);
            Date end = YESTERDAY;
            if (allStocks == null || allStocks.isEmpty()) {
                log.info("No stock data find. Can not init history data.");
                return;
            }
            for (Stock stock : allStocks) {
                log.info("Get history data of stock {}.", stock);
                try {
                    crawlAndSaveHistoryData(stock, start, end, clean);
                } catch (Throwable t) {
                    log.error("Get error, but just continue.", t);
                    continue;
                }
            }
            log.info("Init stock history data finished. Total stock count: {}.", allStocks.size());
        }).start();
    }
    
    private void clean() {
        historyDataService.removeAll();
        metadataService.removeAll();
    }
    
    private void crawlAndSaveHistoryData(Stock stock, Date start, Date end, boolean clean) {
        List<HistoryStockData> historyDatas = historyDataSpider.crawlHistoryData(stock.getCode(), start, end, null);
        log.debug("Get {} days history data of stock {}.", historyDatas.size(), stock.toString());
        if (!historyDatas.isEmpty()) {
            historyDataService.saveHistoryDatas(historyDatas);
        }
        
    }
    
}
