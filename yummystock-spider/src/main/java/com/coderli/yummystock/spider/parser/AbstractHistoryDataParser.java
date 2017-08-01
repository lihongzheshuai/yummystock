package com.coderli.yummystock.spider.parser;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author li.hzh
 * @date 2017-07-31 13:38
 */
@Slf4j
public abstract class AbstractHistoryDataParser<I, R> implements DataParser<I, R> {
    
    private static final int COLUMN_COUNT = 15;
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
    
    private static final String NONE = "None";
    
    protected HistoryStockData parseLine(String line) {
        String[] values = line.split(",");
        validateValues(values);
        HistoryStockData historyData = new HistoryStockData();
        assembleHistoryData(historyData, values);
        return historyData;
    }
    
    private void assembleHistoryData(HistoryStockData historyData, String[] values) {
        historyData.setDate(DateUtil.parseDate(values[DATE_COLUMN_INDEX]));
        historyData.setStockCode(formatCode(values[CODE_COLUMN_INDEX]));
        historyData.setName(values[NAME_COLUMN_INDEX]);
        historyData.setClosePrice(Double.parseDouble(values[CLOSE_PRICE_COLUMN_INDEX]));
        historyData.setHighPrice(Double.parseDouble(values[HIGHEST_PRICE_COLUMN_INDEX]));
        historyData.setLowPrice(Double.parseDouble(values[LOWEST_PRICE_COLUMN_INDEX]));
        historyData.setOpenPrice(Double.parseDouble(values[OPEN_PRICE_COLUMN_INDEX]));
        historyData.setLastClosePrice(Double.parseDouble(values[LAST_CLOSE_PRICE_COLUMN_INDEX]));
        if (!values[CHANGE_PRICE_COLUMN_INDEX].equals(NONE)) {
            historyData.setChangePrice(Double.parseDouble(values[CHANGE_PRICE_COLUMN_INDEX]));
        }
        if (!values[CHANGE_PERCENTAGE_COLUMN_INDEX].equals(NONE)) {
            historyData.setChangePercentage(Double.parseDouble(values[CHANGE_PERCENTAGE_COLUMN_INDEX]));
        }
        if (!values[TURNOVER_RATE_COLUMN_INDEX].equals(NONE)) {
            historyData.setTurnoverRate(Double.parseDouble(values[TURNOVER_RATE_COLUMN_INDEX]));
        }
        historyData.setVolumeOfTrading(Double.parseDouble(values[VOLUMN_OF_TRADING_COLUMN_INDEX]));
        historyData.setVolumeOfTradingInMoney(Double.parseDouble(values[VOLUMN_OF_TRADING_IN_MONEY_COLUMN_INDEX]));
        historyData.setTotalMarketValue(Double.parseDouble(values[TOTAL_MARKET_VALUE_COLUMN_INDEX]));
        historyData.setCirculationMarketValue(Double.parseDouble(values[CIRCULATION_MARKET_VALUE_COLUMN_INDEX]));
    }
    
    private String formatCode(String code) {
        return code.startsWith("'") ? code.substring(1) : code;
    }
    
    private void validateValues(String[] values) {
        if (values.length != COLUMN_COUNT) {
            log.error("Illegal history data file with column count {}, needs {}", values.length, COLUMN_COUNT);
            throw new IllegalArgumentException("Illegal history data file");
        }
    }
    
}
