package com.coderli.yummystock.core.test.http;

import com.coderli.yummystock.core.http.HttpClient;
import com.coderli.yummystock.core.http.impl.SimpleHttpClient;
import org.junit.Before;
import org.junit.Test;

/**
 * @author li.hzh
 * @date 2016-11-29 23:38
 */
public class SimpleHttpClientTest {
    
    private HttpClient httpClient;
    
    @Before
    public void init() {
        httpClient = new SimpleHttpClient();
    }
    
    @Test
    public void testGetForObject() {
        String url = "http://web.sqt.gtimg.cn/q=sh600887";
        System.out.println(httpClient.getObject(url, String.class, null));
    }
}
