package com.enjoy.gc;

import com.enjoy.spring.entity.X;
import com.enjoy.spring.entity.Y;

/**
    在java中，可以作为GC Roots的对象有
    1、虚拟机栈（栈帧中的本地变量表）中的引用对象
    2、方法区中的类静态属性引用对象
    3、方法区中的常量引用对象
    4、本地方法栈中的JNI（即一般说的native方法）中引用的对象
 **/
public class GCRootDemo {
    private byte[] array = new byte[100*1024*1024];
    private static X x;
    private static Y y = new Y();
    public static void main(String[] args) {
        GCRootDemo gcRootDemo = new GCRootDemo();
        System.gc();
        System.out.println("=====");

    }
}
