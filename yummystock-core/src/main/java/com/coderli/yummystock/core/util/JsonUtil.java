package com.coderli.yummystock.core.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author li.hzh
 * @date 2016-12-17 00:15
 */
public class JsonUtil {
    
    public static <T> T fromJson(String input, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(input, type);
    }
    
    /**
     * Find the value of the given key list in json string.
     * It used to find the value in the nest json object by the given keys.
     * eg. jsonString ={a:{b:c}}, we can find the value "c" by using key list
     * {"a","b"}
     *
     * @param jsonString
     * @param keys       key list that will be get in order
     * @return
     */
    public static String findValue(String jsonString, String... keys) {
        int length = keys.length;
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        if (length == 1) {
            return jsonObject.get(keys[0]).getAsString();
        }
        for (int i = 0; i < length - 1; i++) {
            jsonObject = jsonObject.getAsJsonObject(keys[i]);
        }
        return jsonObject.get(keys[length - 1]).toString();
    }
    
    
}
