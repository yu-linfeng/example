package com.coderbuff.bean;

import org.springframework.stereotype.Component;

/**
 * Created by OKevin On 2019/8/27
 */
@Component
public class AutoInjectionBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
