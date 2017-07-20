package com.coderli.yummystock.spider.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * @author li.hzh
 * @date 2017-07-19 11:11
 */
@Slf4j
public abstract class AbstractReadOnlyHttpMessageConverter<T> extends AbstractHttpMessageConverter<T> {
    
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return false;
    }
    
    @Override
    public void write(T t, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        log.error("Unsupported operation.");
    }
    
}
