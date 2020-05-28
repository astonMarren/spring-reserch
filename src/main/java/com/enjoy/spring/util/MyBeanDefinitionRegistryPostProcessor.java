package com.enjoy.spring.util;

import java.util.ArrayList;
import java.util.List;

import com.enjoy.spring.dao.OrderMapper;
import com.enjoy.spring.dao.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

//@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}

	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
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
