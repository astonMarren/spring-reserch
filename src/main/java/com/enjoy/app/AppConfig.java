package com.enjoy.app;

import com.enjoy.spring.annotation.MyScan;
import com.enjoy.spring.entity.Student;
import com.enjoy.spring.entity.Y;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.enjoy.spring")
@EnableAspectJAutoProxy //开启AOP
//@Import(Student.class)
@MyScan("com.enjoy.spring.dao")
//MapperScan
public class AppConfig {

 /*   @Bean("y2")
    public Y y(){
        return new Y();
    }*/
}
