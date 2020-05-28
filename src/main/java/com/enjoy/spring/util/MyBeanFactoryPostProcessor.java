package com.enjoy.spring.util;

import com.enjoy.spring.entity.Y;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;


@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		GenericBeanDefinition x = (GenericBeanDefinition) beanFactory.getBeanDefinition("x");
//		x.setBeanClass(Y.class);
		beanFactory.registerSingleton("y", Y.class);
	}

}
