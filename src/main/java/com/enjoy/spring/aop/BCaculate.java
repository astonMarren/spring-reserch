package com.enjoy.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BCaculate {
    @Autowired
    private Caculate caculate;

    public BCaculate() {
        System.out.println("BCaculate 创建了");
    }

    public int getResult(int a, int b){
        System.out.println("执行方法 BCaculate.getResult（）");
        return a/b;
    }
}
