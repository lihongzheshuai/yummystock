package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.dao.HistoryDataMetadataDao;
import com.coderli.yummystock.core.entity.HistoryDataMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.hzh
 * @date 2017-07-29 00:13
 */
@Service
public class HistoryDataMetadataServiceImpl implements HistoryDataMetadataService {
    
    @Autowired
    private HistoryDataMetadataDao metadataDao;
    
    @Override
    public void saveMetadata(HistoryDataMetadata metadata) {
        metadataDao.saveMetadata(metadata);
    }
    
    @Override
    public HistoryDataMetadata getMetadata(String stockCode) {
        return metadataDao.getMetadata(stockCode);
    }
    
    @Override
    public void updateMetadata(HistoryDataMetadata metadata) {
        metadataDao.updateMetadata(metadata);
    }
    
    @Override
    public void removeAll() {
        metadataDao.removeAll();
    }
}
