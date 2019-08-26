package com.coderbuff.bean;

/**
 * Created by OKevin On 2019/8/27
 */
public class Demo {
    private String name;

    public void init() {
        System.out.println("demo init.");
    }

    public void destory() {
        System.out.println("demo destory.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
