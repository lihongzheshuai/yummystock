package com.coderli.yummystock.spider.crawler.parser;

import com.coderli.yummystock.core.entity.HistoryStockData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author li.hzh
 * @date 2016-12-01 00:07
 */
@Slf4j
@Component
public class TencentHistoryDataParser implements RawHistoryDataParser {
    
    @Override
    public List<HistoryStockData> parseRawData(String rawData) {
        return null;
    }
    
}
