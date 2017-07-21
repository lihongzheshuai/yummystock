package com.coderli.yummystock.core.test.mongo;

import com.coderli.yummystock.core.dao.MongoConnector;
import com.coderli.yummystock.core.entity.Stock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-21 23:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class MongoConnectorTest {
    
    @Autowired
    private MongoConnector mongoConnector;
    private Stock stockOne;
    private Stock stockTwo;
    
    @Before
    public void createStocks() {
        stockOne = new Stock();
        stockOne.setSymbol("sh600177");
        stockOne.setCode("600177");
        stockOne.setName("雅戈尔");
        stockTwo = new Stock();
        stockTwo.setSymbol("sz000831");
        stockTwo.setCode("000831");
        stockTwo.setName("五矿稀土");
    }
    
    @Test
    public void testInsert() {
        mongoConnector.insert(stockOne);
    }
    
    @Test
    public void testRemove() {
        mongoConnector.remove(stockOne);
    }
    
    @Test
    public void testBulkInsert() {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(stockOne);
        stocks.add(stockTwo);
        mongoConnector.bulkSave(stocks, Stock.class);
    }
}
