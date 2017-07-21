package com.coderli.yummystock.spider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author li.hzh
 * @date 2017-07-16 23:59
 */
@Configuration
public class StockCodeSpiderConfig {
    
    @ConfigurationProperties(prefix = "spider.stockcodelist")
    @Bean
    public StockCodeSpiderConfigBean stockCodeSpiderConfigBean() {
        return new StockCodeSpiderConfigBean();
    }
    
}
