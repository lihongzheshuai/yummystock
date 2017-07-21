package com.coderli.yummystock.core.util;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author li.hzh
 * @date 2016-12-04 00:33
 */
@Slf4j
public class UrlUtil {
    
    public static String generateParamPairStr(@NonNull String key, @NonNull String value) {
        return key + "=" + value;
    }
    
    public static String composedParamPairsString(@NonNull String... paramsPairs) {
        String result = null;
        if (paramsPairs.length == 0) {
            log.warn("Input param pairs are empty.");
            return "";
        }
        result = paramsPairs[0];
        for (int i = 1; i < paramsPairs.length; i++) {
            result += "&" + paramsPairs[i];
        }
        return result;
    }
    
}
