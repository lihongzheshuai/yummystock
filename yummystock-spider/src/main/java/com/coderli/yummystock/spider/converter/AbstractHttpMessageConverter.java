package com.coderli.yummystock.spider.converter;

import com.coderli.yummystock.core.http.HttpResponseMessageConverter;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-19 11:06
 */
public abstract class AbstractHttpMessageConverter<T> implements HttpResponseMessageConverter<T> {
    
    
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return true;
    }
    
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return true;
    }
    
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(MediaType.ALL);
    }
    
}
