package com.coderli.yummystock.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author li.hzh
 * @date 2017-07-29 00:02
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "historydatametadata")
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDataMetadata {
    
    @Id
    private String code;
    private Date begin;
    private Date end;
    
    
}
