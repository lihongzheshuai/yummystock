package com.coderli.yummystock.spider.executor;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.entity.Stock;
import com.coderli.yummystock.core.service.HistoryDataService;
import com.coderli.yummystock.core.service.StockService;
import com.coderli.yummystock.spider.spider.DailyDataSpider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-27 22:24
 */
@Component
@Slf4j
public class DailyStockDataExecutor extends AbstractDailyStockDataExecutor {
    
    @Autowired
    private DailyDataSpider dataSpider;
    @Autowired
    private HistoryDataService historyDataService;
    @Autowired
    private StockService stockService;
    
    @Override
    public void execute() {
        List<Stock> stocks = stockService.getAllStocks();
        if (stocks == null || stocks.isEmpty()) {
            log.warn("No stock has been stored, Please get it first.");
            return;
        }
        stocks.stream().forEach(stock -> {
            List<HistoryStockData> historyStockDatas = dataSpider.crawlDailyData(stock.getCode());
            historyDataService.saveHistoryDatas(historyStockDatas);
        });
    }
    
}
