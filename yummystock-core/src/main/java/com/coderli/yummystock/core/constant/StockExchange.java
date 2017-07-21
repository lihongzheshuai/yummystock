package com.coderli.yummystock.core.constant;

/**
 * @author li.hzh
 * @date 2016-12-03 00:34
 */
public enum StockExchange {
    
    SHANGHAI("sh"), SHENZHEN("sz");
    
    private String shortSpell;
    
    StockExchange(String shortSpell) {
        this.shortSpell = shortSpell;
    }
    
    public String forShort() {
        return shortSpell;
    }
}
