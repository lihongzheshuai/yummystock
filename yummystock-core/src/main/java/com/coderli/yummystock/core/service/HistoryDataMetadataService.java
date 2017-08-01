package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.entity.HistoryDataMetadata;

/**
 * @author li.hzh
 * @date 2017-07-29 00:11
 */
public interface HistoryDataMetadataService {
    
    void saveMetadata(HistoryDataMetadata metadata);
    
    HistoryDataMetadata getMetadata(String stockCode);
    
    void updateMetadata(HistoryDataMetadata metadata);
    
    void removeAll();
}
