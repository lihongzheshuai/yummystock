package com.coderli.yummystock.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author li.hzh
 * @date 2017-07-17 15:46
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "stocks")
public class Stock {
    
    @Id
    @Indexed
    private String code;
    /**
     * 完整的股票代码，带sz、sh
     */
    private String symbol;
    private String name;
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Code: ").append(symbol).append(",")
                .append("Name: ").append(name);
        return builder.toString();
    }
}
