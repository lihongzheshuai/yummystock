package com.coderli.yummystock.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.NonNull;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author li.hzh
 * @date 2016-12-17 00:15
 */
public class JsonUtil {
    
    public static <T> T fromJson(String input, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(input, type);
    }
    
    
    public static <T> T toObject(@NonNull InputStream is, Class<T> type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is, type);
    }
}
