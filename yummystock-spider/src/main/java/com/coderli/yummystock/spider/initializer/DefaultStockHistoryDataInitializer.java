package com.coderli.yummystock.spider.initializer;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.entity.Stock;
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
    private static final Date TODAY = new Date();
    
    private SingleStockHistoryDataSpider historyDataSpider;
    private StockService stockService;
    private HistoryDataService historyDataService;
    
    public DefaultStockHistoryDataInitializer() {
        historyDataSpider = BeanUtil.getBean(SingleStockHistoryDataSpider.class);
        stockService = BeanUtil.getBean(StockService.class);
        historyDataService = BeanUtil.getBean(HistoryDataService.class);
    }
    
    @Override
    public void init(boolean clean) {
        if (clean) {
            clean();
        }
        List<Stock> allStocks = stockService.getAllStocks();
        for (Stock stock : allStocks) {
            log.debug("Get history data of stock {}.", stock);
            crawlAndSaveHistoryData(stock);
        }
    }
    
    private void clean() {
        historyDataService.removeAll();
    }
    
    private void crawlAndSaveHistoryData(Stock stock) {
        Date start = DateUtil.parseDate(START_DATE);
        Date end = TODAY;
        List<HistoryStockData> historyDatas = historyDataSpider.crawlHistoryData(stock.getCode(), start, end, null);
        log.debug("Get {} days history data of stock {}.", historyDatas.size(), stock.toString());
        historyDataService.saveSingleStockHistoryData(historyDatas);
    }
    
}
