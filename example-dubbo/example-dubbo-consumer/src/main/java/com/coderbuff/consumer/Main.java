package com.coderbuff.consumer;

import com.coderbuff.sdk.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by OKevin On 2019/9/1
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        DemoService demoService = (DemoService) ctx.getBean("demoService");
        System.out.println(demoService.say("OKevin"));
        while (true) {

        }
    }
}
