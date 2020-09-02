package com.enjoy.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Caculate {
//    @Autowired
//    private BCaculate bCaculate;

    public Caculate() {
        System.out.println("Caculate 创建了");
    }

    public int getResult(int a, int b){
        System.out.println("执行方法 Caculate.getResult（）");
        return a/b;
    }
}
