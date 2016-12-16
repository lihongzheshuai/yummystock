package com.coderli.yummystock.spider.crawler.parser;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.entity.HistoryStockData;

import java.util.List;

/**
 * Parser for raw history data.
 *
 * @author li.hzh
 * @date 2016-11-30 23:19
 */
public interface RawHistoryDataParser {
    
    /**
     * Parse raw history data to {@link HistoryStockData} list.
     *
     * @param rawData raw data
     * @return
     */
    List<HistoryStockData> parseRawData(String rawData, String fullStockCode, RestorationType restorationType);
    
}
