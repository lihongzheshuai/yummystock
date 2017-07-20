package com.coderli.yummystock.spider;

import com.coderli.yummystock.core.util.BeanUtil;
import com.coderli.yummystock.spider.config.SpiderSystemConfigBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author li.hzh
 * @date 2017-07-20 14:06
 */
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.coderli.yummystock.spider", "com.coderli.yummystock.core"})
@PropertySource("classpath:application.properties")
@Slf4j
public class Bootstrap {
    
    public static void main(String[] args) {
        log.info("Starting Yummy Stock Spider.....");
        initContext(args);
        //判断是否需要初始化历史数据
        if (needsInitData()) {
        
        }
    }
    
    private static boolean needsInitData() {
        SpiderSystemConfigBean systemConfig = BeanUtil.getBean(SpiderSystemConfigBean.class);
        return systemConfig.isInitData();
    }
    
    private static void initContext(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Bootstrap.class, args);
        BeanUtil.setContext(applicationContext);
    }
    
}
