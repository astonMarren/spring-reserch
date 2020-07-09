package com.enjoy.lock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicDemo {
    public static void main(String[] args) {
        test();
        test2();
    }

    public static void test () {
        AtomicReference<Integer> atomicReference = new AtomicReference<Integer>();
        atomicReference.set(1);
        System.out.println(atomicReference.compareAndSet(1, 100));
        System.out.println(atomicReference.compareAndSet(1, 101));
        System.out.println(atomicReference.get());
    }

    public static void test2 () {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(1,1);
        atomicStampedReference.compareAndSet(1, 100, 1, 2);
        System.out.println(atomicStampedReference.getReference()+"===="+atomicStampedReference.getStamp());
    }
}
