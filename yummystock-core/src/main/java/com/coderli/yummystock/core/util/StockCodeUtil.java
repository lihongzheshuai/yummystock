package com.coderli.yummystock.core.util;

import com.coderli.yummystock.core.constant.StockExchange;
import lombok.NonNull;

/**
 * @author li.hzh
 * @date 2016-12-02 23:35
 */
public class StockCodeUtil {
    
    /**
     * Whether the given stock code is on Shanghai Stock Exchange。
     *
     * @param stockCode Not Null
     * @return
     */
    public static boolean isSH(@NonNull String stockCode) {
        return !stockCode.startsWith("00");
    }
    
    /**
     * eg. input "600887" output "sh600887"
     *
     * @param stockCode
     * @return
     */
    public static String getFullStockCode(@NonNull String stockCode) {
        String prefix = StockExchange.SHENZHEN.forShort();
        if (isSH(stockCode)) {
            prefix = StockExchange.SHANGHAI.forShort();
        }
        return prefix + stockCode;
    }
}
