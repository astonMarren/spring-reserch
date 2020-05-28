package com.enjoy.spring.util;

import java.util.ArrayList;
import java.util.List;

import com.enjoy.spring.dao.OrderMapper;
import com.enjoy.spring.dao.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//@Component
public class MyBeanFactoryPostProcessor2 implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		List<Class> mappers = new ArrayList<Class>();
		//Srping这里用的是扫描
		mappers.add(UserMapper.class);
		mappers.add(OrderMapper.class);
		for (Class mapper : mappers) {
			
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
			AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);;
			beanDefinition.setBeanClass(MyFactoryBean2.class);
			/*
			 * 这里的bd没办法放入到spring，可以在配置类AppConfig上采用import注解和ImportBeanDefinitionRegistrar搭配使用
			 * import如果导入的是实现了ImportBeanDefinitionRegistrar接口的类，会执行registerBeanDefinitions方法，生成bd，
			 * 放入到spring中,但是AnnotationMetadata可以获取到注解上面的包，mybatis采用这种方式
			 * 方法二：实现BeanDefinitionRegistryPostProcessor接口的类，执行postProcessBeanDefinitionRegistry方法生成bd,
			 * 这种方法可以生成db，但是没办法获取到到添加了scan注解包
			 */
			
		}
		
	}

}
