package com.coderli.yummystock.core.util;

/**
 * @author li.hzh
 * @date 2017-07-18 16:28
 */
public class PageUtil {
    
    /**
     * 计算一共有多少页
     *
     * @param totalNum     总条数
     * @param countPerPage 每页条数
     * @return
     */
    public static int calcTotalPageCount(int totalNum, int countPerPage) {
        int tempPageCount = totalNum / countPerPage;
        return totalNum % countPerPage == 0 ? tempPageCount :
                       tempPageCount + 1;
    }
    
}
