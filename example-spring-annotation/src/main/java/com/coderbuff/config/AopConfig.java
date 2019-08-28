package com.coderbuff.config;

import com.coderbuff.aop.LogAspect;
import com.coderbuff.bean.Calc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP配置
 * Created by OKevin On 2019/8/28
 */
@EnableAspectJAutoProxy
@Configuration
public class AopConfig {

    @Bean
    public Calc calc() {
        return new Calc();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
