package org.example.publisher;

import org.example.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author liguo
 * @Description 发布事件
 * @date 2020/6/28/028 10:44
 */
@Component
public class DemoPublisher {

    @Autowired
    ApplicationContext applicationContext;

    public void publisher(String message){
        applicationContext.publishEvent(new DemoEvent(this,message));
    }
}
