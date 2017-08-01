package com.coderli.yummystock.spider.parser;

import com.coderli.yummystock.core.entity.HistoryStockData;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-25 23:43
 */
@Slf4j
public class NetEaseHistoryDataParser extends AbstractHistoryDataParser<File, List<HistoryStockData>> {
    
    @Override
    public List<HistoryStockData> parse(@NonNull File input) {
        if (!input.exists()) {
            log.warn("File {} not exist.", input.getName());
            return Collections.EMPTY_LIST;
        }
        return doParse(input);
    }
    
    private List<HistoryStockData> doParse(File input) {
        List<HistoryStockData> result = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(input);
             BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("gbk")))
        ) {
            // 略过第一行表头
            String th = br.readLine();
            log.debug("Table head: {}", th);
            String line = br.readLine();
            while (line != null) {
                HistoryStockData historyData = parseLine(line);
                result.add(historyData);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            // 不可能出现
            log.error("Impossible", e);
        } catch (IOException e) {
            log.error("IO Exception.", e);
        }
        return result;
    }
    
}
