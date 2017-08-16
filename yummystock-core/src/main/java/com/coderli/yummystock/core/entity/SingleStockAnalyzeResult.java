package com.coderli.yummystock.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingleStockAnalyzeResult extends AnalyzeResult {

    private Stock stock;
    private Boolean isSatisfied;

}
