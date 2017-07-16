package com.coderli.yummystock.core.http.impl;

import com.coderli.yummystock.core.http.HttpClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author li.hzh
 * @date 2017-07-12 22:23
 */
@Slf4j
public abstract class AbstractHttpClient implements HttpClient {
    
    @Override
    public void writeToStream(String url, OutputStream os) {
        org.apache.http.client.HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            response.getEntity().writeTo(os);
        } catch (IOException e) {
            log.error("Get", e);
        }
    }
    
}
