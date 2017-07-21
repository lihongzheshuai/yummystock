package com.coderli.yummystock.core.config;

import com.coderli.yummystock.core.dao.MongoConnector;
import com.mongodb.MongoClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author li.hzh
 * @date 2017-07-19 23:04
 */
@Configuration
@EnableMongoRepositories
public class MongoDBConfig {
    
    @Bean
    @ConfigurationProperties(prefix = "mongodb")
    public MongoDBConfigBean mongoDBConfigBean() {
        return new MongoDBConfigBean();
    }
    
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoDBConfigBean mongoConfig = mongoDBConfigBean();
        MongoClient mongoClient = new MongoClient(mongoConfig.getHost(), mongoConfig.getPort());
        return new SimpleMongoDbFactory(mongoClient, mongoConfig.getDb());
    }
    
    @Bean
    public MongoConnector yummyStockConnector() throws Exception {
        MongoDbFactory mongoDbFactory = mongoDbFactory();
//        mongoDbFactory.getDb();
        return new MongoConnector(mongoDbFactory);
    }
    
}
