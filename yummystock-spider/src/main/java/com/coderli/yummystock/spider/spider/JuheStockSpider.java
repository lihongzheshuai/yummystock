package com.coderli.yummystock.spider.spider;

import com.coderli.yummystock.core.entity.Stock;
import com.coderli.yummystock.core.http.HttpClient;
import com.coderli.yummystock.core.http.impl.SimpleRestHttpClient;
import com.coderli.yummystock.core.util.PageUtil;
import com.coderli.yummystock.spider.converter.JuheStockMessageConverter;
import com.coderli.yummystock.spider.converter.model.JuheHttpPageResult;
import com.coderli.yummystock.spider.converter.model.JuheHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-17 22:58
 */
@Slf4j
@Component
public class JuheStockSpider extends AbstractStockSpider {
    
    private static final String SH_URL_PATH = "shall";
    private static final String SZ_URL_PATH = "szall";
    private static final String PARAM_STOCK_A = "stock=a";
    private static final String PARAM_PAGE = "page=";
    private static final String PARAM_PAGE_COUNT = "type=";
    private static final String PARAM_APPKEY = "key=";
    private static final int PAGE_COUNT_TYPE = 4;
    
    private HttpClient httpClient = new SimpleRestHttpClient(new JuheStockMessageConverter());
    
    @Override
    public List<Stock> getAllSZStocks() {
        int page = 1;
        List<Stock> result = new ArrayList<>();
        JuheHttpResponse response = getByPages(SZ_URL_PATH, page, PAGE_COUNT_TYPE);
        if (!isSuccess(response)) {
            log.warn("Get all sz stock error. Page: {}, With reason: {}.", page, response.getReason());
        }
        JuheHttpPageResult pageResult = response.getPageResult();
        result.addAll(pageResult.getData());
        int totalPages = PageUtil.calcTotalPageCount(pageResult.getTotalCount(), pageResult.getNum());
        for (page = 2; page <= totalPages; page++) {
            response = getByPages(SZ_URL_PATH, page, PAGE_COUNT_TYPE);
            if (!isSuccess(response)) {
                log.warn("Get all sz stock error. Page: {}, With reason: {}.", page, response.getReason());
            }
            pageResult = response.getPageResult();
            result.addAll(pageResult.getData());
        }
        return result;
    }
    
    private JuheHttpResponse getByPages(String type, int pageNum, int pageCountType) {
        String szGetUrl = generateUrl(type, pageNum, pageCountType);
        return httpClient.getObject(szGetUrl, JuheHttpResponse.class);
    }
    
    private boolean isSuccess(JuheHttpResponse response) {
        return response.getErrorCode() == 0;
    }
    
    @Override
    public List<Stock> getAllSHStocks() {
        int page = 1;
        int pageCount = 80;
        List<Stock> result = new ArrayList<>();
        JuheHttpResponse response = getByPages(SH_URL_PATH, page, pageCount);
        if (!isSuccess(response)) {
            log.warn("Get all sz stock error. Page: {}, With reason: {}.", page, response.getReason());
        }
        return null;
    }
    
    private String generateUrl(String urlPath, int page, int count) {
        String baseUrl = getBaseUrl();
        StringBuilder builder = new StringBuilder(baseUrl);
        if (!baseUrl.endsWith("/")) {
            builder.append("/");
        }
        builder.append(urlPath).append("?")
                .append(PARAM_STOCK_A).append("&")
                .append(PARAM_PAGE).append(page).append("&")
                .append(PARAM_PAGE_COUNT).append(count).append("&")
                .append(PARAM_APPKEY).append(getAppKey());
        return builder.toString();
    }
    
}
