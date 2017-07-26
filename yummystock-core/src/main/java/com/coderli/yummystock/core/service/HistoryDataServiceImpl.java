package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.dao.HistoryDataDao;
import com.coderli.yummystock.core.entity.HistoryStockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-26 15:02
 */
@Service
public class HistoryDataServiceImpl implements HistoryDataService {
    
    @Autowired
    private HistoryDataDao historyDataDao;
    
    @Override
    public void saveSingleStockHistoryData(List<HistoryStockData> historyStockDataList) {
        historyDataDao.saveHistoryDatas(historyStockDataList);
    }
    
    @Override
    public void removeAll() {
        historyDataDao.removeAll();
    }
}
