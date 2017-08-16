package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.core.entity.HistoryStockData;

import java.util.List;

/**
 * 单股票历史数据爬取接口
 *
 * @author li.hzh
 * @date 2016-11-29 00:09
 */
public interface SingleStockHistoryDataSpider extends HistoryDataSpider<List<HistoryStockData>> {
    

}
