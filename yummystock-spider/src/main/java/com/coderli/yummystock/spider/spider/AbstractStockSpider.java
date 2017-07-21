package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.core.entity.Stock;
import com.coderli.yummystock.core.util.ListUtil;
import com.coderli.yummystock.spider.config.StockCodeSpiderConfigBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-17 22:37
 */
@Slf4j
public abstract class AbstractStockSpider implements SHStockSpider, SZStockSpider {
    
    @Autowired
    private StockCodeSpiderConfigBean stockCodeSpiderConfigBean;
    
    @Override
    public List<Stock> getAllStock() {
        List<Stock> shStocks = getAllSHStocks();
        log.debug("Get all sh stocks. Count: {}", shStocks.size());
        List<Stock> szStocks = getAllSZStocks();
        log.debug("Get all sz stocks. Count: {}", szStocks.size());
        return ListUtil.merge(shStocks, szStocks);
    }
    
    protected String getBaseUrl() {
        return stockCodeSpiderConfigBean.getBaseUrl();
    }
    
    protected String getAppKey() {
        return stockCodeSpiderConfigBean.getAppkey();
    }
}
