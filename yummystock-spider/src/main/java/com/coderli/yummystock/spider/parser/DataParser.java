package com.coderli.yummystock.spider.parser;

/**
 * @author li.hzh
 * @date 2017-07-25 23:32
 */
public interface DataParser<I, R> {
    
    /**
     * 解析数据
     *
     * @param input
     * @return
     */
    R parse(I input);
    
    
}
