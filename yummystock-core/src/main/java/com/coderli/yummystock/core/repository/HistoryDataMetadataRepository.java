package com.coderli.yummystock.core.repository;

import com.coderli.yummystock.core.entity.HistoryDataMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author li.hzh
 * @date 2017-08-02 22:47
 */
public interface HistoryDataMetadataRepository extends MongoRepository<HistoryDataMetadata, String> {
}
