package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.entity.HistoryDataMetadata;
import com.coderli.yummystock.core.repository.HistoryDataMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.hzh
 * @date 2017-07-29 00:13
 */
@Service
public class HistoryDataMetadataServiceImpl implements HistoryDataMetadataService {
    
    @Autowired
    private HistoryDataMetadataRepository metadataRepository;
    
    @Override
    public void saveMetadata(HistoryDataMetadata metadata) {
        metadataRepository.save(metadata);
    }
    
    @Override
    public HistoryDataMetadata getMetadata(String stockCode) {
        return metadataRepository.findOne(stockCode);
    }
    
    @Override
    public void updateMetadata(HistoryDataMetadata metadata) {
        metadataRepository.save(metadata);
    }
    
    @Override
    public void removeAll() {
        metadataRepository.deleteAll();;
    }
}
