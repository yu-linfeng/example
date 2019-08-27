package com.coderbuff.config;

import com.coderbuff.bean.Demo;
import com.coderbuff.bean.InstanceA;
import com.coderbuff.bean.InstanceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by OKevin On 2019/8/27
 */
@PropertySource(value = {"classpath:/app.properties"})
@Configuration
@ComponentScan(value = "com.coderbuff")
public class Config {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Demo demo() {
        return new Demo();
    }

    @Bean
    public InstanceA instanceA() {
        return new InstanceA();
    }

    @Bean
    public InstanceB instanceB() {
        return new InstanceB();
    }
}
