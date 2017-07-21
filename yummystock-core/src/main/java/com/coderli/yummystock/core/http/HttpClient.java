package com.coderli.yummystock.core.http;

import java.io.OutputStream;

/**
 * @author li.hzh
 * @date 2016-11-29 13:21
 */
public interface HttpClient {
    
    /**
     * @param url
     * @param type
     * @param variables
     * @return
     */
    <T> T getObject(String url, Class<T> type, Object... variables);
    
    /**
     * 发送Get请求，将结果写入给定输出流
     *
     * @param os
     */
    void writeToStream(String url, OutputStream os);
}
