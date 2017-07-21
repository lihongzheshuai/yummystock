package com.coderli.yummystock.spider.handler;

/**
 * The data handler of crawled data.
 *
 * @author li.hzh
 * @date 2016-12-06 23:36
 */
public interface SpiderDataHandler<T, R> {
    
    /**
     * 处理业务数据
     *
     * @param t
     * @return
     */
    R handle(T t);
    
}
