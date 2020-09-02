package com.enjoy.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Y {
	@Autowired
	private X x;
	public Y() {
		System.out.println("Y无参构造方法");
	}

}
