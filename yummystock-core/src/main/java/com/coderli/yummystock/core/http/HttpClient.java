package com.coderli.yummystock.core.http;

/**
 * @author li.hzh
 * @date 2016-11-29 13:21
 */
public interface HttpClient {
    
    /**
     * Use HTTP GET method to get object.
     *
     * @param url
     * @param type
     * @return
     */
    <T> T getObject(String url, Class<T> type);
    
}
