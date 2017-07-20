package com.coderli.yummystock.core.config;

import com.coderli.yummystock.core.dao.MongoConnector;
import com.mongodb.MongoClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @author li.hzh
 * @date 2017-07-19 23:04
 */
@Configuration
public class MongoDBConfig {
    
    @Bean
    @ConfigurationProperties(prefix = "mongodb")
    public MongoDBConfigBean mongoDBConfigBean() {
        return new MongoDBConfigBean();
    }
    
    @Bean
    public MongoClientFactoryBean mongoClientFactory() {
        MongoClientFactoryBean mongoClientFactory = new MongoClientFactoryBean();
        MongoDBConfigBean config = mongoDBConfigBean();
        mongoClientFactory.setHost(config.getHost());
        mongoClientFactory.setPort(config.getPort());
        return mongoClientFactory;
    }
    
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory((MongoClient) mongoClientFactory().getObject(), mongoDBConfigBean().getDb());
    }
    
    @Bean
    public MongoConnector mongoTemplate() throws Exception {
        return new MongoConnector(mongoDbFactory());
    }
    
}
