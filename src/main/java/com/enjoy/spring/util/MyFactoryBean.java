package com.enjoy.spring.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.enjoy.spring.dao.UserMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;


/**
 * Mybatis用这种方式，mybatis实现FactoryBean接口，返回实现了mapper（dao）接口的动态代理对象，然后把MyFactoryBean放入到
 * 实现了ImportBeanDefinitionRegistrar接口的对象(MyBeanDefinitionRegistrar)中生成bd,放入到spring中
 * @author Administrator
 *
 */
//@Component
public class MyFactoryBean implements FactoryBean{

	public Object getObject() throws Exception {
		//拿到mybatis代理对象
		UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), new Class[] {UserMapper.class}, new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					System.out.println(annotation);
				}
				System.out.println(method.getName());
				return null;
			}
		});
		return userMapper;
	}

	public Class<?> getObjectType() {
		return UserMapper.class;
	}

}
