package com.coderli.yummystock.spider;

import com.coderli.yummystock.core.util.BeanUtil;
import com.coderli.yummystock.spider.config.SpiderSystemConfigBean;
import com.coderli.yummystock.spider.initializer.DefaultStockCodeInitializer;
import com.coderli.yummystock.spider.initializer.StockCodeInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.CountDownLatch;

/**
 * @author li.hzh
 * @date 2017-07-20 14:06
 */
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.coderli.yummystock.spider", "com.coderli.yummystock.core"})
@PropertySource("classpath:application.properties")
@Slf4j
public class Bootstrap {
    
    private static CountDownLatch latch = new CountDownLatch(1);
    
    public static void main(String[] args) throws InterruptedException {
        log.info("Starting Yummy Stock Spider.....");
        initContext(args);
        //判断是否需要初始化历史数据
        if (needsInitData()) {
            log.info("Needs initialize history data.");
            initData();
        }
        log.info("Yummy Stock Spider started!!!!");
        waitfor();
    }
    
    private static void waitfor() throws InterruptedException {
        latch.await();
    }
    
    /**
     * 初始化股票列表和股票历史数据
     */
    private static void initData() {
        StockCodeInitializer stockCodeInitializer = new DefaultStockCodeInitializer();
        stockCodeInitializer.init();
    }
    
    private static boolean needsInitData() {
        SpiderSystemConfigBean systemConfig = BeanUtil.getBean(SpiderSystemConfigBean.class);
        return systemConfig.isInitData();
    }
    
    private static void initContext(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Bootstrap.class);
        BeanUtil.setContext(applicationContext);
    }
    
}
