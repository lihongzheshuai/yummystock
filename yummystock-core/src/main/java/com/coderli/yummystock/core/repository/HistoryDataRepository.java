package com.coderli.yummystock.core.repository;

import com.coderli.yummystock.core.entity.HistoryStockData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-08-02 22:42
 */
public interface HistoryDataRepository extends MongoRepository<HistoryStockData, ObjectId> {
    
    List<HistoryStockData> findAllByStockCode(String code);
    
    HistoryStockData findByStockCodeAndDate(String code, Date date);
}
