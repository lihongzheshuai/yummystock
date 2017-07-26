package com.coderli.yummystock.spider.parser;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.util.DateUtil;
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
public class NetEaseHistoryDataParser implements DataParser<File, List<HistoryStockData>> {
    
    private static final int COLUMN_COUNT = 15;
    private static final String DATE_PATTERN = "yyyy/MM/dd";
    private static final int DATE_COLUMN_INDEX = 0;
    private static final int CODE_COLUMN_INDEX = 1;
    private static final int NAME_COLUMN_INDEX = 2;
    private static final int CLOSE_PRICE_COLUMN_INDEX = 3;
    private static final int HIGHEST_PRICE_COLUMN_INDEX = 4;
    private static final int LOWEST_PRICE_COLUMN_INDEX = 5;
    private static final int OPEN_PRICE_COLUMN_INDEX = 6;
    private static final int LAST_CLOSE_PRICE_COLUMN_INDEX = 7;
    private static final int CHANGE_PRICE_COLUMN_INDEX = 8;
    private static final int CHANGE_PERCENTAGE_COLUMN_INDEX = 9;
    private static final int TURNOVER_RATE_COLUMN_INDEX = 10;
    private static final int VOLUMN_OF_TRADING_COLUMN_INDEX = 11;
    private static final int VOLUMN_OF_TRADING_IN_MONEY_COLUMN_INDEX = 12;
    private static final int TOTAL_MARKET_VALUE_COLUMN_INDEX = 13;
    private static final int CIRCULATION_MARKET_VALUE_COLUMN_INDEX = 14;
    
    
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
    
    private HistoryStockData parseLine(String line) {
        String[] values = line.split(",");
        validateValues(values);
        HistoryStockData historyData = new HistoryStockData();
        assembleHistoryData(historyData, values);
        return historyData;
    }
    
    private void assembleHistoryData(HistoryStockData historyData, String[] values) {
        historyData.setDate(DateUtil.parseDate(values[DATE_COLUMN_INDEX]));
        historyData.setStockCode(values[CODE_COLUMN_INDEX]);
        historyData.setName(values[NAME_COLUMN_INDEX]);
        historyData.setClosePrice(Double.parseDouble(values[CLOSE_PRICE_COLUMN_INDEX]));
        historyData.setHighPrice(Double.parseDouble(values[HIGHEST_PRICE_COLUMN_INDEX]));
        historyData.setLowPrice(Double.parseDouble(values[LOWEST_PRICE_COLUMN_INDEX]));
        historyData.setOpenPrice(Double.parseDouble(values[OPEN_PRICE_COLUMN_INDEX]));
        historyData.setLastClosePrice(Double.parseDouble(values[LAST_CLOSE_PRICE_COLUMN_INDEX]));
        historyData.setChangePrice(Double.parseDouble(values[CHANGE_PRICE_COLUMN_INDEX]));
        historyData.setChangePercentage(Double.parseDouble(values[CHANGE_PERCENTAGE_COLUMN_INDEX]));
        historyData.setTurnoverRate(Double.parseDouble(values[TURNOVER_RATE_COLUMN_INDEX]));
        historyData.setVolumeOfTrading(Double.parseDouble(values[VOLUMN_OF_TRADING_COLUMN_INDEX]));
        historyData.setVolumeOfTradingInMoney(Double.parseDouble(values[VOLUMN_OF_TRADING_IN_MONEY_COLUMN_INDEX]));
        historyData.setTotalMarketValue(Double.parseDouble(values[TOTAL_MARKET_VALUE_COLUMN_INDEX]));
        historyData.setCirculationMarketValue(Double.parseDouble(values[CIRCULATION_MARKET_VALUE_COLUMN_INDEX]));
    }
    
    private void validateValues(String[] values) {
        if (values.length != COLUMN_COUNT) {
            log.error("Illegal history data file with column count {}, needs {}", values.length, COLUMN_COUNT);
            throw new IllegalArgumentException("Illeg al history data file");
        }
    }
}
