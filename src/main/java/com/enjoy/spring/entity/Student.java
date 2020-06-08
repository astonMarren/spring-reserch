package com.enjoy.spring.entity;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class Student  implements InitializingBean{ //
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@PostConstruct
	public void init(){
		System.out.println("Student PostConstruct-----");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Student afterPropertiesSet-----");
	}
}
