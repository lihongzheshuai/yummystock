package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.entity.HistoryStockData;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-26 14:59
 */
public interface HistoryDataService {
    
    void saveStockHistoryData(List<HistoryStockData> historyStockDataList);
    
    /**
     * 清除所有数据
     */
    void removeAll();
    
}
