package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.entity.Stock;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-20 23:04
 */
public interface StockService {
    
    void saveStocks(List<Stock> stocks);
    
}
