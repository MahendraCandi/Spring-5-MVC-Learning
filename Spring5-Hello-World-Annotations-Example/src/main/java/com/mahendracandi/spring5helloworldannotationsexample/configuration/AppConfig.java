package com.mahendracandi.spring5helloworldannotationsexample.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc //sama sepertu mvc:annotation-driven di xml
@ComponentScan(basePackages = "com.mahendracandi.spring5helloworldannotationsexample")
public class AppConfig {
    private final static Logger log = Logger.getLogger(AppConfig.class);
    
    @Bean
    public ViewResolver viewResolver(){
        log.info("----------MASUK KE VIEW RESOLVER----------");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
