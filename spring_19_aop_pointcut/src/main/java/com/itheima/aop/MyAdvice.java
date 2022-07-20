package com.itheima.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    //切入点表达式：
//    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
//    @Pointcut("execution(void com.itheima.dao.impl.BookDaoImpl.update())")
//    @Pointcut("execution(* com.itheima.dao.impl.BookDaoImpl.update())")
//    @Pointcut("execution(* com.itheima.dao.impl.BookDaoImpl.update(*))")no
//    @Pointcut("execution(void com.*.*.*.*.update())")
//    @Pointcut("execution(void *..update())")
//    @Pointcut("execution(* *..*(..))")
//    @Pointcut("execution(* *..*e(..))")
//    @Pointcut("execution(void com..*())")
//    @Pointcut("execution(* com.itheima.*.*Service.find*(..))")
//    @Pointcut("execution(* com.itheima.*.*Service.save(..))")
    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    private void pt() {
    }

    @Before("pt()")
    public void method() {
        System.out.println(System.currentTimeMillis());
    }
}
