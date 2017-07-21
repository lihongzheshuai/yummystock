package com.coderli.yummystock.spider.config;

import lombok.Data;

/**
 * @author li.hzh
 * @date 2017-07-16 23:59
 */
@Data
public class StockCodeSpiderConfigBean {
    
    private String spiderClass;
    private String baseUrl;
    private String appkey;
    
}
