package com.enjoy.spring.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;


/**
 * Mybatis用这种方式
 * @author Administrator
 *
 */
//@Component
public class MyFactoryBean2 implements FactoryBean{
	
	private Class mapper;
	
	public MyFactoryBean2(Class mapper) {
		this.mapper = mapper;
	}

	public Object getObject() throws Exception {
		//拿到mybatis代理对象
		Object o = Proxy.newProxyInstance(MyFactoryBean2.class.getClassLoader(), new Class[] {mapper}, new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					System.out.println(annotation);
				}
				System.out.println("zzz");
				return null;
			}
		});
		return o;
	}

	public Class<?> getObjectType() {
		return mapper;
	}

}
