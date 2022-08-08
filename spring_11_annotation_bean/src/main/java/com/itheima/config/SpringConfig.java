package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//声明当前类为Spring配置类 在配置类上添加@Configuration注解，将其标识为一个配置类,替换applicationContext.xml
@Configuration
//设置bean扫描路径，多个路径书写为字符串数组格式
//在配置类上添加包扫描注解`@ComponentScan`替换`<context:component-scan base-package=""/>`
@ComponentScan({"com.itheima.service","com.itheima.dao"})
public class SpringConfig {
}
