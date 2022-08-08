package com.itheima.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    //切入点表达式：execution(public User com.itheima.service.UserService.findById(int))
    /* execution：动作关键字，描述切入点的行为动作，例如execution表示执行到指定切入点
     * public:访问修饰符,还可以是public，private等，可以省略
     * User：返回值，写返回值类型
     * com.itheima.service：包名，多级包使用点连接
     * UserService:类/接口名称
     * findById：方法名
     * int:参数，直接写参数的类型，多个类型用逗号隔开
     * 异常名：方法定义中抛出指定异常，可以省略*/
    /*
     * execution(void com.itheima.dao.BookDao.update())
     * 匹配接口，能匹配到
     * execution(void com.itheima.dao.impl.BookDaoImpl.update())
     * 匹配实现类，能匹配到
     * execution(* com.itheima.dao.impl.BookDaoImpl.update())
     * 返回值任意，能匹配到
     * execution(* com.itheima.dao.impl.BookDaoImpl.update(*))
     * 返回值任意，但是update方法必须要有一个参数，无法匹配，要想匹配需要在update接口和实现类添加参数
     * execution(void com.*.*.*.*.update())
     * 返回值为void,com包下的任意包三层包下的任意类的update方法，匹配到的是实现类，能匹配
     * execution(void com.*.*.*.update())
     * 返回值为void,com包下的任意两层包下的任意类的update方法，匹配到的是接口，能匹配
     * execution(void *..update())
     * 返回值为void，方法名是update的任意包下的任意类，能匹配
     * execution(* *..*(..))
     * 匹配项目中任意类的任意方法，能匹配，但是不建议使用这种方式，影响范围广
     * execution(* *..u*(..))
     * 匹配项目中任意包任意类下只要以u开头的方法，update方法能满足，能匹配
     * execution(* *..*e(..))
     * 匹配项目中任意包任意类下只要以e结尾的方法，update和save方法能满足，能匹配
     * execution(void com..*())
     * 返回值为void，com包下的任意包任意类任意方法，能匹配，*代表的是方法
     * execution(* com.itheima.*.*Service.find*(..))
     * 将项目中所有业务层方法的以find开头的方法匹配
     * execution(* com.itheima.*.*Service.save*(..))
     * 将项目中所有业务层方法的以save开头的方法匹配
     */
    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    private void pt() {
    }

    @Before("pt()")
    public void method() {
        System.out.println(System.currentTimeMillis());
    }
}
