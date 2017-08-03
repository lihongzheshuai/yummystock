package com.coderli.yummystock.core.test.service;

import com.coderli.yummystock.core.service.HistoryDataService;
import com.coderli.yummystock.core.test.mongo.MongoTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author li.hzh
 * @date 2017-08-02 16:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class HistoryDataServiceTest {
    
    @Autowired
    private HistoryDataService historyDataService;
    
    @Test
    public void testFindOne() {
        System.out.println(historyDataService.findByStockCode("600000"));
    }
}
