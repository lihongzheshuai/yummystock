package com.coderli.yummystock.web;

import com.coderli.yummystock.web.config.ApplicationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

/**
 * YummyStock Web Launcher
 *
 * @author li.hzh
 * @date 2016-11-26 15:28
 */
@Slf4j
public class YummyStockLauncher {
    
    public static void main(String[] args) {
        log.info("Starting YummyStock.....");
        SpringApplication.run(ApplicationConfig.class, args);
        log.info("YummyStock started, enjoy it!!!");
    }
    
}
