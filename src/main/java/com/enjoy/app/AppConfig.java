package com.enjoy.app;

import com.enjoy.spring.annotation.MyScan;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
不加@Configuration注解也会作为注解类，加了注解是full，beanDef.setAttribute(CONFIGURATION_CLASS_ATTRIBUTE, CONFIGURATION_CLASS_FULL);
 不加是lite，beanDef.setAttribute(CONFIGURATION_CLASS_ATTRIBUTE, CONFIGURATION_CLASS_LITE);
 加了注解会被cglib代理，不加有可能会new两次
 @Bean
 public A a(){
    new A();
 }
 @Bean
 public B b(){
 a();
 new B();
 }
 **/
@Configuration
@ComponentScan("com.enjoy.spring")
//@EnableAspectJAutoProxy //开启AOP
//@Import(Student.class)
//@MyScan("com.enjoy.spring.dao")
@MapperScan("com.enjoy.spring.mapper")
public class AppConfig {

 /*   @Bean("y2")
    public Y y(){
        return new Y();
    }*/


 @Bean
 public SqlSessionFactory sqlSessionFactory() throws Exception {
  SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
  factoryBean.setDataSource(dataSource());
  return factoryBean.getObject();
 }

 @Bean
 public DataSource dataSource() {
  DriverManagerDataSource dataSource = new DriverManagerDataSource();
  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
  dataSource.setUrl("jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=UTF-8");
  dataSource.setUsername("root");
  dataSource.setPassword("123");
  return  dataSource;
 }


}
