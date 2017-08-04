package com.coderli.yummystock.core.test.service;

import com.coderli.yummystock.core.entity.HistoryDataMetadata;
import com.coderli.yummystock.core.service.HistoryDataMetadataService;
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
 * @date 2017-07-31 16:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class HistoryMetadataTest {

    @Autowired
    private HistoryDataMetadataService historyDataMetadataService;

    @Test
    public void testSaveMetadata() {
        HistoryDataMetadata metadata = new HistoryDataMetadata();
        metadata.setCode("600887");
        metadata.setBegin(DateUtil.yesterdayDate());
        metadata.setEnd(DateUtil.todayDate());
        historyDataMetadataService.saveMetadata(metadata);
    }
    
    @Test
    public void testGetMetadata() {
        HistoryDataMetadata metadata = historyDataMetadataService.getMetadata("600000");
        System.out.println(metadata.getCode());
        System.out.println(metadata.getBegin());
    }
    
    @Test
    public void testUpdateMetadata() {
        HistoryDataMetadata metadata = historyDataMetadataService.getMetadata("600177");
        System.out.println(metadata.getCode());
        System.out.println(metadata.getBegin());
        metadata.setBegin(DateUtil.parseDate("2017-07-30"));
        metadata.setCode("600123");
        historyDataMetadataService.updateMetadata(metadata);
        metadata = historyDataMetadataService.getMetadata("600123");
        System.out.println(metadata.getCode());
        System.out.println(metadata.getBegin());
    }

}
