package com.coderbuff.provider;

import com.coderbuff.sdk.DemoService;

/**
 * Created by OKevin On 2019/9/1
 */
public class DemoServiceImpl implements DemoService {
    public String say(String name) {
        return "Hello " + name;
    }
}
