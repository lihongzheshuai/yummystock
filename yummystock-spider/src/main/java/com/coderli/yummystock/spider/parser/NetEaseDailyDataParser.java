package com.coderli.yummystock.spider.parser;

import com.coderli.yummystock.core.entity.HistoryStockData;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-27 15:04
 */
@Slf4j
public class NetEaseDailyDataParser extends AbstractHistoryDataParser<ByteArrayOutputStream, List<HistoryStockData>> {
    
    @Override
    public List<HistoryStockData> parse(ByteArrayOutputStream input) {
        List<HistoryStockData> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                                                                       new InputStreamReader(
                                                                                                    new ByteArrayInputStream(input.toByteArray()), Charset.forName("gbk")))) {
            // 略过第一行表头
            String th = bufferedReader.readLine();
            log.debug("Table head: {}", th);
            String line = bufferedReader.readLine();
            while (line != null) {
                HistoryStockData historyData = parseLine(line);
                result.add(historyData);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            log.error("Parse daily data error.", e);
        }
        return result;
    }
}
