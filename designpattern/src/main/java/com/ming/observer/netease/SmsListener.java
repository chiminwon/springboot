package com.ming.observer.netease;

import org.springframework.context.ApplicationListener;

public class SmsListener implements ApplicationListener<OrderEvent> {

    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        //TODO 实现发送短信逻辑
        System.out.println("2.发送短信");
    }
}
