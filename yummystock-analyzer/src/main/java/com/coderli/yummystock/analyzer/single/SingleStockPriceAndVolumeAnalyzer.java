package com.coderli.yummystock.analyzer.single;

import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.entity.SingleStockAnalyzeResult;

import java.util.List;

public class SingleStockPriceAndVolumeAnalyzer implements Analyzer<List<HistoryStockData>, SingleStockAnalyzeResult> {
    @Override
    public SingleStockAnalyzeResult analyze(List<HistoryStockData> stockDataList) {
        return null;
    }
}
