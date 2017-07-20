package com.coderli.yummystock.spider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author li.hzh
 * @date 2017-07-20 14:18
 */
@Configuration
public class SpiderSystemConfig {
    
    @Bean
    @ConfigurationProperties(prefix = "spider.system")
    public SpiderSystemConfigBean spiderSystemConfigBean() {
        return new SpiderSystemConfigBean();
    }
    
}
