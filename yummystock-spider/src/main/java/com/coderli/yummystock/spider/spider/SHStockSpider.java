package com.coderli.yummystock.spider;

import com.coderli.yummystock.core.entity.Stock;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-17 16:19
 */
public interface SHStockSpider extends StockSpider {
    
    /**
     * 获取所有沪股列表
     *
     * @return
     */
    List<Stock> getAllSHStocks();
    
}
