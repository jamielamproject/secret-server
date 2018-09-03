package com.jamie.secret;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.jamie.secret.jwt.security.JwtAuthenticationFilter;
import com.jamie.secret.jwt.security.JwtUtil;


@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@RestController
public class Application extends SpringBootServletInitializer{

	 @Autowired
     private ServletContext servletContext;
	 
	 @Autowired
	 private JwtAuthenticationFilter filter;
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
	 }
	 
   public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
   }
   
   @PostConstruct
   public void showIt() {
       System.out.println("Serve Base Path :"+servletContext.getContextPath());
   }
   
   @Bean
   public FilterRegistrationBean filterRegistrationBean() {
       FilterRegistrationBean registrationBean = new FilterRegistrationBean();
       CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
       characterEncodingFilter.setEncoding("UTF-8");
       registrationBean.setFilter(characterEncodingFilter);
       return registrationBean;
   }
	
   //Token filter
   @Bean
   public FilterRegistrationBean jwtFilter() {
       final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
       registrationBean.setFilter(filter);
       return registrationBean;
   }
}
