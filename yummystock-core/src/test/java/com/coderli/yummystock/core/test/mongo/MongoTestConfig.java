package com.coderli.yummystock.core.test.mongo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author li.hzh
 * @date 2017-07-21 23:49
 */
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.coderli.yummystock.core"})
@PropertySource("classpath:application-test.properties")
public class MongoTestConfig {
}
