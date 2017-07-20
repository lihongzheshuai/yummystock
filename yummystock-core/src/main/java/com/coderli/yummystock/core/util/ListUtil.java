package com.coderli.yummystock.core.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-17 22:44
 */
@Slf4j
public class ListUtil {
    
    public static <T> List<T> merge(List<T> listOne, List<T> listTwo) {
        List<T> all = new ArrayList<>();
        if (listOne == null && listTwo == null) {
            log.warn("Both list to be merged are null.");
        } else if (listOne == null) {
            all.addAll(listTwo);
        } else if (listTwo == null) {
            all.addAll(listOne);
        } else {
            all.addAll(listOne);
            all.addAll(listTwo);
        }
        return all;
    }
    
    
}
