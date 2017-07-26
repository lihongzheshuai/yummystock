package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.core.entity.Stock;

import java.util.List;

/**
 * 股票代码列表爬取接口
 *
 * @author li.hzh
 * @date 2017-07-17 15:30
 */
public interface StockSpider extends DataSpider {
    
    List<Stock> getAllStock();
    
}
