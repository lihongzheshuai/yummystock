package com.coderli.yummystock.core.config;

import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author li.hzh
 * @date 2017-07-19 23:04
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.coderli.yummystock.core.repository")
@Import({MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class MongoDBConfig {
    
}
