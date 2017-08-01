package com.coderli.yummystock.core.dao;

import com.coderli.yummystock.core.entity.HistoryDataMetadata;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * @author li.hzh
 * @date 2017-07-29 00:06
 */
@Repository
public class HistoryDataMetadataDao extends BaseDao<HistoryDataMetadata> {
    
    public void saveMetadata(HistoryDataMetadata metadata) {
        mongoConnector.save(metadata);
    }
    
    public HistoryDataMetadata getMetadata(String stockCode) {
        return mongoConnector.findById(stockCode, HistoryDataMetadata.class);
    }
    
    public void updateMetadata(HistoryDataMetadata metadata) {
        Query query = new Query();
        Criteria criteriaDefinition = new Criteria("_id");
        criteriaDefinition.is(metadata.getCode());
        query.addCriteria(criteriaDefinition);
        Update update = new Update();
        update.set("begin", metadata.getBegin());
        update.set("end", metadata.getEnd());
        mongoConnector.findAndModify(query, update, HistoryDataMetadata.class);
    }
    
    public void removeAll() {
        mongoConnector.removeAll(HistoryDataMetadata.class);
    }
}
