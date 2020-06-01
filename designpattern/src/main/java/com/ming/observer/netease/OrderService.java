package com.ming.observer.netease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void saveOrder(){

        // 1.订单入库
        System.out.println("1.订单创建成功");

        applicationContext.publishEvent(new OrderEvent("参数"));

//        // 2.发送短信
//        System.out.println("2.发送短信");
//
//        // 3.发送微信
//        System.out.println("3.发送微信");

    }
}
