package com.coderli.yummystock.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author li.hzh
 * @date 2016-11-30 23:32
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "historydatas")
public class HistoryStockData {
    
    @Id
    private String stockCode;
    private double openPrice;
    private double closePrice;
    private double highPrice;
    private double lowPrice;
    private Date date;
    private double volumeOfTrading;
    private double volumeOfTradingInMoney;
    private double changePercentage;
    private double turnoverRate;
    private String name;
    // 前收盘
    private double lastClosePrice;
    // 涨跌额
    private double changePrice;
    // 总市值
    private double totalMarketValue;
    // 流通市值
    private double circulationMarketValue;
}
