package com.enjoy.spring.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import com.enjoy.spring.util.MyBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;



@Retention(RetentionPolicy.RUNTIME)
@Import({MyBeanDefinitionRegistrar.class})
public @interface MyScan {
	String value() default "";
}
