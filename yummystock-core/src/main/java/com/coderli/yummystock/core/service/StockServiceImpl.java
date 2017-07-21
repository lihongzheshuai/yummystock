package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.dao.MongoConnector;
import com.coderli.yummystock.core.entity.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-20 23:04
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService {
    
    @Autowired
    private MongoConnector mongoConnector;
    
    @Override
    public void saveStocks(List<Stock> stocks) {
        log.debug("Save stocks.");
        mongoConnector.bulkSave(stocks, Stock.class);
    }
    
}
