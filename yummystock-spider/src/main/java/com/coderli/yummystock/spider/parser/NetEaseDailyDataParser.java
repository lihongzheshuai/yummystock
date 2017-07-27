package com.coderli.yummystock.spider.parser;

import com.coderli.yummystock.core.entity.HistoryStockData;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author li.hzh
 * @date 2017-07-27 15:04
 */
public class NetEaseDailyDataParser implements DataParser<ByteArrayOutputStream, HistoryStockData> {
    
    @Override
    public HistoryStockData parse(ByteArrayOutputStream input) {
        try (BufferedReader bufferedReader = new BufferedReader(
                                                                       new InputStreamReader(
                                                                                                    new ByteArrayInputStream(input.toByteArray()), Charset.forName("gbk")))) {
            System.out.println(bufferedReader.readLine());
            String line = bufferedReader.readLine();
            System.out.println(line);
            String lineTwo = bufferedReader.readLine();
            System.out.println(lineTwo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
