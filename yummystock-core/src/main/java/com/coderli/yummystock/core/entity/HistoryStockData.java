package com.coderli.yummystock.core.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author li.hzh
 * @date 2016-11-30 23:32
 */
@Data
public class HistoryStockData {
    
    private double openPrice;
    private double closePrice;
    private double highPrice;
    private double lowPrice;
    private Date date;
    private long volumeOfTrading;
    private long volumeOfTradingInMoney;
    private double changePercentage;
    
}
