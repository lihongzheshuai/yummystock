package com.coderli.yummystock.spider.converter.model;

import com.coderli.yummystock.core.entity.Stock;
import lombok.Data;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-19 11:01
 */
@Data
public class JuheHttpPageResult {
    
    private int totalCount;
    private int page;
    private int num;
    private List<Stock> data;
    
}
