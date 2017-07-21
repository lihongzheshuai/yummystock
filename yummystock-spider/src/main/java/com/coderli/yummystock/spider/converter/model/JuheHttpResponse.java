package com.coderli.yummystock.spider.converter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author li.hzh
 * @date 2017-07-19 11:00
 */
@Data
@JsonIgnoreProperties({"resultcode"})
public class JuheHttpResponse {
    
    @JsonProperty("error_code")
    private int errorCode;
    private String reason;
    @JsonProperty("result")
    private JuheHttpPageResult pageResult;
    
    @Data
    @JsonIgnoreProperties({"result"})
    public static class ErrorJuheHttpResponse extends JuheHttpResponse {
        @JsonProperty("resultcode")
        private int resultCode;
        private String reason;
        @JsonProperty("error_code")
        private int errorCode;
    }
    
}
