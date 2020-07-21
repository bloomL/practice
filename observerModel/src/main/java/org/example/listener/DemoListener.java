package org.example.listener;

import org.example.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author liguo
 * @Description  定义事件监听者，实现ApplicationListener
 * @date 2020/6/28/028 10:38
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        String message = event.getMessage();
        System.out.println("接收到信息："+message);
    }
}
