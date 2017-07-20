package com.coderli.yummystock.core.http.impl;

import com.coderli.yummystock.core.http.HttpResponseMessageConverter;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Default HTTP Client implementation.
 * Using Apache HttpComponents Client as the request sender.
 *
 * @author li.hzh
 * @date 2016-11-29 13:23
 */
public class SimpleRestHttpClient extends AbstractHttpClient {
    
    private RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    private HttpResponseMessageConverter converter;
    
    public SimpleRestHttpClient() {
    }
    
    public SimpleRestHttpClient(HttpResponseMessageConverter converter) {
        this.converter = converter;
        restTemplate.setMessageConverters(Collections.singletonList(converter));
    }
    
    @Override
    public <T> T getObject(String url, Class<T> type, Object... variables) {
        if (variables == null) {
            return restTemplate.getForObject(url, type);
        }
        return restTemplate.getForObject(url, type, variables);
    }
    
    
}
