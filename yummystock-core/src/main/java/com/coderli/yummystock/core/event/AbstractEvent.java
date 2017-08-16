package com.coderli.yummystock.core.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author li.hzh
 * @date 2017-08-07 23:21
 */
public abstract class AbstractEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public AbstractEvent(Object source) {
        super(source);
    }
}
