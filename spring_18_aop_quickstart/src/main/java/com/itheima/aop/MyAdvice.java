package com.itheima.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
//设置当前类为AOP切面类
public class MyAdvice {
    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    //切入点定义依托一个不具有实际意义的方法进行，即无参数、无返回值、方法体无实际逻辑
    private void pt(){}

    @Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
