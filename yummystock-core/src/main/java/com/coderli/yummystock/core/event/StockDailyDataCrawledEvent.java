package com.coderli.yummystock.core.event;

import com.coderli.yummystock.core.entity.Stock;

/**
 * @author li.hzh
 * @date 2017-08-07 23:47
 */
public class StockDailyDataCrawledEvent extends AbstractEvent {
    
    private Stock stock;
    
    /**
     * Create a new ApplicationEvent.
     *
     * @param stock the object on which the event initially occurred (never {@code null})
     */
    public StockDailyDataCrawledEvent(Stock stock) {
        super(stock);
    }
}
