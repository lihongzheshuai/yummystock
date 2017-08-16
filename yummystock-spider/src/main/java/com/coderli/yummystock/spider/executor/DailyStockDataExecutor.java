package com.coderli.yummystock.spider.executor;

import com.coderli.yummystock.core.entity.HistoryDataMetadata;
import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.entity.Stock;
import com.coderli.yummystock.core.service.HistoryDataMetadataService;
import com.coderli.yummystock.core.service.HistoryDataService;
import com.coderli.yummystock.core.service.StockService;
import com.coderli.yummystock.core.util.DateUtil;
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
    @Autowired
    private HistoryDataMetadataService metadataService;
    
    @Override
    public void execute() {
        List<Stock> stocks = stockService.getAllStocks();
        if (stocks == null || stocks.isEmpty()) {
            log.warn("No stock has been stored, Please get it first.");
            return;
        }
        log.info("Today stock data exist, get it now.");
        stocks.stream().forEach(stock -> doExecuteMetaData(stock));
    }
    
    private void doExecuteMetaData(Stock stock) {
        HistoryDataMetadata metadata = metadataService.getMetadata(stock.getCode());
        if (metadata == null) {
            log.error("No history metadata exists for stock {}. Plz init history data first.", stock.getCode());
            return;
        }
        Date from = DateUtil.tomorrowOfDate(metadata.getEnd());
        Date to = DateUtil.todayDate();
        if (!DateUtil.isEarlierThan(from, to)) {
            log.warn("FROM date is later than TO date, just skip crawling tody. FROM {} <-> TO {}.", from, to);
            return;
        }
        List<HistoryStockData> historyStockDatas = dataSpider.crawlData(stock.getCode(), from, to);
        if (historyStockDatas == null || historyStockDatas.isEmpty()) {
            log.warn("No daily data get. Just skip to next. Current stock: {}.", stock);
            //TODO 初始化历史数据及元数据
            return;
        }
        log.debug("Get {} days data of stock {}.", historyStockDatas.size(), stock);
        historyDataService.saveHistoryDatas(historyStockDatas);
        log.debug("Save metadata, start {}, end {}, code {}.", from, to, stock.getCode());
        metadataService.updateMetadata(stock.getCode(), from, to);
    }
    
}
