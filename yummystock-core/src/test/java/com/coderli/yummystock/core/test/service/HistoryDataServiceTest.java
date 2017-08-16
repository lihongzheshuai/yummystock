package com.coderli.yummystock.core.test.service;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.service.HistoryDataService;
import com.coderli.yummystock.core.test.mongo.MongoTestConfig;
import com.coderli.yummystock.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

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
        System.out.println(historyDataService.findData("900000", DateUtil.parseDate("2200-01-03")));
    }
    
    @Test
    public void testSavedata() {
        String code = "900000";
        Date date = DateUtil.parseDate("2200-01-03");
        HistoryStockData data = new HistoryStockData();
        HistoryStockData.HistoryDatekey key = new HistoryStockData.HistoryDatekey(code, date);
        data.setStockCode(code);
        data.setDate(date);
        data.setOpenPrice(200.00);
        data.set_id(key);
        historyDataService.saveSingleData(data);
    }
}
