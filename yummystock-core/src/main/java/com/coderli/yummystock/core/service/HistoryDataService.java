package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.entity.HistoryStockData;

import java.util.Date;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-26 14:59
 */
public interface HistoryDataService {
    
    void saveHistoryDatas(List<HistoryStockData> historyStockDataList);
    
    /**
     * 清除所有数据
     */
    void removeAll();
    
    
    void saveSingleData(HistoryStockData historyStockData);
    
    List<HistoryStockData> findByStockCode(String stockCode);
    
    /**
     * 获取指定股票，指定日期的历史数据
     *
     * @param stockCode
     * @param date
     * @return
     */
    HistoryStockData findData(String stockCode, Date date);
}
