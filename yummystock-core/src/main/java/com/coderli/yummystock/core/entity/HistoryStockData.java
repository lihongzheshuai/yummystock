package com.coderli.yummystock.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author li.hzh
 * @date 2016-11-30 23:32
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "historydatas")
@CompoundIndexes(@CompoundIndex(name = "history_data_cop_idx", def = "{stockCode:1, date: 1 }"))
public class HistoryStockData {
    
    @Id
    private HistoryDatekey _id;
    @Indexed(background = true)
    private String stockCode;
    private Date date;
    private double openPrice;
    private double closePrice;
    private double highPrice;
    private double lowPrice;
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
    
    @Data
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class HistoryDatekey implements Serializable {
        private String stockCode;
        private Date date;
    }
}
