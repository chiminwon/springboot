package com.ming.observer.netease;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

// Spring启动自动加载某些资源
@Component
public class LoadProductType implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // TODO Spring启动之后加载某些资源
        System.out.println("Spring启动自动加载某些资源");
    } // 监听容器的启动
}
