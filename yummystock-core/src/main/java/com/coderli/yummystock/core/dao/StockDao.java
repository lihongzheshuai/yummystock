package com.coderli.yummystock.core.dao;

import com.coderli.yummystock.core.entity.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-25 22:55
 */
@Repository
public class StockDao extends BaseDao<Stock> {
    
    public void saveStocks(List<Stock> stocks) {
        mongoConnector.bulkSave(stocks, Stock.class);
    }
    
    public List<Stock> getAllStocks() {
        return mongoConnector.findAll(Stock.class);
    }
    
    public void removeAll() {
        mongoConnector.removeAll(Stock.class);
    }
    
    
}
