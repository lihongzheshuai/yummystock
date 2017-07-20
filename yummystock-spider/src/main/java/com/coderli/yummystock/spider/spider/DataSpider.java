package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.spider.handler.SpiderDataHandler;

/**
 * @author li.hzh
 * @date 2016-12-06 23:35
 */
public interface DataSpider {
    
    SpiderDataHandler getHandler();
    
}
