package com.coderbuff.aop;

import org.aspectj.lang.annotation.*;

/**
 * 日志切面类
 * Created by OKevin On 2019/8/28
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.coderbuff.bean.Calc.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart() {
        System.out.println("开始运行，参数={}");
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("结束运行");
    }

    @AfterReturning("pointCut()")
    public void logReturn() {
        System.out.println("正常返回，结果={}");
    }

    @AfterThrowing("pointCut()")
    public void logException() {
        System.out.println("运行异常，{}");
    }
}
