package com.coderli.yummystock.spider.config;

import lombok.Data;

/**
 * History data spider config bean.
 * Contains the history data spider properties' values configured in
 * the application.properties. The values will be auto injected.
 *
 * @author li.hzh
 * @date 2016-11-28 23:56
 */
@Data
public class HistoryDataSpiderConfigBean {
    
    private String spiderClass;
    private String baseUrl;
    private String tempPath;
    
    
}
