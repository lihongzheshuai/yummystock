package com.coderli.yummystock.core.dao;

import com.mongodb.Mongo;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

/**
 * @author li.hzh
 * @date 2017-07-19 22:50
 */
@Repository
public class MongoConnector extends MongoTemplate {
    
    
    public MongoConnector(Mongo mongo, String databaseName) {
        super(mongo, databaseName);
    }
    
    public MongoConnector(Mongo mongo, String databaseName, UserCredentials userCredentials) {
        super(mongo, databaseName, userCredentials);
    }
    
    public MongoConnector(MongoDbFactory mongoDbFactory) {
        super(mongoDbFactory);
    }
    
    public MongoConnector(MongoDbFactory mongoDbFactory, MongoConverter mongoConverter) {
        super(mongoDbFactory, mongoConverter);
    }
}
