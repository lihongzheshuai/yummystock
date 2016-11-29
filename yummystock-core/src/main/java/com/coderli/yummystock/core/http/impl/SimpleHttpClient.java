package com.coderli.yummystock.core.http.impl;

import com.coderli.yummystock.core.http.HttpClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Default HTTP Client implementation.
 * Using Apache HttpComponents Client as the request sender.
 *
 * @author li.hzh
 * @date 2016-11-29 13:23
 */
@Component
@Scope(value = "prototype")
public class SimpleHttpClient implements HttpClient {
    
    private RestTemplate restTemplate = new RestTemplate();
    
    @Override
    public <T> T getObject(String url, Class<T> type) {
        return null;
    }
}
