package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.core.entity.Stock;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-17 16:56
 */
public interface SZStockSpider extends StockSpider {

    List<Stock> getAllSZStocks();

}
