package com.coderli.yummystock.core.dao;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author li.hzh
 * @date 2017-07-25 22:56
 */
public abstract class BaseDao<T> {

    @Autowired
    protected MongoConnector mongoConnector;

    

}
