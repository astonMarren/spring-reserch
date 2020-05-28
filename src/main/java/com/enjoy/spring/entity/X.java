package com.enjoy.spring.entity;

import org.springframework.stereotype.Component;

@Component
public class X {
	public X() {
		System.out.println("X无参构造方法");
	}
	
	public void doSomthing() {
		System.out.println("===doSomthing===");
	}
}
