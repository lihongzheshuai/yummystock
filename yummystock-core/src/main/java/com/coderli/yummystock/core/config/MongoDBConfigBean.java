package com.coderli.yummystock.core.config;

import lombok.Data;

/**
 * @author li.hzh
 * @date 2017-07-19 23:04
 */
@Data
public class MongoDBConfigBean {
    
    private String host;
    private int port;
    private String userName;
    private String password;
    private String db;
    
}
