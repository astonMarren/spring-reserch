package com.enjoy.spring.test;

import com.enjoy.app.AppConfig;
import com.enjoy.spring.dao.OrderMapper;
import com.enjoy.spring.dao.UserMapper;
import com.enjoy.spring.entity.Y;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//		X x = (X)ctx.getBean("x");
//		System.out.println(x);
//		System.out.println(ctx.getBean(Y.class));
//		System.out.println(ctx.getBean("y2"));
//		System.out.println(ctx.getBean("myFactoryBean"));
//		System.out.println(ctx.getBean(Z.class));
		UserMapper userMapper = ctx.getBean(UserMapper.class); //type注入
		System.out.println("userMapper" + userMapper.getClass());
		userMapper.insert();
//		System.out.println(ctx.getBean("myFactoryBean").getClass()); //type注入
//		OrderMapper orderMapper = ctx.getBean(OrderMapper.class); //type注入
//		userMapper.insert();
//		orderMapper.insert();
//		doSomething();
//		System.out.println(ctx.getBean("z"));
		ctx.close();
	}

	public static void doSomething() {

	}
}
