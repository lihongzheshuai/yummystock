package com.coderli.yummystock.core.dao;

import com.coderli.yummystock.core.entity.HistoryStockData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-26 15:03
 */
@Repository
public class HistoryDataDao extends BaseDao<HistoryStockData> {
    
    public void saveHistoryDatas(List<HistoryStockData> historyDatas) {
        mongoConnector.bulkSave(historyDatas, HistoryStockData.class);
    }
    
    public void removeAll() {
        mongoConnector.removeAll(HistoryStockData.class);
    }
}
