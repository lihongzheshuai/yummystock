package com.coderli.yummystock.spider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author li.hzh
 * @date 2016-11-28 23:53
 */
@Configuration
public class HistoryDataSpiderConfig {
    
    @Bean
    @ConfigurationProperties(prefix = "spider.historydata")
    public HistoryDataSpiderConfigBean historyDataSpiderConfigBean() {
        return new HistoryDataSpiderConfigBean();
    }
    
}
