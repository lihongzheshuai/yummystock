package com.coderli.yummystock.test.spider.parser;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.spider.parser.NetEaseHistoryDataParser;
import com.coderli.yummystock.test.spider.SpiderTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-26 16:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpiderTestConfig.class)
public class NetEaseParserTest {

    private NetEaseHistoryDataParser dataParser = new NetEaseHistoryDataParser();
    
    @Test
    public void testDataParser() {
        String filePath = "/Users/apple/Downloads/stock/600000-20000101-20170726.csv";
        File file = new File(filePath);
        List<HistoryStockData> output = dataParser.parse(file);
        System.out.println("History data size " + output.size());
    }

}
