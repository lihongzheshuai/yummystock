package com.coderli.yummystock.spider;

import com.coderli.yummystock.core.entity.Stock;
import com.coderli.yummystock.core.util.ListUtil;
import com.coderli.yummystock.spider.config.StockCodeSpiderConfig;
import com.coderli.yummystock.spider.config.StockCodeSpiderConfigBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-17 22:37
 */
public abstract class AbstractStockSpider implements SHStockSpider, SZStockSpider {
    
    @Autowired
    private StockCodeSpiderConfigBean stockCodeSpiderConfigBean;
    
    @Override
    public List<Stock> getAllStock() {
        List<Stock> shStocks = getAllSHStocks();
        List<Stock> szStocks = getAllSZStocks();
        return ListUtil.merge(shStocks, szStocks);
    }
    
    protected String getBaseUrl() {
        return stockCodeSpiderConfigBean.getBaseUrl();
    }
    
    protected String getAppKey() {
        return stockCodeSpiderConfigBean.getAppkey();
    }
}
