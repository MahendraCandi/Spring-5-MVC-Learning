package com.mahendracandi.spring5mvcrestservicehelloworld.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mahendracandi.spring5mvcrestservicehelloworld")
public class AppConfig {
}
