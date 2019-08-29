package com.coderbuff.bean;

import org.springframework.stereotype.Component;

/**
 * 用于AOP测试
 * Created by OKevin On 2019/8/28
 */
@Component
public class Calc {

    public Integer div(Integer a, Integer b) {
        return a / b;
    }
}
