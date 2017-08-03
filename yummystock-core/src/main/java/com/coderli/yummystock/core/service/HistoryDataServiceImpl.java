package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.repository.HistoryDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-26 15:02
 */
@Service
@Slf4j
public class HistoryDataServiceImpl implements HistoryDataService {
    
    @Autowired
    private HistoryDataRepository historyDataRepository;
    
    @Override
    public void saveHistoryDatas(List<HistoryStockData> historyStockDataList) {
        historyDataRepository.insert(historyStockDataList);
    }
    
    @Override
    public void removeAll() {
        historyDataRepository.deleteAll();
    }
    
    @Override
    public void saveSingleData(HistoryStockData historyStockData) {
        historyDataRepository.insert(historyStockData);
    }
    
    @Override
    public List<HistoryStockData> findByStockCode(String stockCode) {
        return historyDataRepository.findAllByStockCode(stockCode);
    }
}
