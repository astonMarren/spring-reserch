package com.enjoy.app;

import com.enjoy.spring.annotation.MyScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.enjoy.spring")
@MyScan("com.enjoy.spring.dao")
public class AppConfig {
}
