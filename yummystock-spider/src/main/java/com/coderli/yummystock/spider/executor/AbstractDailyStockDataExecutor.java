package com.coderli.yummystock.spider.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author li.hzh
 * @date 2017-07-27 22:39
 */
@Slf4j
public abstract class AbstractDailyStockDataExecutor implements SpiderExecutor {
    
    @Scheduled(cron = "* 0 20 * * ?")
    public void schedule() {
        log.info("Start daily stock spider task at time {}.", new Date());
        execute();
    }
    
}
