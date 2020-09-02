package com.enjoy.spring.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.enjoy.app.AppConfig;
import com.enjoy.spring.annotation.MyScan;
import com.enjoy.spring.dao.OrderMapper;
import com.enjoy.spring.dao.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * 容器扫描的时候放到BDmap里面，在refresh()->invokeBeanFactoryPostProcessors(beanFactory);里面执行
 * ImportBeanDefinitionRegistrar在容器扫描的时候执行
 **/
//@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("BeanDefinitionRegistryPostProcessor.postProcessBeanFactory()");
	}

	public void  postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
	/*	Class<AppConfig> appConfigClass = AppConfig.class;
		MyScan annotation = appConfigClass.getAnnotation(MyScan.class);
		System.out.println("MyBeanDefinitionRegistryPostProcessor ======" + annotation.value());
		List<Class> mappers = new ArrayList<Class>();
		mappers.add(UserMapper.class);
		mappers.add(OrderMapper.class);
		for (Class mapper : mappers) {
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
			AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);;
			beanDefinition.setBeanClass(MyFactoryBean2.class);
			registry.registerBeanDefinition(mapper.getName(), beanDefinition);
		}*/

		System.out.println("BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");
	}

}
