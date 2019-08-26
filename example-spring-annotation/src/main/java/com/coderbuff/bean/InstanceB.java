package com.coderbuff.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by OKevin On 2019/8/27
 */
public class InstanceB {

    @Autowired
    private InstanceA instanceA;

    public InstanceA getInstanceA() {
        return instanceA;
    }

    public void setInstanceA(InstanceA instanceA) {
        this.instanceA = instanceA;
    }
}
