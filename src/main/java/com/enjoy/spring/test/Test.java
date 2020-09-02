package com.enjoy.spring.test;

import com.enjoy.app.AppConfig;
import com.enjoy.spring.aop.BCaculate;
import com.enjoy.spring.aop.Caculate;
import com.enjoy.spring.aop.LogAspect;
import com.enjoy.spring.dao.OrderMapper;
import com.enjoy.spring.dao.UserMapper;
import com.enjoy.spring.entity.X;
import com.enjoy.spring.entity.Y;
import com.enjoy.spring.entity.Z;
import com.enjoy.spring.mapper.TerminalMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		System.out.println(context.getBeanFactory().getBeanDefinition("z").getClass().getSimpleName());
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("==="+ctx.getBean(TerminalMapper.class));
//		String simpleName = ctx.getBeanDefinition("appConfig").getClass().getSimpleName();
//		System.out.println(simpleName);
//		String xsimpleName = ctx.getBeanDefinition("x").getClass().getSimpleName();
//		System.out.println(xsimpleName);
//		X x = (X)ctx.getBean("x");
//		System.out.println(x);
//		System.out.println(ctx.getBean(Y.class));
//		System.out.println(ctx.getBean("y2"));
//		System.out.println(ctx.getBean("myFactoryBean"));
//		System.out.println(ctx.getBean(Z.class));
//		System.out.println(ctx.getBean(LogAspect.class));
//        Caculate bean = ctx.getBean(Caculate.class);
//        System.out.println(bean.getResult(4, 2));
//        BCaculate bean2 = ctx.getBean(BCaculate.class);
//        System.out.println(bean2.getResult(9, 3));
//		UserMapper userMapper = ctx.getBean(UserMapper.class); //type注入
//		System.out.println("userMapper" + userMapper.getClass());
//		userMapper.insert();
//		System.out.println(ctx.getBean("myFactoryBean").getClass()); //type注入
//		OrderMapper orderMapper = ctx.getBean(OrderMapper.class); //type注入
//		userMapper.insert();
//		orderMapper.insert();
//		doSomething();
//		System.out.println(ctx.getBean("z"));
		//ctx.close();
	}

	public static void doSomething() {

	}
}
