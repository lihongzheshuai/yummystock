package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.entity.Stock;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-20 23:04
 */
public interface StockService {
    
    /**
     * 批量保存股票数据
     *
     * @param stocks
     */
    void saveStocks(List<Stock> stocks);
    
    /**
     * 获取全部股票基本信息
     *
     * @return
     */
    List<Stock> getAllStocks();
    
    /**
     * 清除所有数据
     */
    void removeAll();
}
