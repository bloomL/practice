package org.example.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author liguo
 * @Description  定义事件
 * @date 2020/6/28/028 10:34
 */
@Component
public class DemoEvent extends ApplicationEvent {

    private String message;

    public DemoEvent(Object source,String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
