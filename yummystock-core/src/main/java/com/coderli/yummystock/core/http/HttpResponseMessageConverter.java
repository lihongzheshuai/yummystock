package com.coderli.yummystock.core.http;

import org.springframework.http.converter.HttpMessageConverter;

/**
 * @author li.hzh
 * @date 2017-07-19 09:13
 */
public interface HttpResponseMessageConverter<T> extends HttpMessageConverter<T> {

}
