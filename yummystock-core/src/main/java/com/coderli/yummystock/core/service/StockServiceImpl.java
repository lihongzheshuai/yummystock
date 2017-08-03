package com.coderli.yummystock.core.service;

import com.coderli.yummystock.core.dao.StockDao;
import com.coderli.yummystock.core.entity.Stock;
import com.coderli.yummystock.core.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-20 23:04
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService {
    
    private StockDao stockDao;
    @Autowired
    private StockRepository stockRepository;
    
    @Override
    public void saveStocks(List<Stock> stocks) {
        log.debug("Save stocks.");
        stockRepository.insert(stocks);
    }
    
    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
    
    @Override
    public void removeAll() {
        stockRepository.deleteAll();
    }
    
}
