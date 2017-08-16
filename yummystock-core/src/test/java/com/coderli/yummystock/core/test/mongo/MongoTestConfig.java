package com.coderli.yummystock.core.test.mongo;

import com.coderli.yummystock.core.config.MongoDBConfig;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author li.hzh
 * @date 2017-07-21 23:49
 */
@ComponentScan(basePackages = {"com.coderli.yummystock.core"})
@PropertySource("classpath:application-test.properties")
@EnableMongoRepositories(basePackages = "com.coderli.yummystock.core.repository")
@Configuration
public class MongoTestConfig {


}
