package com.liaoxukai.springboot_quick.config;/*
 *@author:kai
 *@create:2019-11-2019/11/2-19:07
 */

import com.liaoxukai.springboot_quick.component.LoginHadleInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter  {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){

        WebMvcConfigurerAdapter webMvcConfigurerAdapter=new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("index.html").setViewName("login");
                registry.addViewController("main.html").setViewName("hello");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                registry.addInterceptor(new LoginHadleInterceptor())
                        .addPathPatterns("/main.html");
//                        .excludePathPatterns("/","/index.html","/emps/login");


            }
        };

        return webMvcConfigurerAdapter;
    }



}
