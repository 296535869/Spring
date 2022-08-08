package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {

    /*
     *SqlSessionFactoryBean是前面我们讲解FactoryBean的一个子类，
     *在该类中将SqlSessionFactory的创建进行了封装，
     *简化对象的创建，我们只需要将其需要的内容设置即可。
     *方法中有一个参数为dataSource,当前Spring容器中已经创建了Druid数据源，类型刚好是DataSource类型，
     *此时在初始化SqlSessionFactoryBean这个对象的时候，发现需要使用DataSource对象，
     *而容器中刚好有这么一个对象，就自动加载了DruidDataSource对象。
     */

    //定义bean，SqlSessionFactoryBean，用于产生SqlSessionFactory对象
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        //设置模型类的别名扫描
        ssfb.setTypeAliasesPackage("com.itheima.domain");
        //设置数据源
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

    //定义bean，返回MapperScannerConfigurer对象
    /*使用MapperScannerConfigurer加载Dao接口，创建代理对象保存到IOC容器中
     * 这个MapperScannerConfigurer对象也是MyBatis提供的专用于整合的jar包中的类，
     * 用来处理原始配置文件中的mappers相关配置，加载数据层的Mapper接口类
     * MapperScannerConfigurer有一个核心属性basePackage，就是用来设置所扫描的包路径*/
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }
}



