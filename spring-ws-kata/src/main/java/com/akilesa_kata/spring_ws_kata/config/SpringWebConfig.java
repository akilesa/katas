package com.akilesa_kata.spring_ws_kata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by akilesa on 04.10.15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.akilesa_kata.ws_spring_kata.controllers"})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("WEB-INF/static/views/");
        bean.setSuffix(".jsp");
        bean.setViewClass(JstlView.class);
        return bean;
    }
}
