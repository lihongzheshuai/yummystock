package com.coderli.yummystock.core.test.util;

import com.coderli.yummystock.core.util.StockCodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author li.hzh
 * @date 2016-12-03 00:43
 */
public class StockCodeUtilTest {
    
    @Test
    public void getFullStockCodeTest() {
        String sh = "600887";
        String sz = "000100";
        String cy = "300100";
        String zx = "002358";
        Assert.assertEquals(("sh600887"),StockCodeUtil.getFullStockCode(sh));
        Assert.assertEquals(("sz000100"),StockCodeUtil.getFullStockCode(sz));
        Assert.assertEquals(("sh300100"),StockCodeUtil.getFullStockCode(cy));
        Assert.assertEquals(("sz002358"),StockCodeUtil.getFullStockCode(zx));
    }
    
    
}
