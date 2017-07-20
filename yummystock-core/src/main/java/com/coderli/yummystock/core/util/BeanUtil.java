package com.coderli.yummystock.core.util;

import org.springframework.context.ApplicationContext;

/**
 * @author li.hzh
 * @date 2017-07-20 15:19
 */
public class BeanUtil {
    
    private static ApplicationContext applicationContext;
    
    public static void setContext(ApplicationContext context) {
        applicationContext = context;
    }
    
    public static <T> T getBean(Class<T> type) {
        return applicationContext.getBean(type);
    }
}
