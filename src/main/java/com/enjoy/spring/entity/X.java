package com.enjoy.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class X {
	@Autowired
	private Y y;
	public X() {
		System.out.println("X无参构造方法");
	}

/*	public X(Y y){

	}*/
	
	public void doSomthing() {
		System.out.println("===doSomthing===");
	}
}
