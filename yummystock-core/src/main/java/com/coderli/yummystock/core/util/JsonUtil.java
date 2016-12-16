package com.coderli.yummystock.core.util;

import com.google.gson.Gson;

/**
 * @author li.hzh
 * @date 2016-12-17 00:15
 */
public class JsonUtil {
    
    public static <T> T fromJson(String input, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(input, type);
    }
    
    
}
