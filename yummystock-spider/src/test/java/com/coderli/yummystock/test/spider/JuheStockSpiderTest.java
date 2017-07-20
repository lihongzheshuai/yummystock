package com.coderli.yummystock.test.spider;

import com.coderli.yummystock.core.entity.Stock;
import com.coderli.yummystock.spider.spider.SZStockSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-18 16:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpiderTestConfig.class)
public class JuheStockSpiderTest {
    
    @Autowired
    private SZStockSpider juheStockSpider;

    @Test
    public void testGetAllSZStock() {
        List<Stock> stockList = juheStockSpider.getAllSZStocks();
        System.out.println(stockList.size());
    }

}
