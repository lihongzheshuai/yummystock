package com.coderli.yummystock.test.spider;

import com.coderli.yummystock.spider.config.HistoryDataSpiderConfigBean;
import com.coderli.yummystock.spider.config.StockCodeSpiderConfigBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author li.hzh
 * @date 2016-12-05 23:55
 */
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.coderli.yummystock.spider", "com.coderli.yummystock.core.config", "com.coderli.yummystock.core.service"})
@PropertySource("classpath:application-test.properties")
public class SpiderTestConfig {
    
    @Bean
    @ConfigurationProperties(prefix = "spider.historydata")
    public HistoryDataSpiderConfigBean historyDataSpiderConfigBean() {
        return new HistoryDataSpiderConfigBean();
    }
    
    @Bean
    @ConfigurationProperties(prefix = "spider.stockcodelist")
    public StockCodeSpiderConfigBean stockCodeSpiderConfigBean() {
        return new StockCodeSpiderConfigBean();
    }
}
