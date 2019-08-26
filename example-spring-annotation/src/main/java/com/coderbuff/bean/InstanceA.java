package com.coderbuff.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by OKevin On 2019/8/27
 */
public class InstanceA {

    @Autowired
    private InstanceB instanceB;

    public InstanceB getInstanceB() {
        return instanceB;
    }

    public void setInstanceB(InstanceB instanceB) {
        this.instanceB = instanceB;
    }
}
