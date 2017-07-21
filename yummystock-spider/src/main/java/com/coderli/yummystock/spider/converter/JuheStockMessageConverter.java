package com.coderli.yummystock.spider.converter;

import com.coderli.yummystock.core.util.JsonUtil;
import com.coderli.yummystock.spider.converter.model.JuheHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.io.IOException;

/**
 * @author li.hzh
 * @date 2017-07-19 10:26
 */
@Slf4j
public class JuheStockMessageConverter extends AbstractReadOnlyHttpMessageConverter<JuheHttpResponse> {
    
    private static final String HEADER_KEY = "Content-Length";
    
    @Override
    public JuheHttpResponse read(Class<? extends JuheHttpResponse> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        JuheHttpResponse response = null;
        if (isErorr(inputMessage)) {
            response = JsonUtil.toObject(inputMessage.getBody(), JuheHttpResponse.ErrorJuheHttpResponse.class);
        } else {
            response = JsonUtil.toObject(inputMessage.getBody(), clazz);
        }
        return response;
        
    }
    
    private boolean isErorr(HttpInputMessage inputMessage) {
        return inputMessage.getHeaders().containsKey(HEADER_KEY);
    }
}
