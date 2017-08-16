package com.coderli.yummystock.core.repository;

import com.coderli.yummystock.core.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author li.hzh
 * @date 2017-08-02 16:29
 */
public interface StockRepository extends MongoRepository<Stock, String> {

}
