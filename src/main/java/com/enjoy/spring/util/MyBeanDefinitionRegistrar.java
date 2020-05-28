package com.enjoy.spring.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enjoy.spring.annotation.MyScan;
import com.enjoy.spring.dao.OrderMapper;
import com.enjoy.spring.dao.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//扫描
		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MyScan.class.getName());
		Object object = annotationAttributes.get("value");
		System.out.println(object);
		List<Class> mappers = new ArrayList<Class>();
		mappers.add(UserMapper.class);
		mappers.add(OrderMapper.class);
		for (Class mapper : mappers) {
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
			AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);;
			beanDefinition.setBeanClass(MyFactoryBean2.class);
			registry.registerBeanDefinition(mapper.getName(), beanDefinition);
		}
	}
}
